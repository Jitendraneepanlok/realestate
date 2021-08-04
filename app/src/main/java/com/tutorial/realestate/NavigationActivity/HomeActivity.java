package com.tutorial.realestate.NavigationActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tutorial.realestate.Activity.LoginActivity;
import com.tutorial.realestate.Activity.PostProperty.PostPropertyActivity;
import com.tutorial.realestate.Adapter.TopPropertiesAdapter;
import com.tutorial.realestate.Model.LogoutContantModel;
import com.tutorial.realestate.Model.LogoutModel;
import com.tutorial.realestate.Model.TopPropertiesConstantModel;
import com.tutorial.realestate.Model.TopPropertiesModel;
import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Pojo.LogoutConstantPojo;
import com.tutorial.realestate.Pojo.TopPropertiesConstantPojo;
import com.tutorial.realestate.Prefrences.SessionManager;
import com.tutorial.realestate.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    private AppBarConfiguration mAppBarConfiguration;
    SessionManager sessionManager;
    TextView tvusname;
    AppCompatTextView tv_post_property;
    View headerView;
    NavigationView navigationView;
    DrawerLayout drawer;
    String Name, UID;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // from tollbar text clicked
        tv_post_property = (AppCompatTextView) findViewById(R.id.tv_post_property);
        tv_post_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallPostProperty();
            }
        });


        sessionManager = new SessionManager(this);
        Name = sessionManager.getUserData(SessionManager.USER_NAME);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        tvusname = (TextView) headerView.findViewById(R.id.tvusname);
        tvusname.setText(Name);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_setting)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                   /* case R.id.nav_privacy:
                        String url = "https://realestate.10to100.com/privacy-policy";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                        break;

                    case R.id.nav_refund:
                        String link = "https://realestate.10to100.com/refund-policy";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(link));
                        startActivity(intent);
                        break;

                    case R.id.nav_about_us:
                        String aboutlink = "https://realestate.10to100.com/about-us";
                        Intent in = new Intent(Intent.ACTION_VIEW);
                        in.setData(Uri.parse(aboutlink));
                        startActivity(in);
                        break;
*/
                    case R.id.nav_logout:

                        OpenLoggedOutDailog();

                        break;

                }
                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem, navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    private void CallPostProperty() {
        startActivity(new Intent(getApplicationContext(), PostPropertyActivity.class));
    }

    private void OpenLoggedOutDailog() {
        Dialog dialog = new Dialog(HomeActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.logout_dialog);
        dialog.setCancelable(false);

        TextView tvcancel = (TextView) dialog.findViewById(R.id.tvcancel);
        tvcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        TextView tvyes = (TextView) dialog.findViewById(R.id.tvyes);
        tvyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                CallLogoutApi();
            }
        });

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }


    /* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.home, menu);
         return true;
     }
 */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void CallLogoutApi() {
        sessionManager = new SessionManager(getApplicationContext());
        UID = sessionManager.getUserData(SessionManager.UID);

        pDialog = new ProgressDialog(HomeActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        LogoutModel logoutModel = new LogoutModel();
        logoutModel.setuID(UID);

        LogoutContantModel logoutContantModel = new LogoutContantModel();
        logoutContantModel.setRealstate(logoutModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LogoutConstantPojo> call = apiService.postLogout(logoutContantModel);
        try {
            call.enqueue(new Callback<LogoutConstantPojo>() {
                @Override
                public void onResponse(Call<LogoutConstantPojo> call, retrofit2.Response<LogoutConstantPojo> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        sessionManager.logout();
                        pDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<LogoutConstantPojo> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(getApplicationContext(), "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }

    }

}
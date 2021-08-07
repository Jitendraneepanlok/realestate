package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Model.ForgetPasswordConstant;
import com.tutorial.realestate.Model.ForgetPasswordModel;
import com.tutorial.realestate.Model.LoginData;
import com.tutorial.realestate.Model.LoginModel;
import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.Pojo.ForgetPasswordPojo;
import com.tutorial.realestate.Pojo.LoginResponse;
import com.tutorial.realestate.Prefrences.SessionManager;
import com.tutorial.realestate.R;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    TextView tv_register,tv_forgetpass;
    LinearLayout lllogin;
    EditText  txtEmailAddress,txtPassword;
    String et_uname,et_psss,forgetmail;
    private ProgressDialog pDialog;
    Boolean ischecked = false;
    CheckBox cb_remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.title_bar_color));
        }
        initView();
        if (isNetworkStatusAvialable(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "Internet Available", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Check your Internet");
            builder1.setCancelable(false);
            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent dialogIntent = new Intent(Settings.ACTION_SETTINGS);
                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(dialogIntent);
                }
            });
           /* builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });*/
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    private void initView() {
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtEmailAddress = (EditText)findViewById(R.id.txtEmailAddress);
        lllogin = (LinearLayout)findViewById(R.id.lllogin);
        lllogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
              //  startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
        cb_remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ischecked = isChecked;

            }
        });
        tv_register = (TextView)findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

        tv_forgetpass = (TextView)findViewById(R.id.tv_forgetpass);
        tv_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgetDialog();
            }
        });
    }

    private void Validation() {
        et_uname = txtEmailAddress.getText().toString().trim();
        et_psss = txtPassword.getText().toString().trim();

        Boolean error = true;
        Log.e("UserData", "" + et_psss + "...." + et_uname);

        if (et_uname != null) {
            if (txtEmailAddress.getText().toString().trim().length() == 0) {
                txtEmailAddress.setError("Username Cannot be Empty");
                txtEmailAddress.requestFocus();
                error = false;
            }
        } else {
            Toast.makeText(this, "Username Cannot be Empty", Toast.LENGTH_SHORT).show();
        }
        if (et_psss != null) {
            if (txtPassword.getText().toString().trim().length() == 0) {
                txtPassword.setError("Password Cannot be Empty");
                txtPassword.requestFocus();
                error = false;
            }
        } else {
            Toast.makeText(this, "Password Cannot be Empty", Toast.LENGTH_SHORT).show();
        }
        if (error) {
            LoginApi();
        } else {
            Toast.makeText(LoginActivity.this, "All Fileds Are Required", Toast.LENGTH_LONG).show();
        }

    }

    private void LoginApi() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        LoginData loginData = new LoginData();
        loginData.setRegEmail(et_uname);
        loginData.setRegUserPassword(et_psss);

        LoginModel loginModel = new LoginModel();
        loginModel.setRealstate(loginData);


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.postSignIn(loginModel);
        try {
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        Log.e("Login_Response", "" + response.body().toString());
                        Toast.makeText(LoginActivity.this, response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                        SessionManager sessionManager = new SessionManager(LoginActivity.this);
                        sessionManager.setValue(SessionManager.USER_NAME, response.body().getRealstate().getData().getEmail());
                        sessionManager.setValue(SessionManager.UID, response.body().getRealstate().getData().getId());
                        sessionManager.setValue(SessionManager.JWT_TOKEN, response.body().getRealstate().getData().getJwtTocken());
                        sessionManager.setValue(SessionManager.NAME, response.body().getRealstate().getData().getName());
                        sessionManager.setValueBoolean(SessionManager.VALUE, ischecked);

                        finish();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        pDialog.dismiss();
                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(LoginActivity.this, "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(this, "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }

    }

    private void openForgetDialog() {
        Dialog dialog = new Dialog(LoginActivity.this, R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.forget_dialog_box);
        dialog.setCancelable(false);

        LinearLayout llbtn_submit = (LinearLayout)dialog.findViewById(R.id.llbtn_submit);
        llbtn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               EditText etforget = (EditText)dialog.findViewById(R.id.etforget);
                forgetmail = etforget.getText().toString().trim();
                if (!forgetmail.equals("")){
                    forgetpassApi();

                }else {
                    etforget.setError("Please enter Register Email-Id");
                }

//                dialog.dismiss();
            }
        });

       TextView tv_forgetpass = (TextView)dialog.findViewById(R.id.tv_forgetpass);
        tv_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView img_cancel = (ImageView)dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

    private void forgetpassApi() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        ForgetPasswordModel forgetPasswordModel= new ForgetPasswordModel();
        forgetPasswordModel.setRegEmail(forgetmail);

        ForgetPasswordConstant forgetPasswordConstant = new ForgetPasswordConstant();
        forgetPasswordConstant.setRealstate(forgetPasswordModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ForgetPasswordPojo> call = apiService.forgetpass(forgetPasswordConstant);
        try {
            call.enqueue(new Callback<ForgetPasswordPojo>() {
                @Override
                public void onResponse(Call<ForgetPasswordPojo> call, retrofit2.Response<ForgetPasswordPojo> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(LoginActivity.this, response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                        pDialog.dismiss();
                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<ForgetPasswordPojo> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(LoginActivity.this, "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(this, "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }


    }

    public static boolean isNetworkStatusAvialable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if (netInfos != null)
                if (netInfos.isConnected())
                    return true;
        }
        return false;
    }

}
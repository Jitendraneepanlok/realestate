package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.tutorial.realestate.Interface.ApiClient;
import com.tutorial.realestate.Interface.ApiInterface;
import com.tutorial.realestate.Model.RegistrationModel;
import com.tutorial.realestate.Pojo.RegistrationResponse;
import com.tutorial.realestate.R;

import java.util.Locale;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    private String selected_country_code;
    String DEFAULT_COUNTRY = Locale.getDefault().getCountry();
    CheckBox cb_terms;
    String url = "https://realestate.10to100.com/terms-conditions";
    private ProgressDialog pDialog;
    LinearLayout btn_register;
    EditText etfullname,etemail_id,etpassword,etphone;
    String FullName, password, Email, Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        etfullname = (EditText)findViewById(R.id.etfullname);
        etemail_id = (EditText)findViewById(R.id.etemail_id);
        etpassword = (EditText)findViewById(R.id.etpassword);
        etphone = (EditText)findViewById(R.id.etphone);

        btn_register = (LinearLayout)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalidation();
            }
        });

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        cb_terms = (CheckBox)findViewById(R.id.cb_terms);
        cb_terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              //  isCheckedValue = isChecked;
                if (isChecked) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else {

                }
            }
        });
    }

    private void checkvalidation() {
        etfullname = (EditText) findViewById(R.id.etfullname);
        etemail_id = (EditText) findViewById(R.id.etemail_id);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etphone = (EditText) findViewById(R.id.etphone);

         FullName = etfullname.getText().toString().trim();
         password = etpassword.getText().toString().trim();
         Email = etemail_id.getText().toString().trim();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
         Phone = etphone.getText().toString().trim();

        if (!FullName.equals("")){
            if (!Email.equals("")/*matches(emailpattern)*/){
                if (!password.equals("")){
                    if (!Phone.equals("")/*isValidPhone(Phone)*/){
                        signUpApi();
                    }else {
                        etphone.setError("Please Enter Mobile No.");
                    }
                }else {
                    etpassword.setError("Please Enter Password");
                }

            }else {
                etemail_id.setError("Please Enter Email-Id");
            }
        }else {
            etfullname.setError("Please Enter your full name");
        }
    }

    private boolean isValidPhone(String phone) {
        boolean check = false;
        if (!Pattern.matches("[0-10]+", phone)) {
            if (phone.length() < 10) {
                check = false;
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


    private void signUpApi() {
        pDialog = new ProgressDialog(RegisterActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        RegistrationModel registrationModel= new RegistrationModel();
        registrationModel.setFirstName(FullName);
        registrationModel.setContact(Phone);
        registrationModel.setEmail(Email);
        registrationModel.setPassword(password);


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<RegistrationResponse> call = apiService.postSignUp("application/json", registrationModel);
        try {
            call.enqueue(new Callback<RegistrationResponse>() {
                @Override
                public void onResponse(Call<RegistrationResponse> call, retrofit2.Response<RegistrationResponse> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        etfullname.setText("");
                        etemail_id.setText("");
                        etpassword.setText("");
                        etphone.setText("");

                        pDialog.dismiss();
                    } else {
                        Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(RegisterActivity.this, "" + t, Toast.LENGTH_SHORT).show();
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
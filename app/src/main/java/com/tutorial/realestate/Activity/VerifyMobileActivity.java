package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Model.MobileVerifyConstant;
import com.tutorial.realestate.Model.MobileVerifyModel;
import com.tutorial.realestate.Pojo.MobileVerifyContantPojo;
import com.tutorial.realestate.R;

import retrofit2.Call;
import retrofit2.Callback;

public class VerifyMobileActivity extends AppCompatActivity {

    String mobile_Number, mobile_otp, user_id,enter_Otp;
    AppCompatTextView tv_mobile;
    AppCompatEditText et_otp;
    AppCompatButton btn_verify_otp;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_mobile);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.title_bar_color));
        }
        Intent intent = getIntent();
        mobile_Number = intent.getStringExtra("MOBILE_NUMBER");
        mobile_otp = intent.getStringExtra("MOBILE_OTP");
        user_id = intent.getStringExtra("USER_ID");

        Log.e("Data",""+mobile_Number+","+mobile_otp+","+user_id);
        initView();

    }

    private void initView() {

        tv_mobile = (AppCompatTextView)findViewById(R.id.tv_mobile);
        tv_mobile.setText(mobile_Number);

        btn_verify_otp = (AppCompatButton)findViewById(R.id.btn_verify_otp);
        btn_verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckValidation();
            }
        });


    }

    private void CheckValidation() {
        et_otp = (AppCompatEditText)findViewById(R.id.et_otp);
         enter_Otp = et_otp.getText().toString().trim();

        if (!enter_Otp.equals("")){
            CallOtpVerifyApi();
        }else {
            Toast.makeText(this, "Please Enter Valid Otp", Toast.LENGTH_SHORT).show();
        }



    }

    private void CallOtpVerifyApi() {
        pDialog = new ProgressDialog(VerifyMobileActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        MobileVerifyModel mobileVerifyModel= new MobileVerifyModel();
        mobileVerifyModel.setContactNumber(mobile_Number);
        mobileVerifyModel.setMobileOtp(mobile_otp);
        mobileVerifyModel.setOtpVal(enter_Otp);
        mobileVerifyModel.setuID(user_id);


        MobileVerifyConstant mobileVerifyConstant = new MobileVerifyConstant();
        mobileVerifyConstant.setRealstate(mobileVerifyModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MobileVerifyContantPojo> call = apiService.postVerifyMobile(mobileVerifyConstant);
        try {
            call.enqueue(new Callback<MobileVerifyContantPojo>() {
                @Override
                public void onResponse(Call<MobileVerifyContantPojo> call, retrofit2.Response<MobileVerifyContantPojo> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<MobileVerifyContantPojo> call, Throwable t) {
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
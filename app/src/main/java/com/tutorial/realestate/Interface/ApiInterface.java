package com.tutorial.realestate.Interface;

import com.tutorial.realestate.Model.ChangePasswordModel;
import com.tutorial.realestate.Model.ForgetPasswordModel;
import com.tutorial.realestate.Model.LoginModel;
import com.tutorial.realestate.Model.RegistrationModel;
import com.tutorial.realestate.Pojo.ChangePassResponse;
import com.tutorial.realestate.Pojo.ForgetPasswordResponse;
import com.tutorial.realestate.Pojo.LoginResponseMsg;
import com.tutorial.realestate.Pojo.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("registration")
    Call<RegistrationResponse> postSignUp(@Header("Content-Type") String content_type, @Body RegistrationModel registrationModel);

    @POST("login")
    Call<LoginResponseMsg> postSignIn(@Header("Content-Type") String content_type, @Body LoginModel loginModel);

    @POST("Forgot_Password")
    Call<ForgetPasswordResponse> forgetpass(@Header("Content-Type") String content_type, @Body ForgetPasswordModel forgetPasswordModel);

    @POST("ChangePassword")
    Call<ChangePassResponse> postchangepass(@Header("Content-Type") String content_type, @Body ChangePasswordModel changePasswordModel);
}

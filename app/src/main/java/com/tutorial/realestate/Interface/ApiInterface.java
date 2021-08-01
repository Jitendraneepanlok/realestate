package com.tutorial.realestate.Interface;

import com.tutorial.realestate.Model.ChangePassConstant;
import com.tutorial.realestate.Model.ChangePasswordModel;
import com.tutorial.realestate.Model.FeaturePropertiesContsantModel;
import com.tutorial.realestate.Model.ForgetPasswordConstant;
import com.tutorial.realestate.Model.ForgetPasswordModel;
import com.tutorial.realestate.Model.LoginData;
import com.tutorial.realestate.Model.LoginModel;
import com.tutorial.realestate.Model.MobileVerifyConstant;
import com.tutorial.realestate.Model.RegistrationConsModel;
import com.tutorial.realestate.Model.RegistrationModel;
import com.tutorial.realestate.Model.UpdateProfileConstantModel;
import com.tutorial.realestate.Pojo.ChangePassContantPojo;
import com.tutorial.realestate.Pojo.ChangePassResponse;
import com.tutorial.realestate.Pojo.FeaturePropertiesContantPojo;
import com.tutorial.realestate.Pojo.ForgetPasswordPojo;
import com.tutorial.realestate.Pojo.ForgetPasswordResponse;
import com.tutorial.realestate.Pojo.LoginResponse;
import com.tutorial.realestate.Pojo.MobileVerifyContantPojo;
import com.tutorial.realestate.Pojo.RegistrationPojoConstant;
import com.tutorial.realestate.Pojo.RegistrationResponse;
import com.tutorial.realestate.Pojo.UpdateProfileContant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("Login")
    Call<LoginResponse> postSignIn(@Body LoginModel loginmodel);

    @POST("Registration")
    Call<RegistrationPojoConstant> postSignUp(@Body RegistrationConsModel registrationConsModel);

    @POST("ForgetPass")
    Call<ForgetPasswordPojo> forgetpass(@Body ForgetPasswordConstant forgetPasswordConstant);

    @POST("ChangePass")
    Call<ChangePassContantPojo> postchangepass(@Body ChangePassConstant changePassConstant);

    @POST("UpdateProfile")
    Call<UpdateProfileContant> postUpdateProfile(@Body UpdateProfileConstantModel updateProfileConstantModel);

    @POST("MobileVerify")
    Call<MobileVerifyContantPojo> postVerifyMobile(@Body MobileVerifyConstant mobileVerifyConstant);

    @POST("FeaturedProperties")
    Call<FeaturePropertiesContantPojo> getFeatureProperties(@Body FeaturePropertiesContsantModel featurePropertiesContsantModel);

}

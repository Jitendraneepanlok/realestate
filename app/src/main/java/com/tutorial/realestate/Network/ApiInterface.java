package com.tutorial.realestate.Network;

import com.tutorial.realestate.Model.ChangePassConstant;
import com.tutorial.realestate.Model.FeaturePropertiesContsantModel;
import com.tutorial.realestate.Model.ForgetPasswordConstant;
import com.tutorial.realestate.Model.LoginModel;
import com.tutorial.realestate.Model.LogoutContantModel;
import com.tutorial.realestate.Model.MobileVerifyConstant;
import com.tutorial.realestate.Model.RegistrationConsModel;
import com.tutorial.realestate.Model.TopPropertiesConstantModel;
import com.tutorial.realestate.Model.UpdateProfileConstantModel;
import com.tutorial.realestate.Pojo.ChangePassContantPojo;
import com.tutorial.realestate.Pojo.FeaturePropertiesContantPojo;
import com.tutorial.realestate.Pojo.ForgetPasswordPojo;
import com.tutorial.realestate.Pojo.LoginResponse;
import com.tutorial.realestate.Pojo.LogoutConstantPojo;
import com.tutorial.realestate.Pojo.MobileVerifyContantPojo;
import com.tutorial.realestate.Pojo.RegistrationPojoConstant;
import com.tutorial.realestate.Pojo.TopPropertiesConstantPojo;
import com.tutorial.realestate.Pojo.UpdateProfileContant;

import retrofit2.Call;
import retrofit2.http.Body;
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

    @POST("TopProperties")
    Call<TopPropertiesConstantPojo> getTopProperties(@Body TopPropertiesConstantModel topPropertiesConstantModel );

    @POST("Logout")
    Call<LogoutConstantPojo> postLogout(@Body LogoutContantModel logoutContantModel );

}

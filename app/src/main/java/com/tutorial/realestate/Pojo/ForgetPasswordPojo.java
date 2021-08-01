package com.tutorial.realestate.Pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgetPasswordPojo {

    @SerializedName("realstate")
    @Expose
    private ForgetPasswordResponse realstate;

    public ForgetPasswordResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(ForgetPasswordResponse realstate) {
        this.realstate = realstate;
    }

}

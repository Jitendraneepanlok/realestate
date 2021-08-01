package com.tutorial.realestate.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgetPasswordConstant {

    @SerializedName("realstate")
    @Expose
    private ForgetPasswordModel realstate;

    public ForgetPasswordModel getRealstate() {
        return realstate;
    }

    public void setRealstate(ForgetPasswordModel realstate) {
        this.realstate = realstate;
    }

}

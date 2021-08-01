package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileVerifyConstant {
    @SerializedName("realstate")
    @Expose
    private MobileVerifyModel realstate;

    public MobileVerifyModel getRealstate() {
        return realstate;
    }

    public void setRealstate(MobileVerifyModel realstate) {
        this.realstate = realstate;
    }

}

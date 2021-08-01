package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileVerifyContantPojo {
    @SerializedName("realstate")
    @Expose
    private MobileVerifyResponse realstate;

    public MobileVerifyResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(MobileVerifyResponse realstate) {
        this.realstate = realstate;
    }

}

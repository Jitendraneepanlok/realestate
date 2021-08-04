package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutConstantPojo {

    @SerializedName("realstate")
    @Expose
    private LogoutResponse realstate;

    public LogoutResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(LogoutResponse realstate) {
        this.realstate = realstate;
    }
}

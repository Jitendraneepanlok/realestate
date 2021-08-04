package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutContantModel {
    @SerializedName("realstate")
    @Expose
    private LogoutModel realstate;

    public LogoutModel getRealstate() {
        return realstate;
    }

    public void setRealstate(LogoutModel realstate) {
        this.realstate = realstate;
    }
}

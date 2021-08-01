package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("realstate")
    @Expose
    private LoginData realstate;

    public LoginData getRealstate() {
        return realstate;
    }

    public void setRealstate(LoginData realstate) {
        this.realstate = realstate;
    }
}

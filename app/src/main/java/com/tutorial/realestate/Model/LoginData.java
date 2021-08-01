package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("reg_email")
    @Expose
    private String regEmail;
    @SerializedName("reg_user_password")
    @Expose
    private String regUserPassword;

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getRegUserPassword() {
        return regUserPassword;
    }

    public void setRegUserPassword(String regUserPassword) {
        this.regUserPassword = regUserPassword;
    }

}

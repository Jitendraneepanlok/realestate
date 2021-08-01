package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangePasswordModel {

    @SerializedName("old_reg_user_password")
    @Expose
    private String oldRegUserPassword;
    @SerializedName("reg_user_password")
    @Expose
    private String regUserPassword;
    @SerializedName("uID")
    @Expose
    private String uID;

    public String getOldRegUserPassword() {
        return oldRegUserPassword;
    }

    public void setOldRegUserPassword(String oldRegUserPassword) {
        this.oldRegUserPassword = oldRegUserPassword;
    }

    public String getRegUserPassword() {
        return regUserPassword;
    }

    public void setRegUserPassword(String regUserPassword) {
        this.regUserPassword = regUserPassword;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}

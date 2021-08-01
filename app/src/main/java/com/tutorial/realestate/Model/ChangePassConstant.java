package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangePassConstant {

    @SerializedName("realstate")
    @Expose
    private ChangePasswordModel realstate;

    public ChangePasswordModel getRealstate() {
        return realstate;
    }

    public void setRealstate(ChangePasswordModel realstate) {
        this.realstate = realstate;
    }
}

package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationConsModel {

    @SerializedName("realstate")
    @Expose
    private RegistrationModel realstate;

    public RegistrationModel getRealstate() {
        return realstate;
    }

    public void setRealstate(RegistrationModel realstate) {
        this.realstate = realstate;
    }
}


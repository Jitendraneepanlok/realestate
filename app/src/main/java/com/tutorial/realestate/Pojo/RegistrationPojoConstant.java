package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationPojoConstant {
    @SerializedName("realstate")
    @Expose
    private RegistrationResponse realstate;

    public RegistrationResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(RegistrationResponse realstate) {
        this.realstate = realstate;
    }
}

package com.tutorial.realestate.Pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("realstate")
    @Expose
    private Realstate realstate;

    public Realstate getRealstate() {
        return realstate;
    }

    public void setRealstate(Realstate realstate) {
        this.realstate = realstate;
    }
}

package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfileConstantModel {
    @SerializedName("realstate")
    @Expose
    private UpdateProfileModel realstate;

    public UpdateProfileModel getRealstate() {
        return realstate;
    }

    public void setRealstate(UpdateProfileModel realstate) {
        this.realstate = realstate;
    }

}

package com.tutorial.realestate.Pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfileContant {
    @SerializedName("realstate")
    @Expose
    private UpdateProfileResponse realstate;

    public UpdateProfileResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(UpdateProfileResponse realstate) {
        this.realstate = realstate;
    }

}

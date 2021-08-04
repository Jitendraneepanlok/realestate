package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopPropertiesConstantModel {

    @SerializedName("realstate")
    @Expose
    private TopPropertiesModel realstate;

    public TopPropertiesModel getRealstate() {
        return realstate;
    }

    public void setRealstate(TopPropertiesModel realstate) {
        this.realstate = realstate;
    }
}

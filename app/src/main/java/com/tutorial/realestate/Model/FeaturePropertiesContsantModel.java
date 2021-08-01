package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturePropertiesContsantModel {
    @SerializedName("realstate")
    @Expose
    private FeaturePropertiesModel realstate;

    public FeaturePropertiesModel getRealstate() {
        return realstate;
    }

    public void setRealstate(FeaturePropertiesModel realstate) {
        this.realstate = realstate;
    }
}

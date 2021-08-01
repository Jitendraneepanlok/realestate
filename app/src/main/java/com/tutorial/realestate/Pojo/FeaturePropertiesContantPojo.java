package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturePropertiesContantPojo {

    @SerializedName("realstate")
    @Expose
    private FeaturedPropertyResponse realstate;

    public FeaturedPropertyResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(FeaturedPropertyResponse realstate) {
        this.realstate = realstate;
    }
}

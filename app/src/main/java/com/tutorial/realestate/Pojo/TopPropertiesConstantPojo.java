package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopPropertiesConstantPojo {
    @SerializedName("realstate")
    @Expose
    private TopPropertiesResponse realstate;

    public TopPropertiesResponse getRealstate() {
        return realstate;
    }

    public void setRealstate(TopPropertiesResponse realstate) {
        this.realstate = realstate;
    }
}

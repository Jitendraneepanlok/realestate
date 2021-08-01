package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeaturedPropertyResponse {
    @SerializedName("resMessage")
    @Expose
    private String resMessage;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("FeaturedProperties")
    @Expose
    private List<FeaturedPropertyPojo> featuredProperties = null;

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<FeaturedPropertyPojo> getFeaturedProperties() {
        return featuredProperties;
    }

    public void setFeaturedProperties(List<FeaturedPropertyPojo> featuredProperties) {
        this.featuredProperties = featuredProperties;
    }
}

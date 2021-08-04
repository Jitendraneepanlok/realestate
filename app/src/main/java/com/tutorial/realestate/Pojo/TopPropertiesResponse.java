package com.tutorial.realestate.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopPropertiesResponse {
    @SerializedName("resMessage")
    @Expose
    private String resMessage;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("TopProperties")
    @Expose
    private List<TopProperty> topProperties = null;

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

    public List<TopProperty> getTopProperties() {
        return topProperties;
    }

    public void setTopProperties(List<TopProperty> topProperties) {
        this.topProperties = topProperties;
    }

}

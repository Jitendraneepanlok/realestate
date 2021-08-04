package com.tutorial.realestate.Pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    @SerializedName("resMessage")
    @Expose
    private String resMessage;
    @SerializedName("response")
    @Expose
    private String response;

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
}

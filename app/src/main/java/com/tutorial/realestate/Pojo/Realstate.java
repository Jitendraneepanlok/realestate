package com.tutorial.realestate.Pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Realstate {
    @SerializedName("resMessage")
    @Expose
    private String resMessage;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

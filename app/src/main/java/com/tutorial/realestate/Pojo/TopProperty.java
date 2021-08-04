package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopProperty {
    @SerializedName("txtImage")
    @Expose
    private String txtImage;
    @SerializedName("txtCityName")
    @Expose
    private String txtCityName;
    @SerializedName("txtbuilder_name")
    @Expose
    private String txtbuilderName;
    @SerializedName("txtproperty_title")
    @Expose
    private String txtpropertyTitle;
    @SerializedName("txtLocalityName")
    @Expose
    private String txtLocalityName;
    @SerializedName("txtsublocality")
    @Expose
    private String txtsublocality;
    @SerializedName("txtStateName")
    @Expose
    private String txtStateName;
    @SerializedName("txtBHK")
    @Expose
    private String txtBHK;
    @SerializedName("txtArea")
    @Expose
    private String txtArea;
    @SerializedName("txtPrice")
    @Expose
    private String txtPrice;
    @SerializedName("txtProjectStatus")
    @Expose
    private String txtProjectStatus;
    @SerializedName("txtIsVerified")
    @Expose
    private String txtIsVerified;
    @SerializedName("txtPricefrom")
    @Expose
    private String txtPricefrom;

    public String getTxtImage() {
        return txtImage;
    }

    public void setTxtImage(String txtImage) {
        this.txtImage = txtImage;
    }

    public String getTxtCityName() {
        return txtCityName;
    }

    public void setTxtCityName(String txtCityName) {
        this.txtCityName = txtCityName;
    }

    public String getTxtbuilderName() {
        return txtbuilderName;
    }

    public void setTxtbuilderName(String txtbuilderName) {
        this.txtbuilderName = txtbuilderName;
    }

    public String getTxtpropertyTitle() {
        return txtpropertyTitle;
    }

    public void setTxtpropertyTitle(String txtpropertyTitle) {
        this.txtpropertyTitle = txtpropertyTitle;
    }

    public String getTxtLocalityName() {
        return txtLocalityName;
    }

    public void setTxtLocalityName(String txtLocalityName) {
        this.txtLocalityName = txtLocalityName;
    }

    public String getTxtsublocality() {
        return txtsublocality;
    }

    public void setTxtsublocality(String txtsublocality) {
        this.txtsublocality = txtsublocality;
    }

    public String getTxtStateName() {
        return txtStateName;
    }

    public void setTxtStateName(String txtStateName) {
        this.txtStateName = txtStateName;
    }

    public String getTxtBHK() {
        return txtBHK;
    }

    public void setTxtBHK(String txtBHK) {
        this.txtBHK = txtBHK;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
    }

    public String getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(String txtPrice) {
        this.txtPrice = txtPrice;
    }

    public String getTxtProjectStatus() {
        return txtProjectStatus;
    }

    public void setTxtProjectStatus(String txtProjectStatus) {
        this.txtProjectStatus = txtProjectStatus;
    }

    public String getTxtIsVerified() {
        return txtIsVerified;
    }

    public void setTxtIsVerified(String txtIsVerified) {
        this.txtIsVerified = txtIsVerified;
    }

    public String getTxtPricefrom() {
        return txtPricefrom;
    }

    public void setTxtPricefrom(String txtPricefrom) {
        this.txtPricefrom = txtPricefrom;
    }

}

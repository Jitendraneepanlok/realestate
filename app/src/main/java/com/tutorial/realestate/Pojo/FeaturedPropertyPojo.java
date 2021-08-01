package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedPropertyPojo {
    @SerializedName("txtImage")
    @Expose
    private String txtImage;
    @SerializedName("txtlistedby")
    @Expose
    private String txtlistedby;
    @SerializedName("txtuseras")
    @Expose
    private String txtuseras;
    @SerializedName("txtproperty_title")
    @Expose
    private String txtpropertyTitle;
    @SerializedName("txtLandmark")
    @Expose
    private String txtLandmark;
    @SerializedName("txtLocalityName")
    @Expose
    private String txtLocalityName;
    @SerializedName("txtCityName")
    @Expose
    private String txtCityName;
    @SerializedName("txtStateName")
    @Expose
    private String txtStateName;
    @SerializedName("txtPropertySubtypeName")
    @Expose
    private String txtPropertySubtypeName;
    @SerializedName("txtArea")
    @Expose
    private String txtArea;
    @SerializedName("txtBedrooms")
    @Expose
    private Integer txtBedrooms;
    @SerializedName("txtAvailability")
    @Expose
    private Integer txtAvailability;
    @SerializedName("txtLengthOfPlot")
    @Expose
    private Integer txtLengthOfPlot;
    @SerializedName("txtBreadthOfPlot")
    @Expose
    private Integer txtBreadthOfPlot;
    @SerializedName("txtIsVerified")
    @Expose
    private String txtIsVerified;
    @SerializedName("txtrentExpectedPrice")
    @Expose
    private Integer txtrentExpectedPrice;
    @SerializedName("txtsaleExpectedPrice")
    @Expose
    private String txtsaleExpectedPrice;

    public String getTxtImage() {
        return txtImage;
    }

    public void setTxtImage(String txtImage) {
        this.txtImage = txtImage;
    }

    public String getTxtlistedby() {
        return txtlistedby;
    }

    public void setTxtlistedby(String txtlistedby) {
        this.txtlistedby = txtlistedby;
    }

    public String getTxtuseras() {
        return txtuseras;
    }

    public void setTxtuseras(String txtuseras) {
        this.txtuseras = txtuseras;
    }

    public String getTxtpropertyTitle() {
        return txtpropertyTitle;
    }

    public void setTxtpropertyTitle(String txtpropertyTitle) {
        this.txtpropertyTitle = txtpropertyTitle;
    }

    public String getTxtLandmark() {
        return txtLandmark;
    }

    public void setTxtLandmark(String txtLandmark) {
        this.txtLandmark = txtLandmark;
    }

    public String getTxtLocalityName() {
        return txtLocalityName;
    }

    public void setTxtLocalityName(String txtLocalityName) {
        this.txtLocalityName = txtLocalityName;
    }

    public String getTxtCityName() {
        return txtCityName;
    }

    public void setTxtCityName(String txtCityName) {
        this.txtCityName = txtCityName;
    }

    public String getTxtStateName() {
        return txtStateName;
    }

    public void setTxtStateName(String txtStateName) {
        this.txtStateName = txtStateName;
    }

    public String getTxtPropertySubtypeName() {
        return txtPropertySubtypeName;
    }

    public void setTxtPropertySubtypeName(String txtPropertySubtypeName) {
        this.txtPropertySubtypeName = txtPropertySubtypeName;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
    }

    public Integer getTxtBedrooms() {
        return txtBedrooms;
    }

    public void setTxtBedrooms(Integer txtBedrooms) {
        this.txtBedrooms = txtBedrooms;
    }

    public Integer getTxtAvailability() {
        return txtAvailability;
    }

    public void setTxtAvailability(Integer txtAvailability) {
        this.txtAvailability = txtAvailability;
    }

    public Integer getTxtLengthOfPlot() {
        return txtLengthOfPlot;
    }

    public void setTxtLengthOfPlot(Integer txtLengthOfPlot) {
        this.txtLengthOfPlot = txtLengthOfPlot;
    }

    public Integer getTxtBreadthOfPlot() {
        return txtBreadthOfPlot;
    }

    public void setTxtBreadthOfPlot(Integer txtBreadthOfPlot) {
        this.txtBreadthOfPlot = txtBreadthOfPlot;
    }

    public String getTxtIsVerified() {
        return txtIsVerified;
    }

    public void setTxtIsVerified(String txtIsVerified) {
        this.txtIsVerified = txtIsVerified;
    }

    public Integer getTxtrentExpectedPrice() {
        return txtrentExpectedPrice;
    }

    public void setTxtrentExpectedPrice(Integer txtrentExpectedPrice) {
        this.txtrentExpectedPrice = txtrentExpectedPrice;
    }

    public String getTxtsaleExpectedPrice() {
        return txtsaleExpectedPrice;
    }

    public void setTxtsaleExpectedPrice(String txtsaleExpectedPrice) {
        this.txtsaleExpectedPrice = txtsaleExpectedPrice;
    }
}

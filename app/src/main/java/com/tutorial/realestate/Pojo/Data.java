package com.tutorial.realestate.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("UserAs")
    @Expose
    private String userAs;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("MobileVerified")
    @Expose
    private String mobileVerified;
    @SerializedName("EmailVerified")
    @Expose
    private String emailVerified;
    @SerializedName("ProfilePhoto")
    @Expose
    private String profilePhoto;
    @SerializedName("AvailableCredit")
    @Expose
    private String availableCredit;
    @SerializedName("ContactNumber")
    @Expose
    private String contactNumber;
    @SerializedName("jwt_tocken")
    @Expose
    private String jwtTocken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAs() {
        return userAs;
    }

    public void setUserAs(String userAs) {
        this.userAs = userAs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(String mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(String availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getJwtTocken() {
        return jwtTocken;
    }

    public void setJwtTocken(String jwtTocken) {
        this.jwtTocken = jwtTocken;
    }

}
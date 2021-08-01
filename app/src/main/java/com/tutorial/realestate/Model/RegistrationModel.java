package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationModel {

    @SerializedName("reg_user_name")
    @Expose
    private String regUserName;
    @SerializedName("reg_email")
    @Expose
    private String regEmail;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("reg_user_password")
    @Expose
    private String regUserPassword;
    @SerializedName("user_type")
    @Expose
    private String userType;

    public String getRegUserName() {
        return regUserName;
    }

    public void setRegUserName(String regUserName) {
        this.regUserName = regUserName;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRegUserPassword() {
        return regUserPassword;
    }

    public void setRegUserPassword(String regUserPassword) {
        this.regUserPassword = regUserPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

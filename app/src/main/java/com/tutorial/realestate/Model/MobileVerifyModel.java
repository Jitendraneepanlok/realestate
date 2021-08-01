package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileVerifyModel {
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("otp_val")
    @Expose
    private String otpVal;
    @SerializedName("mobile_otp")
    @Expose
    private String mobileOtp;
    @SerializedName("uID")
    @Expose
    private String uID;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOtpVal() {
        return otpVal;
    }

    public void setOtpVal(String otpVal) {
        this.otpVal = otpVal;
    }

    public String getMobileOtp() {
        return mobileOtp;
    }

    public void setMobileOtp(String mobileOtp) {
        this.mobileOtp = mobileOtp;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}

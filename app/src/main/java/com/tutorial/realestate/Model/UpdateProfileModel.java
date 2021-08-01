package com.tutorial.realestate.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfileModel {
    @SerializedName("profile_name")
    @Expose
    private String profileName;
    @SerializedName("profile_useras")
    @Expose
    private String profileUseras;
    @SerializedName("contact_country_code")
    @Expose
    private String contactCountryCode;
    @SerializedName("profile_contact")
    @Expose
    private String profileContact;
    @SerializedName("profile_business_title")
    @Expose
    private String profileBusinessTitle;
    @SerializedName("profile_business_address")
    @Expose
    private String profileBusinessAddress;
    @SerializedName("uID")
    @Expose
    private String uID;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("city_id")
    @Expose
    private String cityId;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileUseras() {
        return profileUseras;
    }

    public void setProfileUseras(String profileUseras) {
        this.profileUseras = profileUseras;
    }

    public String getContactCountryCode() {
        return contactCountryCode;
    }

    public void setContactCountryCode(String contactCountryCode) {
        this.contactCountryCode = contactCountryCode;
    }

    public String getProfileContact() {
        return profileContact;
    }

    public void setProfileContact(String profileContact) {
        this.profileContact = profileContact;
    }

    public String getProfileBusinessTitle() {
        return profileBusinessTitle;
    }

    public void setProfileBusinessTitle(String profileBusinessTitle) {
        this.profileBusinessTitle = profileBusinessTitle;
    }

    public String getProfileBusinessAddress() {
        return profileBusinessAddress;
    }

    public void setProfileBusinessAddress(String profileBusinessAddress) {
        this.profileBusinessAddress = profileBusinessAddress;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}

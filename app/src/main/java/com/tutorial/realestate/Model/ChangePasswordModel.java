package com.tutorial.realestate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ChangePasswordModel {

        @SerializedName("c_password")
        @Expose
        private String cPassword;
        @SerializedName("new_password")
        @Expose
        private String newPassword;
        @SerializedName("confirm_password")
        @Expose
        private String confirmPassword;

        public String getCPassword() {
            return cPassword;
        }

        public void setCPassword(String cPassword) {
            this.cPassword = cPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
}

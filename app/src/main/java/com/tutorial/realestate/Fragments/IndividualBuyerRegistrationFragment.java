package com.tutorial.realestate.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.hbb20.CountryCodePicker;
import com.tutorial.realestate.Activity.VerifyMobileActivity;
import com.tutorial.realestate.Model.RegistrationConsModel;
import com.tutorial.realestate.Model.RegistrationModel;
import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Pojo.RegistrationPojoConstant;
import com.tutorial.realestate.R;

import java.util.Locale;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class IndividualBuyerRegistrationFragment extends Fragment {
    View view;
    CountryCodePicker ccp;
    private String selected_country_code;
    String DEFAULT_COUNTRY = Locale.getDefault().getCountry();
    private ProgressDialog pDialog;
    AppCompatButton btn_continue;
    EditText etfullname, etemail_id, etpassword, etphone;
    String FullName, password, Email, Phone, SelectedValue;
    RadioGroup radio_group;
    RadioButton radio_buyer, radio_tenant;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buyer_registarion, container, false);
        initView();
        return view;
    }

    private void initView() {

        etfullname = (EditText) view.findViewById(R.id.etfullname);
        etemail_id = (EditText) view.findViewById(R.id.etemail_id);
        etpassword = (EditText) view.findViewById(R.id.etpassword);
        etphone = (EditText) view.findViewById(R.id.etphone);

        btn_continue = (AppCompatButton) view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalidation();
            }
        });
        ccp = (CountryCodePicker) view.findViewById(R.id.ccp);
        radio_tenant = (RadioButton) view.findViewById(R.id.radio_tenant);
        radio_buyer = (RadioButton) view.findViewById(R.id.radio_buyer);

        radio_group = (RadioGroup) view.findViewById(R.id.radio_group);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_buyer.isChecked()) {
                    SelectedValue = radio_buyer.getText().toString();
                } else if (radio_tenant.isChecked()) {
                    SelectedValue = radio_buyer.getText().toString();
                }
            }
        });
    }

    private void checkvalidation() {

        FullName = etfullname.getText().toString().trim();
        password = etpassword.getText().toString().trim();
        Email = etemail_id.getText().toString().trim();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Phone = etphone.getText().toString().trim();

        if (!FullName.equals("")) {
            if (!Email.equals("")/*matches(emailpattern)*/) {
                if (!password.equals("")) {
                    if (!Phone.equals("")/*isValidPhone(Phone)*/) {
                        if (radio_buyer.isChecked()  || radio_tenant.isChecked()) {
                            signUpApi();
                        } else {
                            Toast.makeText(getActivity(), "Please Select who are you", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        etphone.setError("Please Enter Mobile No.");
                    }
                } else {
                    etpassword.setError("Please Enter Password");
                }

            } else {
                etemail_id.setError("Please Enter Email-Id");
            }
        } else {
            etfullname.setError("Please Enter your full name");
        }
    }

    private boolean isValidPhone(String phone) {
        boolean check = false;
        if (!Pattern.matches("[0-10]+", phone)) {
            if (phone.length() < 10) {
                check = false;
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


    private void signUpApi() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setRegUserName(FullName);
        registrationModel.setContactNumber(Phone);
        registrationModel.setRegEmail(Email);
        registrationModel.setRegUserPassword(password);
        registrationModel.setCountryCode("+91");
        registrationModel.setUserType(SelectedValue);

        RegistrationConsModel registrationConsModel = new RegistrationConsModel();
        registrationConsModel.setRealstate(registrationModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<RegistrationPojoConstant> call = apiService.postSignUp(registrationConsModel);
        try {
            call.enqueue(new Callback<RegistrationPojoConstant>() {
                @Override
                public void onResponse(Call<RegistrationPojoConstant> call, retrofit2.Response<RegistrationPojoConstant> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                        String Mobile = response.body().getRealstate().getMobile();
                        String Mobile_Otp = response.body().getRealstate().getMobileOtp();
                        String UID = response.body().getRealstate().getUserId();

                        Intent intent = new Intent(getActivity(), VerifyMobileActivity.class);
                        intent.putExtra("MOBILE_NUMBER", Mobile);
                        intent.putExtra("MOBILE_OTP", Mobile_Otp);
                        intent.putExtra("USER_ID", UID);
                        startActivity(intent);


                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<RegistrationPojoConstant> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(getActivity(), "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(getActivity(), "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }
    }
}


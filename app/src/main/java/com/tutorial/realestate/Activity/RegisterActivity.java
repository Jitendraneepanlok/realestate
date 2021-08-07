package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.tutorial.realestate.Fragments.IndividualBuyerRegistrationFragment;
import com.tutorial.realestate.Fragments.IndividualRegistrationFragment;
import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Model.RegistrationConsModel;
import com.tutorial.realestate.Model.RegistrationModel;
import com.tutorial.realestate.Pojo.RegistrationPojoConstant;
import com.tutorial.realestate.R;

import java.util.Locale;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity {

    RadioGroup rg_register;
    RadioButton rb_individual, rb_buyer;
    String Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.title_bar_color));
        }
        callIndividualFragment();
        rb_individual = (RadioButton) findViewById(R.id.rb_individual);
        rb_buyer = (RadioButton) findViewById(R.id.rb_buyer);

        rg_register = (RadioGroup) findViewById(R.id.rg_register);
        rg_register.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_individual.isChecked()) {
                    Value = rb_individual.getText().toString();
                    callIndividualFragment();
                } else if (rb_buyer.isChecked()) {
                    Value = rb_buyer.getText().toString();
                    callBuyerFragment();
                }
            }
        });

    }

    private void callBuyerFragment() {
        IndividualBuyerRegistrationFragment individualBuyerRegistrationFragment = new IndividualBuyerRegistrationFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fram_register, individualBuyerRegistrationFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }

    private void callIndividualFragment() {

        IndividualRegistrationFragment individualRegistrationFragment = new IndividualRegistrationFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fram_register, individualRegistrationFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }
}




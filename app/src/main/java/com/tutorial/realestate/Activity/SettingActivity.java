package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.NavigationActivity.ui.home.NotificationSettingFragment;
import com.tutorial.realestate.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatImageView img_back;
    AppCompatTextView txt_manage_notification, txt_clear_history, txt_clear_favrote, txt_term_condition, txt_privacy_policy, txt_about_us, txt_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        initView();
    }

    private void initView() {
        txt_contact = (AppCompatTextView) findViewById(R.id.txt_contact);
        txt_about_us = (AppCompatTextView) findViewById(R.id.txt_about_us);
        txt_privacy_policy = (AppCompatTextView) findViewById(R.id.txt_privacy_policy);
        txt_term_condition = (AppCompatTextView) findViewById(R.id.txt_term_condition);
        txt_clear_history = (AppCompatTextView) findViewById(R.id.txt_clear_history);
        txt_clear_favrote = (AppCompatTextView) findViewById(R.id.txt_clear_favrote);
        txt_manage_notification = (AppCompatTextView) findViewById(R.id.txt_manage_notification);
        img_back = (AppCompatImageView) findViewById(R.id.img_back);

        txt_term_condition.setOnClickListener(this);
        txt_clear_favrote.setOnClickListener(this);
        img_back.setOnClickListener(this);
        txt_manage_notification.setOnClickListener(this);
        txt_clear_history.setOnClickListener(this);
        txt_privacy_policy.setOnClickListener(this);
        txt_about_us.setOnClickListener(this);
        txt_contact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_contact:
                Uri contact = Uri.parse("https://realestate.10to100.com/contact");
                Intent int_contact = new Intent(Intent.ACTION_VIEW, contact);
                startActivity(int_contact);
                break;
            case R.id.txt_about_us:
                Uri urI = Uri.parse("https://realestate.10to100.com/about-us");
                Intent inte = new Intent(Intent.ACTION_VIEW, urI);
                startActivity(inte);
                break;

            case R.id.txt_privacy_policy:
                Uri ur = Uri.parse("https://realestate.10to100.com/privacy-policy");
                Intent in = new Intent(Intent.ACTION_VIEW, ur);
                startActivity(in);
                break;

            case R.id.txt_term_condition:
                Uri uri = Uri.parse("https://realestate.10to100.com/terms-conditions");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.txt_clear_favrote:
                OpenClearFavroteDialog();

                break;
            case R.id.txt_clear_history:
                OpenClearHistoryDialog();
                break;
            case R.id.txt_manage_notification:
                startActivity(new Intent(getApplicationContext(), NotificaionSettingActivity.class));
                break;
            case R.id.img_back:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;
        }
    }

    private void OpenClearFavroteDialog() {
        Dialog dialog = new Dialog(SettingActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.clear_favrote_dialog);
        dialog.setCancelable(false);

        AppCompatButton btn_clear = (AppCompatButton) dialog.findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    private void OpenClearHistoryDialog() {
        Dialog dialog = new Dialog(SettingActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.clear_history_dialog);
        dialog.setCancelable(false);

        AppCompatButton btn_clear = (AppCompatButton) dialog.findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}
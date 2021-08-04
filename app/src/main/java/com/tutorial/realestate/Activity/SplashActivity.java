package com.tutorial.realestate.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.Prefrences.SessionManager;
import com.tutorial.realestate.R;

public class SplashActivity extends AppCompatActivity {
    SessionManager sessionManager;
    static String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        OpenewPage();
    }
    private void OpenewPage() {
        sessionManager = new SessionManager(SplashActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                if (sessionManager.getValueBoolean(SessionManager.VALUE)) {
                    // call home activity ,
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 3000);
    }
}
package com.example.manar.twitterclientchallenge.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.util.Constants;
import com.example.manar.twitterclientchallenge.view.HomeActivity;
import com.example.manar.twitterclientchallenge.view.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int secondsDelayed = 1;
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.LOGIN, MODE_PRIVATE);
        final String username = sharedPreferences.getString(Constants.USERNAME, "");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (username.equals("")) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
package com.example.manar.twitterclientchallenge.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.util.Constants;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "TwitterLogin";
    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                Log.v(TAG, result.toString());
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                login(session);
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.v(TAG, exception.toString());
                Snackbar.make(findViewById(R.id.login), R.string.authentication_failed, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void login(TwitterSession session) {
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;
        SharedPreferences.Editor editor = getSharedPreferences(Constants.LOGIN, MODE_PRIVATE).edit();
        editor.putString(Constants.USERNAME, session.getUserName());
        editor.putLong("userId", session.getUserId());
        editor.putString("token", token);
        editor.putString("secret", secret);
        editor.apply();
        String username = session.getUserName();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
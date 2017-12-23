package com.example.manar.twitterclientchallenge.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.manar.twitterclientchallenge.model.User;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by manar on 23/12/17.
 */

public class UserHelper {

    private static final String LOGIN = "Login";
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String TOKEN = "token";
    private static final String SECRET = "secret";

    public static void saveUser(Context context , User user){
        SharedPreferences.Editor editor = context.getSharedPreferences(LOGIN, MODE_PRIVATE).edit();
        editor.putString(USERNAME, user.getUsername());
        editor.putLong(USER_ID, user.getUserId());
        editor.putString(TOKEN, user.getToken());
        editor.putString(SECRET, user.getSecret());
        editor.apply();
    }

    public static User getUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOGIN, MODE_PRIVATE);
        String username = sharedPreferences.getString(USERNAME, "");
        long userId = sharedPreferences.getLong(USER_ID, 0);
        String token = sharedPreferences.getString(TOKEN, "");
        String secret = sharedPreferences.getString(SECRET, "");
        return new User(username, secret, token, userId);
    }
}
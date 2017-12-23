package com.example.manar.twitterclientchallenge.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.manar.twitterclientchallenge.model.User;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by manar on 23/12/17.
 */

public class UserHelper {

    public static void saveUser(Context context , User user){
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.LOGIN, MODE_PRIVATE).edit();
        editor.putString(Constants.USERNAME, user.getUsername());
        editor.putLong(Constants.USER_ID, user.getUserId());
        editor.putString(Constants.TOKEN, user.getToken());
        editor.putString(Constants.SECRET, user.getSecret());
        editor.apply();
    }

    public static User getUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.LOGIN, MODE_PRIVATE);
        String username = sharedPreferences.getString(Constants.USERNAME , "");
        long userId = sharedPreferences.getLong(Constants.USER_ID ,0);
        String token = sharedPreferences.getString(Constants.TOKEN , "");
        String secret = sharedPreferences.getString(Constants.SECRET , "");
        return new User(username,secret , token , userId);
    }
}
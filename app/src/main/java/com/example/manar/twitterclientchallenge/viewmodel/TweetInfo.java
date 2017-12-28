package com.example.manar.twitterclientchallenge.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

/**
 * Created by manar on 26/12/17.
 */

public class TweetInfo extends BaseObservable {

    public ObservableField<String> profilePicture = new ObservableField<>("");
    public ObservableField<String> cover = new ObservableField<>("");

    public TweetInfo(UserLookUp userLookUp) {
        profilePicture.set(userLookUp.getProfileImageUrl());
        if (userLookUp.getProfileBannerUrl() == null)
            cover.set("http://www.iowgeekblog.co.uk/wp-content/uploads/twitter-500x218.jpg");
        else
            cover.set(userLookUp.getProfileBannerUrl());
    }
}
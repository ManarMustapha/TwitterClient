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

    public ObservableArrayList<Tweet> tweetObservableArrayList = new ObservableArrayList<>();
    public ObservableField<String> profilePicture = new ObservableField<>("");
    public ObservableField<String> cover = new ObservableField<>("");
    private UserLookUp userLookUp;

    public TweetInfo(UserLookUp userLookUp){
        this.userLookUp = userLookUp;
        profilePicture.set(userLookUp.getProfileImageUrl());
        cover.set(userLookUp.getProfileBannerUrl());
    }
}
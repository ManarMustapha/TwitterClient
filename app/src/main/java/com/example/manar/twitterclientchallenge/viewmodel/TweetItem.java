package com.example.manar.twitterclientchallenge.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

/**
 * Created by manar on 26/12/17.
 */

public class TweetItem extends BaseObservable{

    public ObservableField<String> followerImage = new ObservableField<>("");
    public ObservableField<String> followerName = new ObservableField<>("");
    public ObservableField<String> followerTweet = new ObservableField<>("");

    public TweetItem(Tweet tweet , UserLookUp followers){
        followerName.set(followers.getName());
        followerImage.set(followers.getProfileImageUrl());
        followerTweet.set(tweet.getText());
    }
}
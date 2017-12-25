package com.example.manar.twitterclientchallenge.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.manar.twitterclientchallenge.model.Followers;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersInfo extends BaseObservable {

    public ObservableField<String> followerImage = new ObservableField<>("");
    public ObservableField<String> followerName = new ObservableField<>("");
    public ObservableField<String> followerBio = new ObservableField<>("");

    public FollowersInfo(UserLookUp followersResponse){
        followerImage.set(followersResponse.getProfileImageUrl());
        followerName.set(followersResponse.getName());
        followerBio.set(followersResponse.getDescription());
    }
}

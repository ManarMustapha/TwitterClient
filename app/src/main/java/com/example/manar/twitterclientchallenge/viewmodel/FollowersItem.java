package com.example.manar.twitterclientchallenge.viewmodel;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.example.manar.twitterclientchallenge.view.TweetsActivity;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersItem extends BaseObservable {

    public ObservableField<String> followerImage = new ObservableField<>("");
    public ObservableField<String> followerName = new ObservableField<>("");
    public ObservableField<String> followerBio = new ObservableField<>("");
    public ObservableBoolean description = new ObservableBoolean(true);
    private UserLookUp followersResponse;

    public FollowersItem(UserLookUp followersResponse) {
        this.followersResponse = followersResponse;
        followerImage.set(followersResponse.getProfileImageUrl());
        followerName.set(followersResponse.getName());
        if (!followersResponse.getDescription().equals("")) {
            followerBio.set(followersResponse.getDescription());
            description.set(false);
        }
    }

    public void onFollowerClicked(View view){
        Intent intent = new Intent(view.getContext() , TweetsActivity.class);
        intent.putExtra("followerResponse",followersResponse);
        view.getContext().startActivity(intent);
    }

}
package com.example.manar.twitterclientchallenge.repositry;

import com.example.manar.twitterclientchallenge.model.UserLookUp;

import java.util.List;

/**
 * Created by manar on 28/12/17.
 */

public interface LoadFollowersCallback {
    interface onFollowersLoaded{
        void onLoaded(List<UserLookUp> followers);
        void onNoData();
    }

    interface onIdsLoaded{
        void onFollowersIdsLoaded(List<String> ids);
        void onNoData();
    }
}

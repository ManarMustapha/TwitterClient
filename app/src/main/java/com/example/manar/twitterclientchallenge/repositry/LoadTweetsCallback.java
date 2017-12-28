package com.example.manar.twitterclientchallenge.repositry;

import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

import java.util.List;

/**
 * Created by manar on 28/12/17.
 */

public interface LoadTweetsCallback {
    interface onTweetsLoaded {
        void onLoaded(List<Tweet> tweets);
        void onNoData();
    }
}
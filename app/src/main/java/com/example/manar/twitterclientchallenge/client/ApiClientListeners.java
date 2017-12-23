package com.example.manar.twitterclientchallenge.client;

import com.example.manar.twitterclientchallenge.model.Followers;
import com.example.manar.twitterclientchallenge.model.FollowersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by manar on 23/12/17.
 */

public interface ApiClientListeners {

    //For getting friends :  @GET("1.1/friends/list.json")
    @GET("1.1/followers/list.json")
    Call<FollowersResponse> getFollowers (@Query("user_id") long id);

}
package com.example.manar.twitterclientchallenge.client;

import com.example.manar.twitterclientchallenge.model.FollowersIds;
import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by manar on 23/12/17.
 */

public interface ApiClientListeners {

    //For getting friends :  @GET("1.1/friends/list.json")
    @GET("1.1/followers/ids.json")
    Call<FollowersIds> getFollowersIds(@Query("user_id") long id);

    @GET("1.1/users/lookup.json")
    Call<List<UserLookUp>> getFollowers(@Query("user_id") String id);

    @GET("1.1/statuses/user_timeline.json")
    Call<List<Tweet>> getTweets(@Query("user_id") String user_id,
                                @Query("count") String count);

}
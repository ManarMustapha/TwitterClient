package com.example.manar.twitterclientchallenge.repositry;

import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manar on 28/12/17.
 */

public class TweetsDataSource {

    private static TweetsDataSource INSTANCE;
    private ApiClient myTwitterApiClient;


    public static TweetsDataSource getInstance(ApiClient myTwitterApiClient) {
        if (INSTANCE == null) {
            INSTANCE = new TweetsDataSource(myTwitterApiClient);
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private TweetsDataSource(ApiClient myTwitterApiClient) {
        this.myTwitterApiClient = myTwitterApiClient;
    }

    public void getTweets(String userId, final LoadTweetsCallback.onTweetsLoaded tweetsCallback) {
        myTwitterApiClient.getCustomTwitterService().getTweets(userId , "10")
                .enqueue(new Callback<List<Tweet>>() {
                    @Override
                    public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
                        if (response.body() != null) {
                            if(response.body().size() > 0) {
                                tweetsCallback.onLoaded(response.body());
                            }else{
                                tweetsCallback.onNoData();
                            }
                        } else {
                            tweetsCallback.onNoData();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Tweet>> call, Throwable t) {
                        tweetsCallback.onNoData();
                    }
                });
    }
}
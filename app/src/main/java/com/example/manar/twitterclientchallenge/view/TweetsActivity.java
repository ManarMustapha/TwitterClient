package com.example.manar.twitterclientchallenge.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.adapter.TweetsAdapter;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.Followers;
import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetsActivity extends AppCompatActivity {

    RecyclerView tweetRV;
    TweetsAdapter tweetsAdapter;
    UserLookUp followerResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);
        setTitle(getString(R.string.tweets));
        tweetRV = findViewById(R.id.tweet_rv);
        tweetRV.setHasFixedSize(true);
        tweetRV.setLayoutManager(new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL,false));
        Intent intent = getIntent();
        if(intent.hasExtra("followerResponse"))
            followerResponse = intent.getParcelableExtra("followerResponse");
        final TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        final ApiClient myTwitterApiClient = new ApiClient(twitterSession);
        myTwitterApiClient.getCustomTwitterService().
                getTweets(String.valueOf(followerResponse.getId()), "10").
                enqueue(new Callback<List<Tweet>>() {
                    @Override
                    public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
                        tweetsAdapter = new TweetsAdapter(response.body() , followerResponse);
                        tweetRV.setAdapter(tweetsAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Tweet>> call, Throwable t) {
                        Log.v("tweet",t.getMessage());
                    }
                });
    }
}
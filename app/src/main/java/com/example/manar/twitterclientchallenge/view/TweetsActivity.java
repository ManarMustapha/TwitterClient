package com.example.manar.twitterclientchallenge.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.manar.twitterclientchallenge.repositry.LoadTweetsCallback;
import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.repositry.TweetsDataSource;
import com.example.manar.twitterclientchallenge.adapter.TweetsAdapter;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.databinding.ActivityTweetsBinding;
import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.example.manar.twitterclientchallenge.viewmodel.TweetInfo;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

public class TweetsActivity extends AppCompatActivity {

    ActivityTweetsBinding activityTweetsBinding;
    TweetsAdapter tweetsAdapter;
    UserLookUp followerResponse;
    TweetsDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTweetsBinding = DataBindingUtil.setContentView(this, R.layout.activity_tweets);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activityTweetsBinding.tweetRv.setHasFixedSize(true);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
        activityTweetsBinding.tweetRv.setLayoutManager(layoutManager);

        DividerItemDecoration
                dividerItemDecoration = new DividerItemDecoration(
                activityTweetsBinding.tweetRv.getContext(), layoutManager.getOrientation());
        activityTweetsBinding.tweetRv.addItemDecoration(dividerItemDecoration);
        Intent intent = getIntent();
        if (intent.hasExtra("followerResponse")) {
            followerResponse = intent.getParcelableExtra("followerResponse");
            activityTweetsBinding.setTweetInfo(new TweetInfo(followerResponse));
            setTitle(followerResponse.getName());
        }
        final TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        ApiClient myTwitterApiClient = new ApiClient(twitterSession);
        activityTweetsBinding.progressBar.setVisibility(View.VISIBLE);
        dataSource = TweetsDataSource.getInstance(myTwitterApiClient);
        dataSource.getTweets(followerResponse.getId(), new LoadTweetsCallback.onTweetsLoaded() {
            @Override
            public void onLoaded(List<Tweet> tweets) {
                tweetsAdapter = new TweetsAdapter(tweets, followerResponse);
                activityTweetsBinding.tweetRv.setAdapter(tweetsAdapter);
                activityTweetsBinding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onNoData() {
                activityTweetsBinding.progressBar.setVisibility(View.GONE);
            }
        });

//        myTwitterApiClient.getCustomTwitterService().
//                getTweets(String.valueOf(followerResponse.getId()), "10").
//                enqueue(new Callback<List<Tweet>>() {
//                    @Override
//                    public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
//                        tweetsAdapter = new TweetsAdapter(response.body() , followerResponse);
//                        activityTweetsBinding.tweetRv.setAdapter(tweetsAdapter);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Tweet>> call, Throwable t) {
//                        Log.v("tweet",t.getMessage());
//                    }
//                });
    }
}
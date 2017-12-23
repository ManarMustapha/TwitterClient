package com.example.manar.twitterclientchallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.FollowersResponse;
import com.example.manar.twitterclientchallenge.util.UserHelper;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        ApiClient myTwitterApiClient = new ApiClient(twitterSession);
        myTwitterApiClient.getCustomTwitterService().
                 getFollowers(twitterSession.getUserId())
                .enqueue(new Callback<FollowersResponse>() {
            @Override
            public void onResponse(Call<FollowersResponse> call, Response<FollowersResponse> response) {
                Log.e("onResponse",response.body().getResults().size()+"");
            }

            @Override
            public void onFailure(Call<FollowersResponse> call, Throwable t) {
                Log.e("onFailure",t.toString());
            }

        });
    }
}

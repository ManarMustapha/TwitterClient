package com.example.manar.twitterclientchallenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.adapter.FollowersAdapter;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.FollowersIds;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    RecyclerView followersrv;
    FollowersAdapter followersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(getString(R.string.followers));
        followersrv = findViewById(R.id.followers_rv);
        followersrv.setHasFixedSize(true);
        followersrv.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false));
        final TwitterSession
                twitterSession = TwitterCore.getInstance().
                getSessionManager().
                getActiveSession();
        final ApiClient myTwitterApiClient = new ApiClient(twitterSession);
        myTwitterApiClient.
                getCustomTwitterService().
                getFollowersIds(twitterSession.getUserId())
                .enqueue(new Callback<FollowersIds>() {
                    @Override
                    public void onResponse(Call<FollowersIds> call, Response<FollowersIds> response) {
                        Log.v("response", response.body().getIds().size() + "");
                        List<String> idList;
                        if (response.body().getIds().size() > 99) {
                            idList = response.body().getIds().subList(0, 99);
                        } else {
                            idList = response.body().getIds();
                        }
                        String ids = join(",", idList);
                        if (ids != null) {
                            myTwitterApiClient.getCustomTwitterService().getFollowers(ids)
                                    .enqueue(new Callback<List<UserLookUp>>() {
                                        @Override
                                        public void onResponse(Call<List<UserLookUp>> call, Response<List<UserLookUp>> response) {
                                            followersAdapter = new FollowersAdapter(response.body() );
                                            followersrv.setAdapter(followersAdapter);
                                        }
                                        @Override
                                        public void onFailure(Call<List<UserLookUp>> call, Throwable t) {

                                        }
                                    });
                        }
                    }

                    @Override
                    public void onFailure(Call<FollowersIds> call, Throwable t) {

                    }
                });
    }

    public String join(String SEPARATOR, List<String> list) {
        StringBuilder csvBuilder = new StringBuilder();
        for (String item : list) {
            csvBuilder.append(item);
            csvBuilder.append(SEPARATOR);
        }
        return csvBuilder.toString();
    }
}
package com.example.manar.twitterclientchallenge.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.adapter.FollowersAdapter;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.client.OfflineResponseCacheInterceptor;
import com.example.manar.twitterclientchallenge.client.ResponseCacheInterceptor;
import com.example.manar.twitterclientchallenge.model.FollowersIds;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.io.File;
import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
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

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new OfflineResponseCacheInterceptor())
                .addNetworkInterceptor(new ResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new Cache(new File(getCacheDir(), "apiResponses"), 5 * 1024 * 1024)).build();


        followersrv = findViewById(R.id.followers_rv);
        followersrv.setHasFixedSize(true);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getApplicationContext(), numberOfColumns());
        followersrv.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(followersrv.getContext(),
                layoutManager.getOrientation());
        followersrv.addItemDecoration(dividerItemDecoration);
        final TwitterSession
                twitterSession = TwitterCore.getInstance().
                getSessionManager().
                getActiveSession();
        final ApiClient myTwitterApiClient = new ApiClient(twitterSession, okHttpClient);
        myTwitterApiClient.
                getCustomTwitterService().
                getFollowersIds(twitterSession.getUserId())
                .enqueue(new Callback<FollowersIds>() {
                    @Override
                    public void onResponse(Call<FollowersIds> call, Response<FollowersIds> response) {
                        if (response.body().getIds().size() > 0) {
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
                                                followersAdapter = new FollowersAdapter(response.body());
                                                followersrv.setAdapter(followersAdapter);
                                            }

                                            @Override
                                            public void onFailure(Call<List<UserLookUp>> call, Throwable t) {

                                            }
                                        });
                            }
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    private int numberOfColumns() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // You can change this divider to adjust the size of the poster
        int widthDivider = 600;
        int width = displayMetrics.widthPixels;
        int nColumns = width / widthDivider;
        if (nColumns < 2) return 1;
        return nColumns;
    }
}
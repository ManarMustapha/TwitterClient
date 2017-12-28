package com.example.manar.twitterclientchallenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;

import com.example.manar.twitterclientchallenge.EndlessRecyclerOnScrollListener;
import com.example.manar.twitterclientchallenge.repositry.FollowersDataSource;
import com.example.manar.twitterclientchallenge.Injection;
import com.example.manar.twitterclientchallenge.repositry.LoadFollowersCallback;
import com.example.manar.twitterclientchallenge.R;


import com.example.manar.twitterclientchallenge.adapter.FollowersAdapter;
import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements LoadFollowersCallback.onFollowersLoaded{

    RecyclerView followersrv;
    FollowersAdapter followersAdapter;
    int currentPage =0;
    List<String> ids;
    ApiClient myTwitterApiClient;
    List<UserLookUp> userLookUps = new ArrayList<>();
    FollowersDataSource dataSource;
    TwitterSession twitterSession;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(getString(R.string.followers));

        followersrv = findViewById(R.id.followers_rv);
        progressBar = findViewById(R.id.progress_bar);
        followersrv.setHasFixedSize(true);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getApplicationContext(), numberOfColumns());
        followersrv.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(followersrv.getContext(),
                layoutManager.getOrientation());
        followersrv.addItemDecoration(dividerItemDecoration);
        followersAdapter = new FollowersAdapter();
        followersrv.setAdapter(followersAdapter);
        addOnScrollListener();
        twitterSession = TwitterCore.getInstance().
                getSessionManager().
                getActiveSession();
        myTwitterApiClient = new ApiClient(twitterSession, Injection.OkHttp(getApplicationContext()));
        dataSource = FollowersDataSource.getInstance(myTwitterApiClient);
        progressBar.setVisibility(View.VISIBLE);
        dataSource.getFollowersId(twitterSession.getUserId(), new LoadFollowersCallback.onIdsLoaded() {
            @Override
            public void onFollowersIdsLoaded(List<String> idsList) {
                ids = idsList;
                getFollowers();
            }

            @Override
            public void onNoData() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void getFollowers(){
        if(ids.size()>100*currentPage){
            progressBar.setVisibility(View.VISIBLE);
            if(ids.size()>100+100*currentPage){
                dataSource.getFollowers(join(",",ids.subList(100*currentPage,99+100*currentPage)),this);
            }else{
                dataSource.getFollowers(join(",",ids.subList(100*currentPage,ids.size())),this);
            }
            currentPage ++;

        }

    }

    public String join(String SEPARATOR, List<String> list) {
        StringBuilder csvBuilder = new StringBuilder();
        for (String item : list) {
            csvBuilder.append(item);
            csvBuilder.append(SEPARATOR);
        }
        return csvBuilder.toString();
    }

    private void addOnScrollListener(){
        followersrv.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
//                Toast.makeText(getContext(), "Load More" + super.toString(), Toast.LENGTH_SHORT).show();
                getFollowers();

            }
        });
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

    @Override
    public void onLoaded(List<UserLookUp> followers) {
        userLookUps.addAll(followers);
        followersAdapter.updateItems(userLookUps);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onNoData() {
        progressBar.setVisibility(View.GONE);
    }
}
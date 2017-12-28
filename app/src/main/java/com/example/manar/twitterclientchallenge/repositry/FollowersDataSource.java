package com.example.manar.twitterclientchallenge.repositry;

import com.example.manar.twitterclientchallenge.client.ApiClient;
import com.example.manar.twitterclientchallenge.model.FollowersIds;
import com.example.manar.twitterclientchallenge.model.UserLookUp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manar on 28/12/17.
 */

public class FollowersDataSource {

    private static FollowersDataSource INSTANCE;
    private ApiClient myTwitterApiClient;

    public static FollowersDataSource getInstance(ApiClient myTwitterApiClient) {
        if (INSTANCE == null) {
            INSTANCE = new FollowersDataSource(myTwitterApiClient);
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private FollowersDataSource(ApiClient myTwitterApiClient) {
        this.myTwitterApiClient = myTwitterApiClient;
    }

    public void getFollowers(String ids, final LoadFollowersCallback.onFollowersLoaded followersCallback) {
        myTwitterApiClient.getCustomTwitterService().getFollowers(ids)
                .enqueue(new Callback<List<UserLookUp>>() {
                    @Override
                    public void onResponse(Call<List<UserLookUp>> call, Response<List<UserLookUp>> response) {
                        if (response.body() != null) {
                            followersCallback.onLoaded(response.body());
                        } else {
                            followersCallback.onNoData();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserLookUp>> call, Throwable t) {
                        followersCallback.onNoData();
                    }
                });
    }

    public void getFollowersId(long userId, final LoadFollowersCallback.onIdsLoaded onIdsLoaded) {
        myTwitterApiClient.
                getCustomTwitterService().
                getFollowersIds(userId)
                .enqueue(new Callback<FollowersIds>() {
                    @Override
                    public void onResponse(Call<FollowersIds> call, Response<FollowersIds> response) {
                        if (response.body().getIds().size() > 0) {
                            onIdsLoaded.onFollowersIdsLoaded(response.body().getIds());
                        } else {
                            onIdsLoaded.onNoData();
                        }
                    }

                    @Override
                    public void onFailure(Call<FollowersIds> call, Throwable t) {

                    }
                });
    }
}
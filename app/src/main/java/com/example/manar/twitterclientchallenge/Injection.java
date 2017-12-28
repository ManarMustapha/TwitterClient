package com.example.manar.twitterclientchallenge;

import android.content.Context;

import com.example.manar.twitterclientchallenge.client.OfflineResponseCacheInterceptor;
import com.example.manar.twitterclientchallenge.client.ResponseCacheInterceptor;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by manar on 28/12/17.
 */

public class Injection {

    public static OkHttpClient OkHttp(Context context) {

        return new OkHttpClient.Builder()
                .addInterceptor(new OfflineResponseCacheInterceptor())
                .addNetworkInterceptor(new ResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new Cache(new File(context.getCacheDir(), "apiResponses"), 5 * 1024 * 1024)).build();
    }
}

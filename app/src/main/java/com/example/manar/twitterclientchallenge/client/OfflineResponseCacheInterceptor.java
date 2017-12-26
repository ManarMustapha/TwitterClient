package com.example.manar.twitterclientchallenge.client;

import com.example.manar.twitterclientchallenge.application.CustomApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by manar on 26/12/17.
 */

public class OfflineResponseCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!CustomApplication.hasNetwork()) {
            request = request.newBuilder()
                    .header("Cache-Control",
                            "public, only-if-cached, max-stale=" + 2419200)
                    .build();
        }
        return chain.proceed(request);
    }
}
package com.example.manar.twitterclientchallenge.client;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by manar on 26/12/17.
 */

public class ResponseCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .removeHeader("pragma")
                .header("Cache-Control", "public, max-age=" + 2419200)
                .build();
    }
}
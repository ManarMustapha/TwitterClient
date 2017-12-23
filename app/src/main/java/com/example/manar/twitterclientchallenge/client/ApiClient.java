package com.example.manar.twitterclientchallenge.client;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by manar on 23/12/17.
 */

public class ApiClient extends TwitterApiClient{

    public ApiClient(TwitterSession session) {
        super(session);
    }

    /**
     * Provide CustomService with defined endpoints
     */
    public ApiClientListeners getCustomTwitterService() {
        return getService(ApiClientListeners.class);
    }

}

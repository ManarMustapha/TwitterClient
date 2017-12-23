package com.example.manar.twitterclientchallenge.model;

/**
 * Created by manar on 23/12/17.
 */

public class User {

    private String username;
    private String secret;
    private String token;
    private long userId;

    public User(String username, String secret, String token, long userId) {
        this.username = username;
        this.secret = secret;
        this.token = token;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}

package com.example.manar.twitterclientchallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.databinding.TweetItemBinding;
import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.example.manar.twitterclientchallenge.viewmodel.TweetInfo;

import java.util.List;

/**
 * Created by manar on 26/12/17.
 */

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.TweetsViewHolder> {

    private List<Tweet> tweetList;
    private UserLookUp followers;

    public TweetsAdapter(List<Tweet> tweetList , UserLookUp followers) {
        this.tweetList = tweetList;
        this.followers = followers;
    }

    @Override
    public TweetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TweetItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.tweet_item, parent, false);
        return new TweetsViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(TweetsViewHolder holder, int position) {

        holder.setTweets(tweetList.get(position) , followers);
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    class TweetsViewHolder extends RecyclerView.ViewHolder {

        TweetItemBinding tweetItemBinding;

        TweetsViewHolder(TweetItemBinding tweetItemBinding) {
            super(tweetItemBinding.getRoot());
            this.tweetItemBinding = tweetItemBinding;
        }

        void setTweets(Tweet tweet , UserLookUp followers) {
            tweetItemBinding.setTweet(new TweetInfo(tweet , followers));
        }
    }
}
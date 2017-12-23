package com.example.manar.twitterclientchallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.databinding.FollowersItemBinding;
import com.example.manar.twitterclientchallenge.model.FollowersResponse;
import com.example.manar.twitterclientchallenge.viewmodel.FollowersInfo;

import java.util.List;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    private List<FollowersResponse> followersResponseList;

    public FollowersAdapter(List<FollowersResponse> followersResponseList) {
        this.followersResponseList = followersResponseList;
    }

    @Override
    public FollowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FollowersItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.followers_item, parent, false);
        return new FollowersViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(FollowersViewHolder holder, int position) {

        holder.followersItemBinding.setFollowers(new FollowersInfo(followersResponseList.get(position)));
    }

    @Override
    public int getItemCount() {
        return followersResponseList.size();
    }

    class FollowersViewHolder extends RecyclerView.ViewHolder {
        FollowersItemBinding followersItemBinding;

        FollowersViewHolder(FollowersItemBinding followersItemBinding) {
            super(followersItemBinding.getRoot());
            this.followersItemBinding = followersItemBinding;
        }
    }
}
package com.example.manar.twitterclientchallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.databinding.FollowersItemBinding;
import com.example.manar.twitterclientchallenge.model.Followers;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.example.manar.twitterclientchallenge.viewmodel.FollowersInfo;

import java.util.List;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    private List<UserLookUp> followersResponseList;

    public FollowersAdapter(List<UserLookUp> followersResponseList) {
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

        holder.setFollowers(new FollowersInfo(followersResponseList.get(position)));
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
        void setFollowers(FollowersInfo followersInfo){
            followersItemBinding.setFollowers(followersInfo);
        }
    }
}
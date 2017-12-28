package com.example.manar.twitterclientchallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.manar.twitterclientchallenge.DiffCallback;
import com.example.manar.twitterclientchallenge.R;
import com.example.manar.twitterclientchallenge.databinding.FollowersItemBinding;
import com.example.manar.twitterclientchallenge.model.UserLookUp;
import com.example.manar.twitterclientchallenge.viewmodel.FollowersItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    private List<UserLookUp> followersResponseList;

    public FollowersAdapter() {
        followersResponseList = new ArrayList<>();
    }

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

        holder.setFollowers(new FollowersItem(followersResponseList.get(position)));
    }

    @Override
    public int getItemCount() {
        return followersResponseList == null ? 0 : followersResponseList.size();
    }

    public void updateItems(List<UserLookUp> actors) {
        final DiffCallback diffCallback = new DiffCallback(this.followersResponseList, actors);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.followersResponseList.clear();
        this.followersResponseList.addAll(actors);
        diffResult.dispatchUpdatesTo(this);
    }

    class FollowersViewHolder extends RecyclerView.ViewHolder {

        FollowersItemBinding followersItemBinding;

        FollowersViewHolder(FollowersItemBinding followersItemBinding) {
            super(followersItemBinding.getRoot());
            this.followersItemBinding = followersItemBinding;
        }

        void setFollowers(FollowersItem followersItem) {
            followersItemBinding.setFollowers(followersItem);
        }
    }
}
package com.example.manar.twitterclientchallenge;

/**
 * Created by manar on 28/12/17.
 */

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.manar.twitterclientchallenge.model.UserLookUp;

import java.util.List;

public class DiffCallback extends DiffUtil.Callback {


    private final List<UserLookUp> oldList;
    private final List<UserLookUp> newList;

    public DiffCallback(List<UserLookUp> oldList, List<UserLookUp> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final UserLookUp oldItem = oldList.get(oldItemPosition);
        final UserLookUp newItem = newList.get(newItemPosition);

        return oldItem.getId().equals(newItem.getId());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
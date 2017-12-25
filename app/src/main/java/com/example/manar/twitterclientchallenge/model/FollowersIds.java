package com.example.manar.twitterclientchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by manar on 25/12/17.
 */

public class FollowersIds implements Parcelable {

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @SerializedName("ids")
    @Expose
    private List<String> ids;
    @SerializedName("next_cursor")
    @Expose
    private Integer nextCursor;
    @SerializedName("next_cursor_str")
    @Expose
    private String nextCursorStr;
    @SerializedName("previous_cursor")
    @Expose
    private Integer previousCursor;
    @SerializedName("previous_cursor_str")
    @Expose
    private String previousCursorStr;


    protected FollowersIds(Parcel in) {
        nextCursorStr = in.readString();
        previousCursorStr = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nextCursorStr);
        dest.writeString(previousCursorStr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FollowersIds> CREATOR = new Creator<FollowersIds>() {
        @Override
        public FollowersIds createFromParcel(Parcel in) {
            return new FollowersIds(in);
        }

        @Override
        public FollowersIds[] newArray(int size) {
            return new FollowersIds[size];
        }
    };
}

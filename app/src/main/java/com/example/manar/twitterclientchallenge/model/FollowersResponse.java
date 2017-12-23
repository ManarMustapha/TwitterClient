package com.example.manar.twitterclientchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manar on 23/12/17.
 */

public class FollowersResponse implements Parcelable {

    public Integer getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(Integer previousCursor) {
        this.previousCursor = previousCursor;
    }

    public String getPreviousCursorStr() {
        return previousCursorStr;
    }

    public void setPreviousCursorStr(String previousCursorStr) {
        this.previousCursorStr = previousCursorStr;
    }

    public String getNextCursorStr() {
        return nextCursorStr;
    }

    public void setNextCursorStr(String nextCursorStr) {
        this.nextCursorStr = nextCursorStr;
    }

    public List<Followers> getResults() {
        return results;
    }

    public void setResults(List<Followers> results) {
        this.results = results;
    }

    @SerializedName("previous_cursor")
    @Expose
    private Integer previousCursor;

    @SerializedName("previous_cursor_str")
    @Expose
    private String previousCursorStr;

    @SerializedName("next_cursor_str")
    @Expose
    private String nextCursorStr;

    @SerializedName("users")
    @Expose
    private List<Followers> results = new ArrayList<Followers>();

    protected FollowersResponse(Parcel in) {
        previousCursorStr = in.readString();
        nextCursorStr = in.readString();
        results = in.createTypedArrayList(Followers.CREATOR);
    }

    public static final Creator<FollowersResponse> CREATOR = new Creator<FollowersResponse>() {
        @Override
        public FollowersResponse createFromParcel(Parcel in) {
            return new FollowersResponse(in);
        }

        @Override
        public FollowersResponse[] newArray(int size) {
            return new FollowersResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(previousCursorStr);
        parcel.writeString(nextCursorStr);
        parcel.writeTypedList(results);
    }
}

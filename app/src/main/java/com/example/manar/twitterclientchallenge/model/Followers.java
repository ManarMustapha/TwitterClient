package com.example.manar.twitterclientchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manar on 23/12/17.
 */

public class Followers implements Parcelable{

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_image_url_https")
    @Expose
    private String profilePictureUrl;

    @SerializedName("screen_name")
    @Expose
    private String screenName;

    private Followers(Parcel in) {
        id = in.readLong();
        name = in.readString();
        profilePictureUrl = in.readString();
        screenName = in.readString();
    }

    public static final Creator<Followers> CREATOR = new Creator<Followers>() {
        @Override
        public Followers createFromParcel(Parcel in) {
            return new Followers(in);
        }

        @Override
        public Followers[] newArray(int size) {
            return new Followers[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(profilePictureUrl);
        parcel.writeString(screenName);
    }
}

package com.example.manar.twitterclientchallenge.helper;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.example.manar.twitterclientchallenge.adapter.TweetsAdapter;
import com.example.manar.twitterclientchallenge.model.Tweet;
import com.example.manar.twitterclientchallenge.util.GlideApp;

import java.util.List;

/**
 * Created by manar on 24/12/17.
 */

public class BindingHelper {

    @BindingAdapter("android:circleImageUrl")
    public static void loadImage(ImageView view, String url) {
        GlideApp.with(view.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }

    @BindingAdapter("android:imageUrl")
    public static void loadCover(ImageView view, String url) {
        GlideApp.with(view.getContext())
                .load(url)
                .into(view);
    }

}
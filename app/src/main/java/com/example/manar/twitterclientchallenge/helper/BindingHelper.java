package com.example.manar.twitterclientchallenge.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.example.manar.twitterclientchallenge.util.GlideApp;

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
}
package com.example.wtl.ttms_hdd.TheHome.presenter.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 重写banner的图片加载器
 * Created by WTL on 2018/6/8.
 */

public class ImageGlideAdapter extends ImageLoader{

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

}

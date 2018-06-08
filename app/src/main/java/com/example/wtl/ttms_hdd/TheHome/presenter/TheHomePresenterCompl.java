package com.example.wtl.ttms_hdd.TheHome.presenter;

import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.ImageGlideAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页逻辑层实现
 * Created by WTL on 2018/6/8.
 */

public class TheHomePresenterCompl implements ITheHomePresenter {

    private List<String> urlImage = new ArrayList<>();

    @Override
    public List<String> loadImage(Banner banner) {
        banner.setImageLoader(new ImageGlideAdapter());
        banner.setDelayTime(4000);
        urlImage.add("http://2t.5068.com/uploads/allimg/151027/57-15102G45306-51.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/06.jpg");
        urlImage.add("http://uploads.5068.com/allimg/1712/151-1G2010U113.jpg");
        urlImage.add("http://pic1.win4000.com/wallpaper/8/596345446e294.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/07.jpg");
        banner.setImages(urlImage);
        banner.start();
        return null;
    }
}

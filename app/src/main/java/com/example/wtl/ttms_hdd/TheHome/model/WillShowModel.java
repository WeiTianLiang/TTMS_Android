package com.example.wtl.ttms_hdd.TheHome.model;

/**
 * 即将上映类
 * Created by WTL on 2018/6/9.
 */

public class WillShowModel {

    private int homeshow_image;
    private String homeshow_name;
    private String homeshow_time;

    public WillShowModel(int homeshow_image,String homeshow_name,String homeshow_time) {
        this.homeshow_image = homeshow_image;
        this.homeshow_name = homeshow_name;
        this.homeshow_time = homeshow_time;
    }

    public int getHomeshow_image() {
        return homeshow_image;
    }

    public String getHomeshow_name() {
        return homeshow_name;
    }

    public String getHomeshow_time() {
        return homeshow_time;
    }
}

package com.example.wtl.ttms_hdd.TheHome.model;

/**
 * 热映类
 * Created by WTL on 2018/6/9.
 */

public class HotSowModel {

    private int homeshow_image;
    private String homeshow_name;

    public HotSowModel(int homeshow_image,String homeshow_name) {
        this.homeshow_image = homeshow_image;
        this.homeshow_name = homeshow_name;
    }

    public int getHomeshow_image() {
        return homeshow_image;
    }

    public String getHomeshow_name() {
        return homeshow_name;
    }
}

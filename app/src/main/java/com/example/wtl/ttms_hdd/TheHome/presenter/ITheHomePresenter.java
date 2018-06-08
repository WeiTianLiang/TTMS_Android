package com.example.wtl.ttms_hdd.TheHome.presenter;

import com.youth.banner.Banner;

import java.util.List;

/**
 * 主页逻辑层接口
 * Created by WTL on 2018/6/8.
 */

public interface ITheHomePresenter {

    /**
    * 加载图片数据
    * */
    List<String> loadImage(Banner banner);

}

package com.example.wtl.ttms_hdd.TheHome.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.List;

/**
 * 主页逻辑层接口
 * Created by WTL on 2018/6/8.
 */

public interface ITheHomePresenter {

    /**
     * 添加正在上映适配器
     */
    void setHotAdapter(RecyclerView recyclerView, TextView textView,Banner banner);

    /**
     * 添加即将上映适配器
     */
    void setWillAdapter(RecyclerView recyclerView, TextView textView);

}

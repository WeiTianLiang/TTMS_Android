package com.example.wtl.ttms_hdd.Film.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * 电影接口
 * Created by WTL on 2018/6/8.
 */

public interface IFilmPresenter {

    /**
     * 正在上映适配器
     */
    void setFilmSellAdapter(RecyclerView recyclerView);

    /**
     * 即将上映适配器
     */
    void setWillFilmSellAdapter(RecyclerView recyclerView);

    /**
     * fragment分页适配器
     */
    void setHDDPagerAdapter(ViewPager viewPager, FragmentManager fm, List<Fragment> fragmentList, List<String> list);

}

package com.example.wtl.ttms_hdd.HDDMain.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.example.wtl.ttms_hdd.HDDMain.model.FileModel;

import java.util.List;

/**
 * 逻辑接口
 * Created by WTL on 2018/6/5.
 */

public interface IHDDMainPresenter {
    /**
     * 获取数据
     */
    List<FileModel> getData();

    /**
     * recyclerview适配器
     */
    void setFilmSellAdapter(RecyclerView recyclerView, List<FileModel> fileModelList, Context context);

    /**
     * fragment分页适配器
     */
    void setHDDPagerAdapter(ViewPager viewPager, FragmentManager fm, List<Fragment> fragmentList, List<String> list);
}

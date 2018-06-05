package com.example.wtl.ttms_hdd.HDDMain.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 重写碎片翻页适配器
 * Created by WTL on 2018/6/5.
 */

public class HDDPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    private List<String> list;

    public HDDPagerAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> list) {
        super(fm);
        this.fragmentList = fragmentList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}

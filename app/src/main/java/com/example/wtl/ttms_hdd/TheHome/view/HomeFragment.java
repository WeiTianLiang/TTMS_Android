package com.example.wtl.ttms_hdd.TheHome.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.TheHome.presenter.ITheHomePresenter;
import com.example.wtl.ttms_hdd.TheHome.presenter.TheHomePresenterCompl;
import com.youth.banner.Banner;

/**
 * 主页fragment
 * Created by WTL on 2018/6/8.
 */

public class HomeFragment extends Fragment {

    private Banner broadcast;
    private View view;
    private ITheHomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        broadcast = view.findViewById(R.id.broadcast);
        if(presenter == null) {
            presenter = new TheHomePresenterCompl();
        }
        presenter.loadImage(broadcast);
        return view;
    }
}
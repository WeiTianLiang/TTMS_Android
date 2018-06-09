package com.example.wtl.ttms_hdd.Film.view.mainFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms_hdd.Film.presenter.FilmResenterCompl;
import com.example.wtl.ttms_hdd.Film.presenter.IFilmPresenter;
import com.example.wtl.ttms_hdd.Film.view.fragment.NowFilmShowFragment;
import com.example.wtl.ttms_hdd.Film.view.fragment.WillFilmShowFragment;
import com.example.wtl.ttms_hdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 影片汇总碎片
 * Created by WTL on 2018/6/8.
 */

public class FilmShowFragment extends Fragment {

    /**
     * 顶部导航
     */
    private TabLayout HDDtoptitle;
    /**
     * 碎片list
     */
    private List<Fragment> fragmentList = new ArrayList<>();
    /**
     * 标题list
     */
    private List<String> stringList = new ArrayList<>();

    /**
     * viewpager
     */
    private ViewPager HDDviewpager;
    /**
     * presenter层接口
     */
    private IFilmPresenter presenter;
    /**
     * 接收广播
     */
    private IntentFilter filter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);

        HDDtoptitle = view.findViewById(R.id.HDDtoptitle);
        HDDviewpager = view.findViewById(R.id.HDDviewpager);

        fragmentList.add(new NowFilmShowFragment());
        fragmentList.add(new WillFilmShowFragment());
        stringList.add("正在热映");
        stringList.add("即将上映");

        if (presenter == null) {
            presenter = new FilmResenterCompl(getContext());
        }
        presenter.setHDDPagerAdapter(HDDviewpager, getFragmentManager(), fragmentList, stringList);
        HDDviewpager.setOffscreenPageLimit(2);
        HDDtoptitle.setupWithViewPager(HDDviewpager);
        filter = new IntentFilter("com.example.wtl.ttms_hdd.home_number");
        getContext().registerReceiver(broadcastReceiver, filter);
        return view;
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String state = intent.getStringExtra("state");
            if (state != null) {
                if (state.equals("now")) {
                    HDDviewpager.setCurrentItem(0);
                    HDDtoptitle.getTabAt(0).select();
                } else if (state.equals("will")) {
                    HDDviewpager.setCurrentItem(1);
                    HDDtoptitle.getTabAt(1).select();
                } else {
                    Log.e("错误：", "接收失败!!!");
                }
            } else {
                Log.e("错误：", "失败。。。。。。。。。。。");
            }
        }
    };

    @Override
    public void onDestroyView() {
        getContext().unregisterReceiver(broadcastReceiver);
        super.onDestroyView();
    }
}

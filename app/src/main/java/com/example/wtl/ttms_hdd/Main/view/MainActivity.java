package com.example.wtl.ttms_hdd.Main.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wtl.ttms_hdd.Film.view.mainFragment.FilmShowFragment;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.TheHome.view.HomeFragment;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;
import com.gyf.barlibrary.ImmersionBar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bottom_navigation;
    /**
     * 电影碎片
     */
    private FilmShowFragment showFragment;
    /**
     * 首页碎片
     */
    private HomeFragment homeFragment;
    /**
     * 接受广播
     */
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideScreenTop.HideScreenTop(getWindow());
        bottom_navigation = (BottomNavigationBar) findViewById(R.id.bottom_navigation);
        /*
        * 设置样式
        * */
        bottom_navigation.setMode(BottomNavigationBar.MODE_FIXED)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setBarBackgroundColor(R.color.white)//背景颜色
                .setInActiveColor(R.color.nav_gray)//未选中时的颜色
                .setActiveColor(R.color.changeclick)//选中时的颜色
                .addItem(new BottomNavigationItem(R.mipmap.home, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.movie, "影片"))
                .addItem(new BottomNavigationItem(R.mipmap.hallitem, "影厅"))
                .addItem(new BottomNavigationItem(R.mipmap.my, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();
        change(bottom_navigation);
        firstSelect();
        filter = new IntentFilter("com.example.wtl.ttms_hdd.home_number");
        registerReceiver(broadcastReceiver,filter);
    }

    /**
     * 第一次加载
     */
    private void firstSelect() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        transaction.replace(R.id.add_fragment, homeFragment);
        transaction.show(homeFragment);
        transaction.commit();
    }

    private void change(BottomNavigationBar bottom_navigation) {
        bottom_navigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                hideFragment(transaction);
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            transaction.add(R.id.add_fragment, homeFragment);
                        }
                        transaction.show(homeFragment);
                        break;
                    case 1:
                        if (showFragment == null) {
                            showFragment = new FilmShowFragment();
                            transaction.add(R.id.add_fragment, showFragment);
                        }
                        transaction.show(showFragment);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (showFragment != null) {
            transaction.hide(showFragment);
        }
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String state = intent.getStringExtra("state");
            if (state != null) {
                if (state.equals("now")) {
                    bottom_navigation.selectTab(1);
                } else if (state.equals("will")) {
                    bottom_navigation.selectTab(1);
                } else {
                    Log.e("错误：","错误的接收值");
                }
            } else {
                Log.e("错误：","失败。。。。。。。。。。。");
            }
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}

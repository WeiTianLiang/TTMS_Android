package com.example.wtl.ttms_hdd.HDDMain.view.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.wtl.ttms_hdd.HDDMain.presenter.HDDMainPresenterCompl;
import com.example.wtl.ttms_hdd.HDDMain.presenter.IHDDMainPresenter;
import com.example.wtl.ttms_hdd.HDDMain.view.Fragment.FilmSellFragment;
import com.example.wtl.ttms_hdd.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
    * 顶部导航
    * */
    private TabLayout HDDtoptitle;
    /**
     * 碎片list
     * */
    private List<Fragment> fragmentList = new ArrayList<>();
    /**
     * 标题list
     * */
    private List<String> stringList = new ArrayList<>();

    /**
     * viewpager
     * */
    private ViewPager HDDviewpager;
    /**
     * presenter层接口
     * */
    private IHDDMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HDDtoptitle = findViewById(R.id.HDDtoptitle);
        HDDviewpager = findViewById(R.id.HDDviewpager);

        fragmentList.add(new FilmSellFragment());
        stringList.add("影片");

        if(presenter == null) {
            presenter = new HDDMainPresenterCompl(this);
        }
        presenter.setHDDPagerAdapter(HDDviewpager,getSupportFragmentManager(),fragmentList,stringList);
        HDDviewpager.setOffscreenPageLimit(1);
        HDDtoptitle.setupWithViewPager(HDDviewpager);
    }

}

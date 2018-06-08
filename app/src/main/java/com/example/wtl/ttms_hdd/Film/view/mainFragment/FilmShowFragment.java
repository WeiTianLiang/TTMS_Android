package com.example.wtl.ttms_hdd.Film.view.mainFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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

public class FilmShowFragment extends Fragment{

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
    private IFilmPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film,container,false);

        HDDtoptitle = view.findViewById(R.id.HDDtoptitle);
        HDDviewpager = view.findViewById(R.id.HDDviewpager);

        fragmentList.add(new NowFilmShowFragment());
        fragmentList.add(new WillFilmShowFragment());
        stringList.add("正在热映");
        stringList.add("即将上映");

        if(presenter == null) {
            presenter = new FilmResenterCompl(getContext());
        }
        presenter.setHDDPagerAdapter(HDDviewpager,getFragmentManager(),fragmentList,stringList);
        HDDviewpager.setOffscreenPageLimit(2);
        HDDtoptitle.setupWithViewPager(HDDviewpager);

        return view;
    }
}

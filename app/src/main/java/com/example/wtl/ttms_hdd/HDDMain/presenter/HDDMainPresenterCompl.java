package com.example.wtl.ttms_hdd.HDDMain.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import com.example.wtl.ttms_hdd.HDDMain.model.FileModel;
import com.example.wtl.ttms_hdd.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑具体实现
 * Created by WTL on 2018/6/5.
 */

public class HDDMainPresenterCompl implements IHDDMainPresenter {

    private Context context;

    public HDDMainPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public List<FileModel> getData() {
        List<FileModel> list = new ArrayList<>();
        FileModel model = new FileModel(R.drawable.ceshi, "123", "asd", "9.0");
        list.add(model);
        return list;
    }

    @Override
    public void setFilmSellAdapter(RecyclerView recyclerView, List<FileModel> fileModelList, Context context) {
        FilmSellAdapter adapter = new FilmSellAdapter(fileModelList, context);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setHDDPagerAdapter(ViewPager viewPager, FragmentManager fm, List<Fragment> fragmentList, List<String> list) {
        HDDPagerAdapter pagerAdapter = new HDDPagerAdapter(fm, fragmentList, list);
        viewPager.setAdapter(pagerAdapter);
    }

}

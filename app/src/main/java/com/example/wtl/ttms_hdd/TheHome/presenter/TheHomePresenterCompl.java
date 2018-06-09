package com.example.wtl.ttms_hdd.TheHome.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;
import com.example.wtl.ttms_hdd.TheHome.model.WillShowModel;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.HotShowAdapter;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.ImageGlideAdapter;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.WillShowAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页逻辑层实现
 * Created by WTL on 2018/6/8.
 */

public class TheHomePresenterCompl implements ITheHomePresenter {

    private List<String> urlImage = new ArrayList<>();
    private Context context;

    private List<HotSowModel> hotSowModels = new ArrayList<>();
    private List<WillShowModel> willShowModels = new ArrayList<>();

    public TheHomePresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public List<String> loadImage(Banner banner) {
        banner.setImageLoader(new ImageGlideAdapter());
        banner.setDelayTime(4000);
        urlImage.add("http://2t.5068.com/uploads/allimg/151027/57-15102G45306-51.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/06.jpg");
        urlImage.add("http://uploads.5068.com/allimg/1712/151-1G2010U113.jpg");
        urlImage.add("http://pic1.win4000.com/wallpaper/8/596345446e294.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/07.jpg");
        banner.setImages(urlImage);
        banner.start();
        return null;
    }

    @Override
    public void setHotAdapter(RecyclerView recyclerView) {
        HotSowModel model = new HotSowModel(R.drawable.ceshi,"牛逼串串");
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        hotSowModels.add(model);
        HotShowAdapter adapter = new HotShowAdapter(context,hotSowModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setWillAdapter(RecyclerView recyclerView) {
        WillShowModel model = new WillShowModel(R.drawable.ceshi,"牛逼串串","6月68日");
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        willShowModels.add(model);
        WillShowAdapter adapter = new WillShowAdapter(context,willShowModels);
        recyclerView.setAdapter(adapter);
    }
}

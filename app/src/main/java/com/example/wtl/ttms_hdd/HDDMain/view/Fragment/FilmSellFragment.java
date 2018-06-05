package com.example.wtl.ttms_hdd.HDDMain.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms_hdd.HDDMain.model.FileModel;
import com.example.wtl.ttms_hdd.HDDMain.presenter.HDDMainPresenterCompl;
import com.example.wtl.ttms_hdd.HDDMain.presenter.IHDDMainPresenter;
import com.example.wtl.ttms_hdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 卖票碎片
 * Created by WTL on 2018/6/5.
 */

public class FilmSellFragment extends Fragment {
    /**
    * recyclerview列表
    * */
    private RecyclerView filmrecycler;
    /**
     * 列表信息list
     * */
    private List<FileModel> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filmrecycler,container,false);
        filmrecycler = view.findViewById(R.id.filmrecycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        filmrecycler.setLayoutManager(manager);

        IHDDMainPresenter presenter = new HDDMainPresenterCompl(getContext());
        list = presenter.getData();
        presenter.setFilmSellAdapter(filmrecycler,list,getContext());

        return view;
    }


}

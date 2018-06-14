package com.example.wtl.ttms_hdd.Film.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms_hdd.Film.presenter.FilmResenterCompl;
import com.example.wtl.ttms_hdd.Film.presenter.IFilmPresenter;
import com.example.wtl.ttms_hdd.R;

/**
 * 即将上映碎片
 * Created by WTL on 2018/6/8.
 */

public class WillFilmShowFragment extends Fragment{


    private View view;
    private RecyclerView filmrecycler;
    private IFilmPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.filmrecycler, container, false);
        }
        filmrecycler = view.findViewById(R.id.filmrecycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        filmrecycler.setLayoutManager(manager);
        if (presenter == null) {
            presenter = new FilmResenterCompl(getContext());
        }
        presenter.setWillFilmSellAdapter(filmrecycler);
        return view;
    }
}

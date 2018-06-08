package com.example.wtl.ttms_hdd.Film.presenter;

import com.example.wtl.ttms_hdd.Film.model.FilmModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 获取影片信息
 * Created by WTL on 2018/6/7.
 */

public interface GetFilm_Inference {

    @GET("/Programme")
    Call<FilmModel> getFilmBase();
}

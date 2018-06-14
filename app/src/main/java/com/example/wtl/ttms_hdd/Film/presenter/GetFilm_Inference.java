package com.example.wtl.ttms_hdd.Film.presenter;

import com.example.wtl.ttms_hdd.Film.model.FilmModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 获取影片信息
 * Created by WTL on 2018/6/7.
 */

public interface GetFilm_Inference {

    @POST("/Good/SelectGoodWithName")
    Call<FilmModel> getFilmBase(@Body RequestBody body);
}

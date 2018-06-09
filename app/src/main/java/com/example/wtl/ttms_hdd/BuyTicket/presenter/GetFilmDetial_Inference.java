package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import com.example.wtl.ttms_hdd.BuyTicket.model.FilmdetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 获取数据
 * Created by WTL on 2018/6/9.
 */

public interface GetFilmDetial_Inference {

    @GET("/Programme/QueryProgrammeByName/{programmeName}")
    Call<FilmdetailModel> getFilmDetail(@Path("programmeName") String name);

}

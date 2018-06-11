package com.example.wtl.ttms_hdd.TheHome.presenter;

import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 接收数据
 * Created by WTL on 2018/6/9.
 */

public interface GetHomeFilm_Inference {

    @GET("/Programme")
    Call<HotSowModel> getHotShow();

    @GET("/Programme")
    Call<HotSowModel> getWillShow();

}

package com.example.wtl.ttms_hdd.TheHome.presenter;

import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 接收数据
 * Created by WTL on 2018/6/9.
 */

public interface GetHomeFilm_Inference {

    @POST("/Good/SelectGoodWithName")
    Call<HotSowModel> getFilmMess(@Body RequestBody body);

}

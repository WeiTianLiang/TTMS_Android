package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import com.example.wtl.ttms_hdd.BuyTicket.model.DataPlanModel;
import com.example.wtl.ttms_hdd.BuyTicket.model.FilmdetailModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 获取数据
 * Created by WTL on 2018/6/9.
 */

public interface GetFilmDetial_Inference {

    @GET("/Programme/QueryProgrammeByName/{programmeName}")
    Call<FilmdetailModel> getFilmDetail(@Path("programmeName") String name);

    @POST("/Good/SelectGoodWithName")
    Call<DataPlanModel> getDataPlan(@Body RequestBody programmeId);

}

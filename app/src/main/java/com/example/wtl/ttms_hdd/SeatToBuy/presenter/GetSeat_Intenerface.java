package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import com.example.wtl.ttms_hdd.SeatToBuy.model.SeatModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 请求数据接口
 * Created by WTL on 2018/6/12.
 */

public interface GetSeat_Intenerface {

    @GET("/Seat/SelectSeat/{theaterId}")
    Call<SeatModel> getSeatDate(@Path("theaterId") int theaterId);

}

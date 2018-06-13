package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import com.example.wtl.ttms_hdd.SeatToBuy.model.GetTicketModel;
import com.example.wtl.ttms_hdd.SeatToBuy.model.SeatModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 请求数据接口
 * Created by WTL on 2018/6/12.
 */

public interface GetSeat_Intenerface {

    @GET("/Seat/SelectSeat/{theaterId}")
    Call<SeatModel> getSeatDate(@Path("theaterId") int theaterId);

    @GET("/Ticket/SelectTicket/{goodId}")
    Call<GetTicketModel> getTicketMessage(@Path("goodId") int gooId);

}

package com.example.wtl.ttms_hdd.PayMoney.presenter;

import com.example.wtl.ttms_hdd.NetTool.ResultModel;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 支付请求
 * Created by WTL on 2018/6/14.
 */

public interface GetPay_Inference {

    @POST("/Ticket/PayTicket/{ticketId}&{userId}")
    Call<ResultModel> postPay(@Path("ticketId") int ticketId,@Path("userId") int userId);

}

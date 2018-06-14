package com.example.wtl.ttms_hdd.IsPayTicket.presenter;

import com.example.wtl.ttms_hdd.IsPayTicket.model.IsDateModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public interface GetIsPay_Interenter {

    @POST("/Order/SelectOrder")
    Call<IsDateModel> postIsPay(@Body RequestBody body);

}

package com.example.wtl.ttms_hdd.WaitToPay.presenter;

import com.example.wtl.ttms_hdd.WaitToPay.model.WaitDateModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public interface GetWaitPay_Interence {

    @GET("/Order/SelectUnPaidOrder/{userId}")
    Call<WaitDateModel> postWaitDate(@Path("userId") int userId);

}

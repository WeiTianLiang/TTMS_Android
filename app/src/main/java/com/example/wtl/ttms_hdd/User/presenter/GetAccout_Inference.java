package com.example.wtl.ttms_hdd.User.presenter;

import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.User.model.UserMessModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 逻辑接口
 * Created by WTL on 2018/6/14.
 */

public interface GetAccout_Inference {

    @GET("/User/QueryUserById/{id}")
    Call<UserMessModel> getUserMess(@Path("id") int id);

    @POST("/User/UpdateUserPassword")
    Call<ResultModel> postPassword(@Body RequestBody body);

}

package com.example.wtl.ttms_hdd.ChangePassword.presenter;

import com.example.wtl.ttms_hdd.ChangePassword.model.userIdModel;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 修改
 * Created by WTL on 2018/6/7.
 */

public interface GetChange_interface {

    @GET("/User/QueryUserByAccount/{account}")
    Call<userIdModel> getUserId(@Path("account") String account);

    @POST("/User/UpdateUserPassword")
    Call<ResultModel> postChangePass(@Body RequestBody body);

}

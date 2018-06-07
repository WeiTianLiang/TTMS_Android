package com.example.wtl.ttms_hdd.Register.presenter;

import com.example.wtl.ttms_hdd.NetTool.ResultModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 注册注解接口
 * Created by WTL on 2018/6/6.
 */

public interface GetRegister_Interface {

    @POST("/User/CreateUser")
    Call<ResultModel> postCreateUser(@Body RequestBody body);

}

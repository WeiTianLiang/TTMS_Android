package com.example.wtl.ttms_hdd.Login.presenter;

import com.example.wtl.ttms_hdd.Login.model.UserIdMOdel;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.Login.model.ValidateModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 登陆注解接口
 * Created by WTL on 2018/6/5.
 */

public interface GetLogin_Interface {

    @GET("/Home/VerCode")
    Call<ValidateModel> getValidate();

    @POST("/User/Login")
    Call<ResultModel> postUser(@Body RequestBody body);

    @GET("/User/QueryUserByAccount/{acc}")
    Call<UserIdMOdel> getUserId(@Path("acc") String acc);

}

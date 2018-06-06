package com.example.wtl.ttms_hdd.Login.presenter;

import com.example.wtl.ttms_hdd.Login.model.LoginResultModel;
import com.example.wtl.ttms_hdd.Login.model.UserModel;
import com.example.wtl.ttms_hdd.Login.model.ValidateModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 注解接口
 * Created by WTL on 2018/6/5.
 */

public interface GetRequest_Interface {

    @GET("/Home/VerCode")
    Call<ValidateModel> getValidate();

    @POST("/User/Login")
    Call<LoginResultModel> postUser(@Body RequestBody body);

}

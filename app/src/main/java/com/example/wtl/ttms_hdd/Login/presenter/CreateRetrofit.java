package com.example.wtl.ttms_hdd.Login.presenter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建retrofit对象并实例化
 * Created by WTL on 2018/6/5.
 */

public class CreateRetrofit {

    public static GetRequest_Interface requestRetrofit() {
        /*
        * 创建Retrofit对象
        * */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://123.206.82.241")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*
        * 实例化
        * */
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);
        return request;
    }

}

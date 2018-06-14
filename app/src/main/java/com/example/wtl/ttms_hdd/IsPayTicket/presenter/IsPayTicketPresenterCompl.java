package com.example.wtl.ttms_hdd.IsPayTicket.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wtl.ttms_hdd.IsPayTicket.model.IsDateModel;
import com.example.wtl.ttms_hdd.IsPayTicket.view.IsPayAdapter;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.Tool.PackageGson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public class IsPayTicketPresenterCompl implements IsPayTicketPresenter {

    private Context context;
    private List<IsDateModel.data> dataList;

    public IsPayTicketPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void setAdapter(final RecyclerView recyclerView) {
        dataList = new ArrayList<>();
        SharedPreferences preferences = context.getSharedPreferences("userId", Context.MODE_PRIVATE);
        String userId = preferences.getString("userId", "");
        Map<Object, Object> map = new HashMap<>();
        map.put("userId", Integer.parseInt(userId));
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        GetIsPay_Interenter request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetIsPay_Interenter.class);
        Call<IsDateModel> call = request.postIsPay(body);
        call.enqueue(new Callback<IsDateModel>() {
            @Override
            public void onResponse(Call<IsDateModel> call, Response<IsDateModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getResult() == 200) {
                        for (IsDateModel.data data : response.body().getData()) {
                            dataList.add(data);
                        }
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                IsPayAdapter adapter = new IsPayAdapter(context, dataList);
                                recyclerView.setAdapter(adapter);
                            }
                        });
                    } else {
                        Log.e("onFailure", response.body().getMsg());
                    }
                } else {
                    Log.e("onFailure", "请求失败");
                }
            }

            @Override
            public void onFailure(Call<IsDateModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
//        call.enqueue(new Callback<IsDateModel>() {
//            @Override
//            public void onResponse(Call<IsDateModel> call, Response<IsDateModel> response) {
//                if(response.isSuccessful()) {
//                    if(response.body()!=null && response.body().getResult()==200) {
//                        for(IsDateModel.data data:response.body().getData()) {
//                            dataList.add(data);
//                        }
//                        ((Activity) context).runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                IsPayAdapter adapter = new IsPayAdapter(context,dataList);
//                                recyclerView.setAdapter(adapter);
//                            }
//                        });
//                    } else {
//                        Log.e("onFailure", response.body().getMsg());
//                    }
//                } else {
//                    Log.e("onFailure", "请求失败");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<IsDateModel> call, Throwable t) {
//                Log.e("onFailure", t.getMessage() + "失败");
//            }
//        });
    }

}

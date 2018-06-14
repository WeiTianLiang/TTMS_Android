package com.example.wtl.ttms_hdd.WaitToPay.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.WaitToPay.model.WaitDateModel;
import com.example.wtl.ttms_hdd.WaitToPay.view.WaitPayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public class WaitToPayPresenterCompl implements IWaitTPayPresenter{

    private Context context;
    private List<WaitDateModel.data> dataList;

    public WaitToPayPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void setAdapter(final RecyclerView recyclerView) {
        dataList = new ArrayList<>();
        SharedPreferences preferences = context.getSharedPreferences("userId",Context.MODE_PRIVATE);
        String userId = preferences.getString("userId","");
        GetWaitPay_Interence request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetWaitPay_Interence.class);
        Call<WaitDateModel> call = request.postWaitDate(Integer.parseInt(userId));
        call.enqueue(new Callback<WaitDateModel>() {
            @Override
            public void onResponse(Call<WaitDateModel> call, Response<WaitDateModel> response) {
                if(response.isSuccessful()) {
                     if(response.body()!=null && response.body().getResult()==200) {
                          for(WaitDateModel.data data:response.body().getData()) {
                              dataList.add(data);
                          }
                         ((Activity) context).runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 WaitPayAdapter adapter = new WaitPayAdapter(context,dataList);
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
            public void onFailure(Call<WaitDateModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }
}

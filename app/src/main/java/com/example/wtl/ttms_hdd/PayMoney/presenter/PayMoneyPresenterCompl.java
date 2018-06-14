package com.example.wtl.ttms_hdd.PayMoney.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.BuyTicket.presenter.GetFilmDetial_Inference;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.PayMoney.presenter.adapter.YouSeatsAdapter;
import com.example.wtl.ttms_hdd.PayMoney.view.dialog.Succdialog;
import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;
import com.example.wtl.ttms_hdd.Tool.FileOperate;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 逻辑
 * Created by WTL on 2018/6/14.
 */

public class PayMoneyPresenterCompl implements IPayMoneyPresenter {

    private Context context;
    private String name;
    private String data;
    private String time;
    private String threateName;
    private List<IsBuyTicketModel> modelList;
    private String money;
    private int sign = 0;

    public PayMoneyPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void getDate(String money, String name, String date, String time, String threateName, List<IsBuyTicketModel> modelList) {
        this.name = name;
        this.data = date;
        this.time = time;
        this.threateName = threateName;
        this.modelList = modelList;
        this.money = money;
    }

    @Override
    public void showDate(TextView paymoney, TextView payname, TextView date, TextView time1, TextView threate, RecyclerView seat) {
        paymoney.setText(money+"元 确认支付");
        payname.setText(name);
        date.setText(data);
        time1.setText(time);
        threate.setText(threateName);
        YouSeatsAdapter adapter = new YouSeatsAdapter(context, modelList);
        seat.setAdapter(adapter);

    }

    @Override
    public void payMoney(List<String> list) {
        SharedPreferences preferences = context.getSharedPreferences("userId",Context.MODE_PRIVATE);
        String userId = preferences.getString("userId","");
        GetPay_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetPay_Inference.class);
        for(String id:list) {
            Call<ResultModel> call = request.postPay(Integer.parseInt(id),Integer.parseInt(userId));
            call.enqueue(new Callback<ResultModel>() {
                @Override
                public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                    if(response.isSuccessful()) {
                         if(response.body() != null && response.body().getResult() == 200) {
                             sign = 1;
                         } else {
                             sign = 0;
                         }
                    } else {
                        Log.e("onFailure", "获取失败！！！");
                    }
                }

                @Override
                public void onFailure(Call<ResultModel> call, Throwable t) {
                    Log.e("onFailure", t.getMessage() + "失败");
                }
            });
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sign == 1) {
                    Succdialog succdialog = new Succdialog(context);
                    Window window = succdialog.getWindow();
                    window.setGravity(Gravity.CENTER);
                    succdialog.show();
                }
            }
        },300);
    }
}

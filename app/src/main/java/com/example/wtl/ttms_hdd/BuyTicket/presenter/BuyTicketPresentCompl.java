package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.model.FilmdetailModel;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 逻辑层处理
 * Created by WTL on 2018/6/6.
 */

public class BuyTicketPresentCompl implements IBuyTicketPresenter {

    private Context context;

    public BuyTicketPresentCompl(Context context) {
        this.context = context;
    }

    @Override
    public void showDetail(String name, final ImageView ticket_img, final TextView buy_name, final TextView buy_type, final TextView buy_durtion, final TextView text_details, final ImageView showback) {
        GetFilmDetial_Inference request = CreateRetrofit.requestRetrofit(null).create(GetFilmDetial_Inference.class);
        Call<FilmdetailModel> call = request.getFilmDetail(name);
        Log.e("阿斯顿发射点发射点", name);
        call.enqueue(new Callback<FilmdetailModel>() {
            @Override
            public void onResponse(Call<FilmdetailModel> call, final Response<FilmdetailModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Glide.with(context)
                                            .load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=178339431,3551923999&fm=27&gp=0.jpg")
                                            .into(ticket_img);
                                    buy_name.setText(response.body().getData().getProgrammeName());
                                    buy_type.setText(response.body().getData().getProgrammeTags());
                                    buy_durtion.setText(String.valueOf(response.body().getData().getProgrammeDruation()));
                                    text_details.setText(response.body().getData().getProgrammeProfile());
                                    Glide.with(context)
                                            .load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=178339431,3551923999&fm=27&gp=0.jpg")
                                            .into(showback);
                                }
                            });
                        } else {
                            Log.e("onFailure", "格式错误或网络问题");
                        }
                    } else {
                        Log.e("onFailure", "数据不存在");
                    }
                } else {
                    Log.e("onFailure", "失败");
                }
            }

            @Override
            public void onFailure(Call<FilmdetailModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }
}

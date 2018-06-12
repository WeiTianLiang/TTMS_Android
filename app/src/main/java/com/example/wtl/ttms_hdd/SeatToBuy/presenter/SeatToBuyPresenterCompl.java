package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.SeatToBuy.model.SeatModel;
import com.example.wtl.ttms_hdd.SeatToBuy.view.SeatView;
import com.example.wtl.ttms_hdd.Tool.FileOperate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 座位逻辑实现类
 * Created by WTL on 2018/6/11.
 */

public class SeatToBuyPresenterCompl implements ISeatToBuyPresenter {

    private Context context;

    public SeatToBuyPresenterCompl(Context context) {
        this.context = context;
    }

    private int seatColNumber = 0;
    private int seatRowNumber = 0;

    @Override
    public void getSeatNumber(final SeatView seats) {
        GetSeat_Intenerface request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetSeat_Intenerface.class);
        Call<SeatModel> call = request.getSeatDate(1);
        call.enqueue(new Callback<SeatModel>() {
            @Override
            public void onResponse(Call<SeatModel> call, Response<SeatModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                int seatId = response.body().getData().get(i).getSeatId();
                                int theaterId = response.body().getData().get(i).getTheaterId();
                                boolean status = response.body().getData().get(i).isStatus();
                                seatRowNumber = response.body().getData().get(i).getSeatRowNumber();
                                seatColNumber = response.body().getData().get(i).getSeatColNumber();
                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seats.setData(seatRowNumber,seatColNumber);
                                    seats.setSeatChecker(new SeatView.SeatChecker() {
                                        @Override
                                        public boolean isValidSeat(int row, int column) {
                                            return true;
                                        }

                                        @Override
                                        public boolean isSold(int row, int column) {
                                            return false;
                                        }

                                        @Override
                                        public void checked(int row, int column) {

                                        }

                                        @Override
                                        public void unCheck(int row, int column) {

                                        }

                                        @Override
                                        public String[] checkedSeatTxt(int row, int column) {
                                            return new String[0];
                                        }
                                    });
                                }
                            });

                        } else {
                            Log.e("onFailure", response.body().getMsg());
                        }
                    } else {
                        Log.e("onFailure", "获取数据为空！！！");
                    }
                } else {
                    Log.e("onFailure", "获取失败！！！");
                }
            }

            @Override
            public void onFailure(Call<SeatModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }
}

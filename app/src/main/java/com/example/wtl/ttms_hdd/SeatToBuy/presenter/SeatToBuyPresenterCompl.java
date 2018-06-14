package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.PayMoney.view.PayMoneyActivity;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.model.GetTicketModel;
import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;
import com.example.wtl.ttms_hdd.SeatToBuy.presenter.adapter.YouTicketAdapter;
import com.example.wtl.ttms_hdd.SeatToBuy.view.dialog.WaitDialog;
import com.example.wtl.ttms_hdd.SeatToBuy.view.drawView.SeatView;
import com.example.wtl.ttms_hdd.Tool.FileOperate;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 初始化行列号
     */
    private int seatColNumber = 0;
    private int seatRowNumber = 0;
    /**
     * 已经售出的行列数
     */
    private List<Integer> rowList = new ArrayList<>();
    private List<Integer> columnList = new ArrayList<>();
    /**
     * 座位表
     */
    private SeatView seats;
    /**
     * 获取选中的座位
     */
    List<IsBuyTicketModel> modelList = new ArrayList<>();
    /**
     * 购买的数量
     */
    private int number = 0;
    /**
     * 显示适配器
     */
    private YouTicketAdapter adapter;

    private Animation up;
    private Animation down;
    /**
    * 标志位
    * */
    private int sign = 0;
    /**
    * 选中的座位
    * */
    private List<GetTicketModel.data> dataList;
    /**
    * 总价
    * */
    private String allMoney;
    /**
    * 要买的票的Id集合
    * */
    private List<String> Idlist = new ArrayList<>();

    @Override
    public void getSeatNumber(int goodId,final SeatView seats, String threaterId, final LinearLayout chooseon, final RecyclerView isbuy, final TextView paymoney, final TextView select_Prompt, final int price) {
        GetSeat_Intenerface request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetSeat_Intenerface.class);
        up = AnimationUtils.loadAnimation(context, R.anim.setting_down);
        down = AnimationUtils.loadAnimation(context, R.anim.setting_up);
        Call<GetTicketModel> call = request.getTicketMessage(goodId);
        this.seats = seats;
        call.enqueue(new Callback<GetTicketModel>() {
            @Override
            public void onResponse(final Call<GetTicketModel> call, Response<GetTicketModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                int status = response.body().getData().get(i).getStatus();
                                seatRowNumber = response.body().getData().get(i).getSeatRowNumber();
                                seatColNumber = response.body().getData().get(i).getSeatColNumber();
                                int ids = response.body().getData().get(i).getId();
                                if (status == 0 || status == 2) {
                                    rowList.add(seatRowNumber - 1);
                                    columnList.add(seatColNumber - 1);
                                }

                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seats.setData(seatRowNumber, seatColNumber);
                                    seats.setSeatChecker(new SeatView.SeatChecker() {
                                        @Override
                                        public boolean isValidSeat(int row, int column) {
                                            return true;
                                        }

                                        @Override
                                        public boolean isSold(int row, int column) {
                                            for (int i = 0; i < rowList.size(); i++) {
                                                if (row == rowList.get(i) && column == columnList.get(i)) {
                                                    return true;
                                                }
                                            }
                                            return false;
                                        }

                                        @Override
                                        public void checked(int row, int column) {
                                            if (number == 0) {
                                                select_Prompt.setVisibility(View.GONE);
                                                select_Prompt.startAnimation(down);
                                                chooseon.setVisibility(View.VISIBLE);
                                                chooseon.startAnimation(up);
                                                String locat = String.valueOf(row + 1) + "排" + String.valueOf(column + 1) + "座";
                                                IsBuyTicketModel model = new IsBuyTicketModel(locat, String.valueOf(price));
                                                modelList.add(model);
                                                adapter = new YouTicketAdapter(context, modelList, seats);
                                                isbuy.setAdapter(adapter);
                                            } else {
                                                String locat = String.valueOf(row + 1) + "排" + String.valueOf(column + 1) + "座";
                                                IsBuyTicketModel model = new IsBuyTicketModel(locat, String.valueOf(price));
                                                adapter.additem(model);
                                            }
                                            number++;
                                            allMoney = String.valueOf(price * number);
                                            paymoney.setText(allMoney + " 确认选座");
                                        }

                                        @Override
                                        public void unCheck(int row, int column) {
                                            number--;
                                            if (number == 0) {
                                                select_Prompt.setVisibility(View.VISIBLE);
                                                select_Prompt.startAnimation(up);
                                                chooseon.setVisibility(View.GONE);
                                                chooseon.startAnimation(down);
                                            }
                                            String locat = String.valueOf(row + 1) + "排" + String.valueOf(column + 1) + "座";
                                            adapter.removeitem(-1, locat);
                                            allMoney = String.valueOf(price * number);
                                            paymoney.setText(allMoney + " 确认选座");
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
            public void onFailure(Call<GetTicketModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void IsCheck(final RecyclerView recyclerView, String goodId, final String name, final String data, final String threatename, final String time) {
        GetSeat_Intenerface request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetSeat_Intenerface.class);
        Call<GetTicketModel> call1 = request.getTicketMessage(Integer.parseInt(goodId));
        call1.enqueue(new Callback<GetTicketModel>() {
            @Override
            public void onResponse(Call<GetTicketModel> call, Response<GetTicketModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            dataList = new ArrayList<>();
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                String name = response.body().getData().get(i).getName();
                                String performance = response.body().getData().get(i).getPerformance();
                                String date = response.body().getData().get(i).getDate();
                                int price = response.body().getData().get(i).getPrice();
                                String theaterName = response.body().getData().get(i).getTheaterName();
                                int seatRowNumber = response.body().getData().get(i).getSeatRowNumber();
                                int seatColNumber = response.body().getData().get(i).getSeatColNumber();
                                int status = response.body().getData().get(i).getStatus();
                                int id = response.body().getData().get(i).getId();
                                GetTicketModel.data data = new GetTicketModel.data(name, performance, date, price, theaterName, seatRowNumber, seatColNumber, status, id);
                                dataList.add(data);
                            }
                            List<IsBuyTicketModel> models = adapter.getDate();
                            for (int i = 0; i < models.size(); i++) {
                                int[] arr = changeStyle(models.get(i).getLocat());
                                for (int j = 0; j < dataList.size(); j++) {
                                    final int jj = j;
                                    if (dataList.get(j).getSeatRowNumber() == arr[0] && dataList.get(j).getSeatColNumber() == arr[1] && dataList.get(j).getStatus() == 1) {
                                        SharedPreferences preferences = context.getSharedPreferences("userId", Context.MODE_PRIVATE);
                                        String userId = preferences.getString("userId","");
                                        GetSeat_Intenerface request1 = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetSeat_Intenerface.class);
                                        Call<ResultModel> call1 = request1.postTicket(dataList.get(j).getId(),Integer.parseInt(userId));
                                        call1.enqueue(new Callback<ResultModel>() {
                                            @Override
                                            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                                                if(response.isSuccessful()) {
                                                    if(response.body().getResult() == 200) {
                                                        Idlist.add(dataList.get(jj).getId()+"");
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
                                    } else if(dataList.get(j).getSeatRowNumber() == arr[0] && dataList.get(j).getSeatColNumber() == arr[1]
                                            && (dataList.get(j).getStatus() == 0 || dataList.get(j).getStatus() == 2)) {
                                        sign = 0;
                                    }
                                }
                            }
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
            public void onFailure(Call<GetTicketModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
        final WaitDialog dialog = new WaitDialog(context);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sign == 1) {
                    Intent intent = new Intent(context, PayMoneyActivity.class);
                    intent.putStringArrayListExtra("TicketId", (ArrayList<String>) Idlist);
                    intent.putParcelableArrayListExtra("seatslist", (ArrayList<? extends Parcelable>) modelList);
                    intent.putExtra("date",data);
                    intent.putExtra("name",name);
                    intent.putExtra("threatename",threatename);
                    intent.putExtra("time",time);
                    intent.putExtra("money",allMoney);
                    context.startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
                    dialog.dismiss();
                } else {
                    Toast.makeText(context,"订票失败,亲！可能已经被预定了",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        },2000);
    }

    private int[] changeStyle(String locat) {
        int[] arr = new int[2];
        String[] a1 = locat.split("排");
        int a = Integer.parseInt(a1[0]);
        String[] b1 = a1[1].split("座");
        int b = Integer.parseInt(b1[0]);
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
}

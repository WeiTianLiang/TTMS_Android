package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.model.DataPlanModel;
import com.example.wtl.ttms_hdd.BuyTicket.model.FilmdetailModel;
import com.example.wtl.ttms_hdd.BuyTicket.model.PlanAll;
import com.example.wtl.ttms_hdd.BuyTicket.model.PlanModel;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter.Data_showAdapter;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter.Show_PlanAdapter;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.view.ShowBuySiteActivity;
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
 * 逻辑层处理
 * Created by WTL on 2018/6/6.
 */

public class BuyTicketPresentCompl implements IBuyTicketPresenter {

    private Context context;

    public BuyTicketPresentCompl(Context context) {
        this.context = context;
    }

    private Map<String, List<PlanModel>> planModeMap1 = new ArrayMap<>();

    private Show_PlanAdapter planadapter;

    private List<String> models1;

    private List<PlanAll> planAlls = new ArrayList<>();

    private GetFilmDetial_Inference request;

    private String time;

    private String name;

    @Override
    public void showDetail(String name, final ImageView ticket_img, final TextView buy_name, final TextView buy_type, final TextView buy_durtion, final TextView text_details, final ImageView showback) {
        this.name = name;
        request = CreateRetrofit.requestRetrofit(null).create(GetFilmDetial_Inference.class);
        Call<FilmdetailModel> call = request.getFilmDetail(name);
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
                    Log.e("onFailure", "请求不成功");
                }
            }

            @Override
            public void onFailure(Call<FilmdetailModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void showPlanText(final RecyclerView planDate, final RecyclerView showPlan, int Id, String time) {
        this.time = time;
        Map<Object, Object> map = new HashMap<>();
        map.put("programmeId", Id);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        request = CreateRetrofit.requestRetrofit(null).create(GetFilmDetial_Inference.class);
        Call<DataPlanModel> call = request.getDataPlan(body);
        call.enqueue(new Callback<DataPlanModel>() {
            @Override
            public void onResponse(Call<DataPlanModel> call, Response<DataPlanModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        models1 = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            String performance = response.body().getData().get(i).getPerformance();
                            int price = response.body().getData().get(i).getPrice();
                            String playDate = response.body().getData().get(i).getPlayDate();
                            String theaterName = response.body().getData().get(i).getTheaterName();

                            models1.add(getDate(playDate));
                            PlanAll planAll = new PlanAll(getDate(playDate), changetime(performance, 0), changetime(performance, 1),
                                    theaterName, String.valueOf(price));
                            planAlls.add(planAll);
                        }
                        for (int i = 0; i < models1.size(); i++) {
                            List<PlanModel> planModels1 = new ArrayList<>();
                            for (int j = 0; j < planAlls.size(); j++) {
                                if (models1.get(i).equals(planAlls.get(j).getDate())) {
                                    PlanModel model = new PlanModel(planAlls.get(j).getStart_time(), planAlls.get(j).getEnd_time()
                                            , planAlls.get(j).getThreat_name(), planAlls.get(j).getTicket_price());
                                    planModels1.add(model);
                                }
                            }
                            planModeMap1.put(models1.get(i), planModels1);
                        }

                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                final Data_showAdapter adapter = new Data_showAdapter(context, models1);
                                planDate.setAdapter(adapter);
                                adapter.setOnChangePlanData(new Data_showAdapter.OnChangePlanData() {
                                    @Override
                                    public void ChangePlanData(String date) {
                                        planadapter.changeData(planModeMap1.get(date));
                                    }
                                });

                                planadapter = new Show_PlanAdapter(context, planModeMap1.get(models1.get(0)));
                                showPlan.setAdapter(planadapter);
                                planadapter.setOnToNextActivity(new Show_PlanAdapter.OnToNextActivity() {
                                    @Override
                                    public void toNextActivity(int position, String threat_name) {
                                        Intent intent = new Intent(context, ShowBuySiteActivity.class);
                                        intent.putExtra("name", name);
                                        intent.putExtra("startime", planModeMap1.get(models1.get(0)).get(position).getStart_time());
                                        intent.putExtra("date", adapter.getNowDate());
                                        intent.putExtra("threat_name", threat_name);
                                        context.startActivity(intent);
                                        ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
                                    }
                                });
                            }
                        });
                    } else {
                        Log.e("onFailure", "请求数据为空！！！");
                    }
                } else {
                    Log.e("onFailure", "请求不成功！！！");
                }
            }

            @Override
            public void onFailure(Call<DataPlanModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    /**
     * 改变日期格式
     */
    private String getDate(String date) {
        String[] dates = date.split("T");
        String[] times = dates[0].split("-");
        String d = times[1] + "月" + times[2] + "日";
        return d;
    }

    private String changetime(String changetime, int c) {
        switch (changetime) {
            case "早一":
                if (c == 0) {
                    return "06:30";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("06:30", h, m);
                }
            case "早二":
                if (c == 0) {
                    return "09:30";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("09:30", h, m);
                }
            case "午一":
                if (c == 0) {
                    return "13:00";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("13:30", h, m);
                }
            case "午二":
                if (c == 0) {
                    return "16:00";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("16:30", h, m);
                }
            case "晚一":
                if (c == 0) {
                    return "19:00";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("19:30", h, m);
                }
            case "晚二":
                if (c == 0) {
                    return "22:00";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("22:30", h, m);
                }
            case "午夜":
                if (c == 0) {
                    return "01:00";
                } else {
                    int h = Integer.parseInt(time) / 60;
                    int m = Integer.parseInt(time) - h * 60;
                    return addtime("01:30", h, m);
                }
            default:
                break;
        }
        return "wrong";
    }

    private String addtime(String t, int h, int m) {
        String[] ts = t.split(":");
        int t1 = Integer.parseInt(ts[0]);
        int t2 = Integer.parseInt(ts[1]);
        h = h + t1;
        m = m + t2;
        String h1;
        String m1;
        if (h < 10) {
            h1 = "0" + String.valueOf(h);
        } else {
            h1 = String.valueOf(h);
        }
        if (m < 10) {
            m1 = "0" + String.valueOf(m);
        } else {
            m1 = String.valueOf(m);
        }
        return h1 + ":" + m1 + "散场";
    }
}

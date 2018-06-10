package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.model.DataModel;
import com.example.wtl.ttms_hdd.BuyTicket.model.FilmdetailModel;
import com.example.wtl.ttms_hdd.BuyTicket.model.PlanModel;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter.Data_showAdapter;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter.Show_PlanAdapter;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<PlanModel> planModelList = new ArrayList<>();
    private List<PlanModel> planModelList1 = new ArrayList<>();
    private List<PlanModel> planModelList2 = new ArrayList<>();
    private List<PlanModel> planModelList3 = new ArrayList<>();
    private List<PlanModel> planModelList4 = new ArrayList<>();

    private Map<String,List<PlanModel>> planModeMap = new ArrayMap<>();

    private Show_PlanAdapter planadapter;

    private List<DataModel> models;

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

    @Override
    public void showDataText(RecyclerView recyclerView) {
        models = new ArrayList<>();
        DataModel model = new DataModel("9月23日");
        DataModel model1 = new DataModel("9月24日");
        DataModel model2 = new DataModel("9月25日");
        DataModel model3 = new DataModel("9月26日");
        DataModel model4 = new DataModel("9月27日");
        models.add(model);
        models.add(model1);
        models.add(model2);
        models.add(model3);
        models.add(model4);
        Data_showAdapter adapter = new Data_showAdapter(context,models);
        recyclerView.setAdapter(adapter);
        adapter.setOnChangePlanData(new Data_showAdapter.OnChangePlanData() {
            @Override
            public void ChangePlanData() {

            }
        });
    }

    @Override
    public void showPlanText(RecyclerView recyclerView) {
        dataa(models);
        for(int i = 0 ; i < models.size() ; i++) {
            planModeMap.put(models.get(i).getData(),planModelList);
        }
        planadapter = new Show_PlanAdapter(context,planModelList);
        recyclerView.setAdapter(planadapter);
    }

    private void dataa(List<DataModel> models) {
        PlanModel model = new PlanModel("09:45","11:26散场","你懂得厅","100元");
        PlanModel model1 = new PlanModel("11:45","13:26散场","擦拭的厅","10元");
        PlanModel model2 = new PlanModel("14:45","16:26散场","为人体厅","90元");
        PlanModel model3 = new PlanModel("18:45","24:26散场","的风格和厅","290元");
        PlanModel model4 = new PlanModel("19:45","12:26散场","撒旦厅","190元");

        planModelList.add(model);
        planModelList.add(model);
        planModelList.add(model);
        planModelList.add(model);
        planModelList.add(model);
        planModelList.add(model);
        planModelList.add(model);

        planModelList1.add(model1);
        planModelList1.add(model1);
        planModelList1.add(model1);
        planModelList1.add(model1);

        planModelList2.add(model2);
        planModelList2.add(model2);
        planModelList2.add(model2);
        planModelList2.add(model2);
        planModelList2.add(model2);

        planModelList3.add(model3);
        planModelList3.add(model3);
        planModelList3.add(model3);
        planModelList3.add(model3);
        planModelList3.add(model3);

        planModelList4.add(model4);
        planModelList4.add(model4);
        planModelList4.add(model4);
        planModelList4.add(model4);
        planModelList4.add(model4);
        planModelList4.add(model4);

        List<List<PlanModel>> lists = new ArrayList<>();
        lists.add(planModelList);
        lists.add(planModelList1);
        lists.add(planModelList2);
        lists.add(planModelList3);
        lists.add(planModelList4);

        for(int i = 0 ; i < models.size() ; i++) {
            planModeMap.put(models.get(i).getData(),lists.get(i));
        }
    }
}

package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 逻辑层接口
 * Created by WTL on 2018/6/6.
 */

public interface IBuyTicketPresenter {

    /**
    * 展示详情
    * */
    void showDetail(String image,String name,
                    TextView buy_name,TextView buy_type,
                    TextView buy_durtion,TextView text_details);
    /**
    * 展示计划
    * */
    void showPlanText(RecyclerView planDate,RecyclerView showPlan,int Id,String time);
}

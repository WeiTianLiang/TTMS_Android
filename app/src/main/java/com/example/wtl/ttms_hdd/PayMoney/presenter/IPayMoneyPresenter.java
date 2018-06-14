package com.example.wtl.ttms_hdd.PayMoney.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;

import java.util.List;

/**
 * 逻辑接口
 * Created by WTL on 2018/6/14.
 */

public interface IPayMoneyPresenter {
    /**
     * 获取数据
     */
    void getDate(String money, String name, String date, String time, String threateName, List<IsBuyTicketModel> modelList);

    /**
     * 显示数据
     */
    void showDate(TextView paymoney, TextView payname, TextView date, TextView time, TextView threate, RecyclerView seat);

    /**
     * 付款
     */
    void payMoney(List<String> stringList);

}

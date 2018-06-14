package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.SeatToBuy.view.drawView.SeatView;

/**
 * 座位逻辑接口
 * Created by WTL on 2018/6/11.
 */

public interface ISeatToBuyPresenter {

    /**
     * 绘制座位
     */
    void getSeatNumber(int goodId,SeatView seats, String threaterId, LinearLayout layout,
                       RecyclerView recyclerView, TextView textView, TextView select_Prompt, int price);

    /**
    * 确认选中
    * */
    void IsCheck(RecyclerView recyclerView,String goodId,String name,String data,String threatename,String time);

}

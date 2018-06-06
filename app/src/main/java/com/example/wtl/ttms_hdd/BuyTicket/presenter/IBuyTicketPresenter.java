package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * 逻辑层接口
 * Created by WTL on 2018/6/6.
 */

public interface IBuyTicketPresenter {

    /**
    * 返回接口
    * */
    void doback();
    /**
    * 展示详情
    * */
    void showDetail(ImageView image,TextView text);

}

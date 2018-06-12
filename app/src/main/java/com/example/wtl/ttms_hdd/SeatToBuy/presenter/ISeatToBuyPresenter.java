package com.example.wtl.ttms_hdd.SeatToBuy.presenter;

import com.example.wtl.ttms_hdd.SeatToBuy.view.SeatView;

/**
 * 座位逻辑接口
 * Created by WTL on 2018/6/11.
 */

public interface ISeatToBuyPresenter {

    /**
    * 绘制座位
    * */
    void getSeatNumber(SeatView seats,String threaterId);

}

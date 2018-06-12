package com.example.wtl.ttms_hdd.SeatToBuy.model;

/**
 * 已经选中的票的信息
 * Created by WTL on 2018/6/12.
 */

public class IsBuyTicketModel {

    private String locat;
    private String price;

    public IsBuyTicketModel(String locat,String price) {
        this.locat = locat;
        this.price = price;
    }

    public String getLocat() {
        return locat;
    }

    public String getPrice() {
        return price;
    }
}

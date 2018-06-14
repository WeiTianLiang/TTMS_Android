package com.example.wtl.ttms_hdd.WaitToPay.model;

import java.util.List;

/**
 * 等待数据
 * Created by WTL on 2018/6/14.
 */

public class WaitDateModel {

    private int result;
    private String msg;
    private List<data> data;

    public class data {
        private String date;
        private String name;
        private String theaterName;
        private int price;
        private int seatRowNumber;
        private int seatColNumber;

        public String getTheaterName() {
            return theaterName;
        }

        public int getPrice() {
            return price;
        }

        public int getSeatColNumber() {
            return seatColNumber;
        }

        public int getSeatRowNumber() {
            return seatRowNumber;
        }

        public String getDate() {
            return date;
        }

        public String getName() {
            return name;
        }
    }

    public List<WaitDateModel.data> getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }
}

package com.example.wtl.ttms_hdd.SeatToBuy.model;

import java.util.List;

/**
 * 获取票信息
 * Created by WTL on 2018/6/13.
 */

public class GetTicketModel {

    private int result;
    private String msg;
    private List<data> data;

    public class data {
        private String name;
        private String performance;
        private String data;
        private int price;
        private String theaterName;
        private int seatRowNumber;
        private int seatColNumber;
        private int status;
        private int id;

        public int getId() {
            return id;
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

        public int getStatus() {
            return status;
        }

        public String getData() {
            return data;
        }

        public String getName() {
            return name;
        }

        public String getPerformance() {
            return performance;
        }

        public String getTheaterName() {
            return theaterName;
        }
    }

    public int getResult() {
        return result;
    }

    public List<GetTicketModel.data> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

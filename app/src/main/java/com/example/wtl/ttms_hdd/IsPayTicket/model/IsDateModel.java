package com.example.wtl.ttms_hdd.IsPayTicket.model;

import java.util.List;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public class IsDateModel {

    private int result;
    private String msg;
    private List<IsDateModel.data> data;

    public class data {
        private String dateTime;
        private String programmeName;
        private String theaterName;
        private int price;
        private int rowNumber;
        private int colNumber;

        public String getProgrammeName() {
            return programmeName;
        }

        public String getDateTime() {
            return dateTime;
        }

        public int getRowNumber() {
            return rowNumber;
        }

        public int getColNumber() {
            return colNumber;
        }

        public int getPrice() {
            return price;
        }

        public String getTheaterName() {
            return theaterName;
        }
    }

    public List<IsDateModel.data> getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

}

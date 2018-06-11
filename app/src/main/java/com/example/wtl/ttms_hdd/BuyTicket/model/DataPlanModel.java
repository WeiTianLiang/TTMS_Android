package com.example.wtl.ttms_hdd.BuyTicket.model;

import java.util.List;

/**
 * 计划数据
 * Created by WTL on 2018/6/11.
 */

public class DataPlanModel {

    private int result;
    private String msg;

    private List<Data> data;

    public class Data {
        private int goodId;//商品id
        private int programmeId;//影片id
        private int theaterId;//影厅名称
        private String performance;//场次
        private String  playDate;//上映日期
        private int price;//价钱
        private String theaterName;//放映厅名称

        public int getGoodId() {
            return goodId;
        }

        public int getPrice() {
            return price;
        }

        public int getProgrammeId() {
            return programmeId;
        }

        public int getTheaterId() {
            return theaterId;
        }

        public String getPerformance() {
            return performance;
        }

        public String getPlayDate() {
            return playDate;
        }

        public String getTheaterName() {
            return theaterName;
        }
    }

    public int getResult() {
        return result;
    }

    public List<Data> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

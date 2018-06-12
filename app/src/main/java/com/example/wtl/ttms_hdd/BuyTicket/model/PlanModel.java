package com.example.wtl.ttms_hdd.BuyTicket.model;

/**
 * 演出计划数据
 * Created by WTL on 2018/6/10.
 */

public class PlanModel {

    private String start_time;
    private String end_time;
    private String threat_name;
    private String ticket_price;
    private int threater_Id;
    private int good_Id;

    public PlanModel(int good_Id, int threater_Id, String start_time, String end_time, String threat_name, String ticket_price) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.threat_name = threat_name;
        this.ticket_price = ticket_price;
        this.threater_Id = threater_Id;
        this.good_Id = good_Id;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getThreat_name() {
        return threat_name;
    }

    public String getTicket_price() {
        return ticket_price;
    }

    public int getGood_Id() {
        return good_Id;
    }

    public int getThreater_Id() {
        return threater_Id;
    }
}

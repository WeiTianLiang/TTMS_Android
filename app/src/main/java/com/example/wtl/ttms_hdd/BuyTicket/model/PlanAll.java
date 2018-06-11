package com.example.wtl.ttms_hdd.BuyTicket.model;

/**
 *
 * Created by WTL on 2018/6/11.
 */

public class PlanAll {

    private String date;
    private String start_time;
    private String end_time;
    private String threat_name;
    private String ticket_price;

    public PlanAll(String date,String start_time,String end_time,String threat_name,String ticket_price) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.threat_name = threat_name;
        this.ticket_price = ticket_price;
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

    public String getDate() {
        return date;
    }
}

package com.example.wtl.ttms_hdd.ChangePassword.model;

/**
 * 部分用户信息
 * Created by WTL on 2018/6/7.
 */

public class userIdModel {

    private int result;

    private String msg;

    private data data;

    public class data {
        int userId;

        public int getUserId() {
            return userId;
        }
    }

    public String getMsg() {
        return msg;
    }

    public int getResult() {
        return result;
    }

    public userIdModel.data getData() {
        return data;
    }
}

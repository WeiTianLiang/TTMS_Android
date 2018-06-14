package com.example.wtl.ttms_hdd.Login.model;

/**
 * 获取用户Id
 * Created by WTL on 2018/6/14.
 */

public class UserIdMOdel{

    private int result;

    private data data;

    public class data {
        private int userId;

        public int getUserId() {
            return userId;
        }
    }

    public UserIdMOdel.data getData() {
        return data;
    }

    public int getResult() {
        return result;
    }
}

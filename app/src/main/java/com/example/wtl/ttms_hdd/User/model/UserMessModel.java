package com.example.wtl.ttms_hdd.User.model;

/**
 * 用户信息数据
 * Created by WTL on 2018/6/14.
 */

public class UserMessModel {

    private int result;
    private String msg;
    private data data;

    public class data {
        private String userName;
        private String userAccount;
        private String userSex;
        private String userTel;
        private String userLastSignInTime;
        private String userPassword;

        public String getUserAccount() {
            return userAccount;
        }

        public String getUserLastSignInTime() {
            return userLastSignInTime;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserSex() {
            return userSex;
        }

        public String getUserTel() {
            return userTel;
        }

        public String getUserPassword() {
            return userPassword;
        }
    }

    public int getResult() {
        return result;
    }

    public UserMessModel.data getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

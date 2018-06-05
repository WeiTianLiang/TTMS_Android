package com.example.wtl.ttms_hdd.Login.model;

/**
 * 用户登陆类
 * 接口功能实现
 * Created by WTL on 2018/6/4.
 */

public class UserModel implements IUser{

    private String account;
    private String password;
    private String verCode;

    public UserModel(String account,String password,String verCode) {
        this.account = account;
        this.password = password;
        this.verCode = verCode;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getVerCode() {
        return verCode;
    }
}

package com.example.wtl.ttms_hdd.ChangePassword.presenter;

/**
 * 找回密码逻辑层接口
 * Created by WTL on 2018/6/7.
 */

public interface IChangePassPresenter {

    /**
     * 修改接口，执行修改逻辑
     */
    void doChange(String account, String password, String re_password);

}

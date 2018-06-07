package com.example.wtl.ttms_hdd.Register.presenter;

/**
 * 注册业务逻辑功能接口
 * Created by WTL on 2018/6/4.
 */

public interface IRegisterPresenter {
    /**
     * 返回接口
     * */
    void doBack();
    /**
    * 注册执行接口
    * */
    void doRegister(String name,String account,String password,String re_password,String sex,String tel);
}

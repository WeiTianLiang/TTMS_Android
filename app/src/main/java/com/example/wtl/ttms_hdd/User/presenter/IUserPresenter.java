package com.example.wtl.ttms_hdd.User.presenter;

import android.widget.TextView;

/**
 * 逻辑接口
 * Created by WTL on 2018/6/14.
 */

public interface IUserPresenter {

    /**
    * 退出登陆
    * */
    void outLogin();
    /**
    * 获取用户信息
    * */
    void getUserMessage(TextView name);
    /**
    * 更改密码
    * */
    void changePassword();

}

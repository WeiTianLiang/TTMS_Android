package com.example.wtl.ttms_hdd.Login.presenter;

import android.widget.EditText;
import android.widget.ImageView;

/**
 * 登陆业务逻辑功能接口
 * Created by WTL on 2018/6/4.
 */

public interface ILoginPresenter {

    /**
     * 处理登陆接口
     */
    void doLogin(String account,String password,String verCode);
    /**
     * 处理注册接口
     */
    void doRegister();
    /**
     * 登陆清空
     */
    void clear(EditText edit);
    /**
    * 清空某行的文字
    * */
    void addTextEdit(EditText edit, ImageView delete);
    /**
     * 展示验证码
     * */
    void showValidate(ImageView image);

}

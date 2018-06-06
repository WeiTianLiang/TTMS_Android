package com.example.wtl.ttms_hdd.Register.presenter;

import android.widget.EditText;
import android.widget.ImageView;

/**
 * 注册业务逻辑功能接口
 * Created by WTL on 2018/6/4.
 */

public interface IRegisterPresenter {
    /**
     * 注册清空
     */
    void registerClear(EditText edit);
    /**
     * 清空某行的文字
     * */
    void registerAddTextEdit(EditText edit, ImageView delete);
    /**
     * 返回接口
     * */
    void doBack();
    /**
    * 注册执行接口
    * */
    void doRegister(String name,String account,String password,String sex,String tel);
}

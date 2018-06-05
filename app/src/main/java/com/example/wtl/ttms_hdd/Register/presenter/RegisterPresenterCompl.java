package com.example.wtl.ttms_hdd.Register.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wtl.ttms_hdd.R;

/**
 * 注册业务逻辑
 * 接口功能实现
 * Created by WTL on 2018/6/4.
 */

public class RegisterPresenterCompl implements IRegisterPresenter {

    private Context context;

    public RegisterPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void registerClear(EditText edit) {
        edit.setText("");
    }

    @Override
    public void registerAddTextEdit(final EditText edit, final ImageView delete) {
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*
                * 不为空时显示清除
                * */
                if(!edit.getText().toString().equals("")) {
                    delete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*
                * 为空时不显示清除
                * */
                if(edit.getText().toString().equals("")) {
                    delete.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void doBack() {
        ((Activity)context).finish();
        ((Activity)context).overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
    }

    @Override
    public void doRegister() {
        /*
        * 执行注册的动作
        * */
    }
}

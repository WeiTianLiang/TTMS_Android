package com.example.wtl.ttms_hdd.Tool;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * 清空某行数据
 * Created by WTL on 2018/6/7.
 */

public class ClearEditText {

    public static void clear(EditText editText) {
        editText.setText("");
    }

    public static void clearEditText(final EditText edit, final ImageView delete) {
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*
                * 不为空时显示清除
                * */
                if (!edit.getText().toString().equals("")) {
                    delete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*
                * 为空时不显示清除
                * */
                if (edit.getText().toString().equals("")) {
                    delete.setVisibility(View.GONE);
                }
            }
        });
    }

}

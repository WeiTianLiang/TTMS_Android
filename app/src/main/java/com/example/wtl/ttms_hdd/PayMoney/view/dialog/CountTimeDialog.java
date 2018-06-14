package com.example.wtl.ttms_hdd.PayMoney.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;

/**
 * 倒计时弹出框
 * Created by WTL on 2018/6/14.
 */

public class CountTimeDialog extends Dialog {

    private TextView counttime;
    private OnSureClick sureClick;

    public CountTimeDialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counttimerdialog);

        counttime = (TextView) findViewById(R.id.counttime);
        counttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sureClick.sureClick();
            }
        });
    }

    public interface OnSureClick {
        void sureClick();
    }

    public void setOnSureClick(OnSureClick sureClick) {
        this.sureClick = sureClick;
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        sureClick.sureClick();
        return super.onKeyDown(keyCode, event);
    }
}

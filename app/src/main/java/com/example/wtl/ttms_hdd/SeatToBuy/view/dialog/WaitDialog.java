package com.example.wtl.ttms_hdd.SeatToBuy.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.wtl.ttms_hdd.R;

/**
 * 等待进入支付进度条
 * Created by WTL on 2018/6/14.
 */

public class WaitDialog extends Dialog {

    public WaitDialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waitdialog);
    }
}

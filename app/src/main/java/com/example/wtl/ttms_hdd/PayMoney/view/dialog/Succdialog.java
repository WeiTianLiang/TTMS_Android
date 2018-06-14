package com.example.wtl.ttms_hdd.PayMoney.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.wtl.ttms_hdd.R;

/**
 * 购买成功
 * Created by WTL on 2018/6/14.
 */

public class Succdialog extends Dialog {

    public Succdialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyidokdialog);
    }
}

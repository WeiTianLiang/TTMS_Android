package com.example.wtl.ttms_hdd.BuyTicket.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;

/**
 * 逻辑层处理
 * Created by WTL on 2018/6/6.
 */

public class BuyTicketPresentCompl implements IBuyTicketPresenter {

    private Context context;

    public BuyTicketPresentCompl(Context context) {
        this.context = context;
    }

    @Override
    public void doback() {
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
    }

    @Override
    public void showDetail(ImageView image, TextView text) {
        if(image.getDrawable().getCurrent().getConstantState().
                equals(context.getResources().getDrawable(R.mipmap.down).getConstantState())) {
            image.setImageResource(R.mipmap.up);
            text.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.mipmap.down);
            text.setVisibility(View.GONE);
        }
    }
}

package com.example.wtl.ttms_hdd.User.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.IsPayTicket.view.IsPayTicketActivity;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.User.presenter.IUserPresenter;
import com.example.wtl.ttms_hdd.User.presenter.UserPresenterCompl;
import com.example.wtl.ttms_hdd.WaitToPay.view.WaitPayActivity;


/**
 * 个人中心
 * Created by WTL on 2018/6/14.
 */

public class User_Fragment extends Fragment implements View.OnClickListener {

    private TextView user_name;
    private RelativeLayout willpay;
    private RelativeLayout ispay;
    private RelativeLayout changepass;
    private RelativeLayout outLogin;

    private IUserPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentuser,container,false);
        if(presenter == null) {
            presenter = new UserPresenterCompl(getContext());
        }
        Montior(view);
        presenter.getUserMessage(user_name);
        return view;
    }

    private void Montior(View view) {
        user_name = view.findViewById(R.id.user_name);
        willpay = view.findViewById(R.id.willpay);
        ispay = view.findViewById(R.id.ispay);
        changepass = view.findViewById(R.id.changepass);
        outLogin = view.findViewById(R.id.outLogin);

        willpay.setOnClickListener(this);
        ispay.setOnClickListener(this);
        changepass.setOnClickListener(this);
        outLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.willpay:
                Intent intent = new Intent(getContext(), WaitPayActivity.class);
                getContext().startActivity(intent);
                ((Activity) getContext()).overridePendingTransition(R.anim.activity_left_in,R.anim.activity_left_out);
                break;
            case R.id.ispay:
                Intent intent1 = new Intent(getContext(), IsPayTicketActivity.class);
                getContext().startActivity(intent1);
                ((Activity) getContext()).overridePendingTransition(R.anim.activity_left_in,R.anim.activity_left_out);
                break;
            case R.id.changepass:
                if(presenter == null) {
                    presenter = new UserPresenterCompl(getContext());
                }
                presenter.changePassword();
                break;
            case R.id.outLogin:
                if(presenter == null) {
                    presenter = new UserPresenterCompl(getContext());
                }
                presenter.outLogin();
                break;
        }
    }
}

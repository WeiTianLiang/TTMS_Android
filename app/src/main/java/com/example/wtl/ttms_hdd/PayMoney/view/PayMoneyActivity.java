package com.example.wtl.ttms_hdd.PayMoney.view;

import android.icu.text.SimpleDateFormat;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.PayMoney.presenter.IPayMoneyPresenter;
import com.example.wtl.ttms_hdd.PayMoney.presenter.PayMoneyPresenterCompl;
import com.example.wtl.ttms_hdd.PayMoney.view.dialog.CountTimeDialog;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PayMoneyActivity extends AppCompatActivity {

    private String name;
    private String threatename;
    private String startime;
    private String data;
    private List<IsBuyTicketModel> dataList = new ArrayList<>();
    private String money;
    private List<String> list = new ArrayList<>();

    private ImageView payback;
    private TextView payname;
    private TextView date;
    private TextView time;
    private TextView threate;
    private RecyclerView seat;
    private TextView paymoney;
    private TextView lastimer;

    private IPayMoneyPresenter presenter;
    private String s = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_money);
        timer.start();
        name = getIntent().getStringExtra("name");
        threatename = getIntent().getStringExtra("threatename");
        startime = getIntent().getStringExtra("time");
        data = getIntent().getStringExtra("date");
        dataList = getIntent().getParcelableArrayListExtra("seatslist");
        money = getIntent().getStringExtra("money");
        list = getIntent().getStringArrayListExtra("TicketId");
        Montior();
        if(presenter == null) {
            presenter = new PayMoneyPresenterCompl(this);
        }
        presenter.getDate(money,name,data,startime,threatename,dataList);
        presenter.showDate(paymoney,payname,date,time,threate,seat);
        payback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
            }
        });
        paymoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter == null) {
                    presenter = new PayMoneyPresenterCompl(PayMoneyActivity.this);
                }
                presenter.payMoney(list);
            }
        });
    }

    private void Montior() {
        lastimer = (TextView) findViewById(R.id.lastimer);
        paymoney = (TextView) findViewById(R.id.paymoney1);
        payback = (ImageView) findViewById(R.id.payback);
        payname = (TextView) findViewById(R.id.payname);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        threate = (TextView) findViewById(R.id.threate);
        seat = (RecyclerView) findViewById(R.id.seat);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        seat.setLayoutManager(manager);

    }

    final CountDownTimer timer = new CountDownTimer(4500000,1000) {
        @Override
        public void onTick(long l) {
            long time = l-1000;
            if(time>=0) {
                lastimer.setText(changeTime(time));
            }
        }

        @Override
        public void onFinish() {
            CountTimeDialog dialog = new CountTimeDialog(PayMoneyActivity.this);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            window.setGravity(Gravity.CENTER);
            dialog.show();
            dialog.setOnSureClick(new CountTimeDialog.OnSureClick() {
                @Override
                public void sureClick() {
                    finish();
                    overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                }
            });
        }
    };

    private String changeTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        Date date = new Date(time);
        s = format.format(date);
        return s;
    }
}

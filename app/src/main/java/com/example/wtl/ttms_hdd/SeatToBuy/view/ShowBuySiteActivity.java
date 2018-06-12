package com.example.wtl.ttms_hdd.SeatToBuy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.presenter.ISeatToBuyPresenter;
import com.example.wtl.ttms_hdd.SeatToBuy.presenter.SeatToBuyPresenterCompl;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;

public class ShowBuySiteActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView siteback;
    private TextView ticketname;
    private TextView ticketdate;
    private TextView ticketime;
    private TextView sitename;
    private SeatView seats;
    /**
    * 逻辑层接口初始化
    * */
    private ISeatToBuyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_buy_site);
        HideScreenTop.HideScreenTop(getWindow());
        String name = getIntent().getStringExtra("name");
        String startime = getIntent().getStringExtra("startime");
        String date = getIntent().getStringExtra("date");
        String threatname = getIntent().getStringExtra("threat_name");
        Montior();
        ticketname.setText(name);
        ticketdate.setText(date);
        ticketime.setText(startime);
        sitename.setText(threatname);
        if(presenter == null) {
            presenter = new SeatToBuyPresenterCompl(this);
        }
        presenter.getSeatNumber(seats);
    }

    private void Montior() {
        siteback = (ImageView) findViewById(R.id.siteback);
        ticketname = (TextView) findViewById(R.id.ticketname);
        ticketdate = (TextView) findViewById(R.id.ticketdate);
        ticketime = (TextView) findViewById(R.id.ticketime);
        sitename = (TextView) findViewById(R.id.sitename);
        seats = (SeatView) findViewById(R.id.seats);
        seats.setScreenName("李佳伟屁股大");
        seats.setMaxSelected(5);

        siteback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.siteback:
                finish();
                overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
        return super.onKeyDown(keyCode, event);
    }
}

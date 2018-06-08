package com.example.wtl.ttms_hdd.BuyTicket.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.BuyTicketPresentCompl;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.IBuyTicketPresenter;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * 返回
     * */
    private ImageView buyback;
    /**
     * 展示海报
     * */
    private ImageView ticket_img;
    /**
     * 电影名
     * */
    private TextView buy_name;
    /**
     * 类型
     * */
    private TextView buy_type;
    /**
     * 时长
     * */
    private TextView buy_durtion;
    /**
    * 初始化接口
    * */
    private IBuyTicketPresenter presenter = null;
    /**
    * 购票跳转
    * */
    private TextView tobuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        HideScreenTop.HideScreenTop(getWindow());
        if(presenter == null) {
            presenter = new BuyTicketPresentCompl(this);
        }
        Montior();
    }

    private void Montior() {
        ticket_img = findViewById(R.id.ticket_img);
        Glide.with(this)
                .load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=178339431,3551923999&fm=27&gp=0.jpg")
                .into(ticket_img);
        buy_name = findViewById(R.id.buy_name);
        buy_type = findViewById(R.id.buy_type);
        buy_durtion = findViewById(R.id.buy_durtion);
        buyback = findViewById(R.id.buyback);
        tobuy = findViewById(R.id.tobuy);

        buyback.setOnClickListener(this);
        tobuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buyback:
                finish();
                overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                break;
            case R.id.tobuy:
                Toast.makeText(this,"你已经买了",Toast.LENGTH_SHORT).show();
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

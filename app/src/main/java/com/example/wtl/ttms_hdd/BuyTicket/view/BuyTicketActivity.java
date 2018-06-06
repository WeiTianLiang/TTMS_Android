package com.example.wtl.ttms_hdd.BuyTicket.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.BuyTicketPresentCompl;
import com.example.wtl.ttms_hdd.BuyTicket.presenter.IBuyTicketPresenter;
import com.example.wtl.ttms_hdd.R;

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
     * 得分
     * */
    private TextView buy_score;
    /**
     * 类型
     * */
    private TextView buy_type;
    /**
     * 导演
     * */
    private TextView buy_director;
    /**
     * 下拉详情
     * */
    private ImageView go_details;
    /**
     * 展示详情
     * */
    private TextView this_details;
    /**
     * 评分
     * */
    private TextView ticket_score;
    /**
    * 初始化接口
    * */
    private IBuyTicketPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
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
        buy_score = findViewById(R.id.buy_score);
        buy_type = findViewById(R.id.buy_type);
        buy_director = findViewById(R.id.buy_director);
        go_details = findViewById(R.id.go_details);
        this_details = findViewById(R.id.this_details);
        ticket_score = findViewById(R.id.ticket_score);
        buyback = findViewById(R.id.buyback);

        go_details.setOnClickListener(this);
        ticket_score.setOnClickListener(this);
        buyback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buyback:
                finish();
                overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                break;
            case R.id.go_details:
                if(presenter == null) {
                    presenter = new BuyTicketPresentCompl(this);
                }
                presenter.showDetail(go_details,this_details);
                break;
            case R.id.ticket_score:
                /*
                * 评分功能
                * */
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

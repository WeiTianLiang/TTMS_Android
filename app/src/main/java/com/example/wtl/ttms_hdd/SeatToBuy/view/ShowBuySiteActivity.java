package com.example.wtl.ttms_hdd.SeatToBuy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.presenter.ISeatToBuyPresenter;
import com.example.wtl.ttms_hdd.SeatToBuy.presenter.SeatToBuyPresenterCompl;
import com.example.wtl.ttms_hdd.SeatToBuy.view.drawView.SeatView;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;

public class ShowBuySiteActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 返回
     */
    private ImageView siteback;
    /**
     * 影片名
     */
    private TextView ticketname;
    /**
     * 上映日期
     */
    private TextView ticketdate;
    /**
     * 上映时间
     */
    private TextView ticketime;
    /**
     * 影厅名
     */
    private TextView sitename;
    /**
     * 座位图
     */
    private SeatView seats;
    /**
     * 逻辑层接口初始化
     */
    private ISeatToBuyPresenter presenter;
    /**
     * 选中切换view
     */
    private LinearLayout chooseon;
    /**
     * 选中的票
     */
    private RecyclerView isbuy;
    /**
     * 总共的钱
     */
    private TextView paymoney;
    /**
     * 未选中提示
     */
    private TextView select_Prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_buy_site);
        HideScreenTop.HideScreenTop(getWindow());
        String name = getIntent().getStringExtra("name");
        String startime = getIntent().getStringExtra("startime");
        String date = getIntent().getStringExtra("date");
        String threatname = getIntent().getStringExtra("threat_name");
        String goodId = getIntent().getStringExtra("goodId");
        String threaterId = getIntent().getStringExtra("threaterId");
        String price = getIntent().getStringExtra("price");
        Montior();
        ticketname.setText(name);
        ticketdate.setText(date);
        ticketime.setText(startime);
        sitename.setText(threatname);
        if (presenter == null) {
            presenter = new SeatToBuyPresenterCompl(this);
        }
        presenter.getSeatNumber(goodId, seats, threaterId, chooseon, isbuy, paymoney, select_Prompt, Integer.parseInt(price));
    }

    private void Montior() {
        siteback = (ImageView) findViewById(R.id.siteback);
        ticketname = (TextView) findViewById(R.id.ticketname);
        ticketdate = (TextView) findViewById(R.id.ticketdate);
        ticketime = (TextView) findViewById(R.id.ticketime);
        sitename = (TextView) findViewById(R.id.sitename);
        select_Prompt = (TextView) findViewById(R.id.select_Prompt);
        seats = (SeatView) findViewById(R.id.seats);
        seats.setScreenName("屏幕位置");
        seats.setMaxSelected(5);

        chooseon = (LinearLayout) findViewById(R.id.chooseon);
        isbuy = (RecyclerView) findViewById(R.id.isbuy);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(100);
        isbuy.setLayoutManager(manager);
        isbuy.setItemAnimator(animator);
        paymoney = (TextView) findViewById(R.id.paymoney);

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

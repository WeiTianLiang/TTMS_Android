package com.example.wtl.ttms_hdd.IsPayTicket.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.wtl.ttms_hdd.IsPayTicket.presenter.IsPayTicketPresenter;
import com.example.wtl.ttms_hdd.IsPayTicket.presenter.IsPayTicketPresenterCompl;
import com.example.wtl.ttms_hdd.R;

public class IsPayTicketActivity extends AppCompatActivity {

    private ImageView isback;
    private RecyclerView ispayrecycler;
    private IsPayTicketPresenter payPresenter;
    private SwipeRefreshLayout isrefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_pay_ticket);
        if(payPresenter == null) {
            payPresenter = new IsPayTicketPresenterCompl(this);
        }
        isback = (ImageView) findViewById(R.id.isback);
        ispayrecycler = (RecyclerView) findViewById(R.id.ispayrecycler);
        isrefresh = (SwipeRefreshLayout) findViewById(R.id.isrefresh);
        isrefresh.setColorSchemeResources(android.R.color.holo_red_light);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        ispayrecycler.setLayoutManager(manager);

        payPresenter.setAdapter(ispayrecycler);

        isback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
            }
        });

        isrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh();
            }
        });

    }

    private void isRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(payPresenter == null) {
                            payPresenter = new IsPayTicketPresenterCompl(IsPayTicketActivity.this);
                        }
                        payPresenter.setAdapter(ispayrecycler);
                        isrefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}

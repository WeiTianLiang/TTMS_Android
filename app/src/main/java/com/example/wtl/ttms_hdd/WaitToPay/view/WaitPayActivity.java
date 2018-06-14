package com.example.wtl.ttms_hdd.WaitToPay.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.WaitToPay.presenter.IWaitTPayPresenter;
import com.example.wtl.ttms_hdd.WaitToPay.presenter.WaitToPayPresenterCompl;

public class WaitPayActivity extends AppCompatActivity {

    private ImageView waitback;
    private RecyclerView willpayrecycler;
    private IWaitTPayPresenter payPresenter;
    private SwipeRefreshLayout waitrefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_pay);
        if(payPresenter == null) {
            payPresenter = new WaitToPayPresenterCompl(this);
        }
        waitback = (ImageView) findViewById(R.id.waitback);
        willpayrecycler = (RecyclerView) findViewById(R.id.willpayrecycler);
        waitrefresh = (SwipeRefreshLayout) findViewById(R.id.waitrefresh);
        waitrefresh.setColorSchemeResources(android.R.color.holo_red_light);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        willpayrecycler.setLayoutManager(manager);

        payPresenter.setAdapter(willpayrecycler);

        waitback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
            }
        });

        waitrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                waitRefresh();
            }
        });
    }

    private void waitRefresh() {
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
                            payPresenter = new WaitToPayPresenterCompl(WaitPayActivity.this);
                        }
                        payPresenter.setAdapter(willpayrecycler);
                        waitrefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}

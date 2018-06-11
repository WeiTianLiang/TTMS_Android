package com.example.wtl.ttms_hdd.DrawSiteToBuy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;

public class ShowBuySiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_buy_site);
        HideScreenTop.HideScreenTop(getWindow());
    }
}

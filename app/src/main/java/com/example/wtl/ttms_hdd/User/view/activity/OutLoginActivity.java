package com.example.wtl.ttms_hdd.User.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.Login.view.LoginActivity;
import com.example.wtl.ttms_hdd.Main.view.MainActivity;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;

public class OutLoginActivity extends AppCompatActivity {

    private TextView out;
    private ImageView outback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_login);
        HideScreenTop.HideScreenTop(getWindow());
        out = (TextView) findViewById(R.id.out);
        outback = (ImageView) findViewById(R.id.outback);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent("com.example.wtl.ttms_hdd.User.outlogin");
                sendBroadcast(intent1);
                Intent intent = new Intent(OutLoginActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.activity_left_in,R.anim.activity_left_out);
            }
        });
        outback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
            }
        });
    }
}

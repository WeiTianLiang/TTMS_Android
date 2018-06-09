package com.example.wtl.ttms_hdd.Tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.example.wtl.ttms_hdd.R;

/**
 * activity间的跳转
 * Created by WTL on 2018/6/9.
 */

public class JumpActivity {

    public static void JumpActivity(Context context,Class clss,String name) {
        Intent intent = new Intent(context, clss);
        intent.putExtra("name",name);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
    }

}

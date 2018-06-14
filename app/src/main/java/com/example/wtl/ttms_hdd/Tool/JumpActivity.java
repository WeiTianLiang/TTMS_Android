package com.example.wtl.ttms_hdd.Tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.wtl.ttms_hdd.R;

/**
 * activity间的跳转
 * Created by WTL on 2018/6/9.
 */

public class JumpActivity {

    public static void JumpActivity(Context context, Class clss, String name, int Id, String longtime, String imagePath) {
        Intent intent = new Intent(context, clss);
        intent.putExtra("name", name);
        intent.putExtra("Id", String.valueOf(Id));
        intent.putExtra("time", longtime);
        intent.putExtra("image", imagePath);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
    }

}

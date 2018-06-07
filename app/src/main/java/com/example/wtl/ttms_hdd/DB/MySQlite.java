package com.example.wtl.ttms_hdd.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 本地数据库——存放本地数据
 * 表1：
 * 表2：
 * Created by WTL on 2018/6/4.
 */

public class MySQlite extends SQLiteOpenHelper{

    public MySQlite(Context context) {
        super(context, "Cookie", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

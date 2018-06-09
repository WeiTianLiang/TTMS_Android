package com.example.wtl.ttms_hdd.TheHome.model;

import java.util.List;

/**
 * 即将上映类
 * Created by WTL on 2018/6/9.
 */

public class WillShowModel {

    private int result;
    private List<data> data;

    public class data {
        private String programmeName;

        public String getProgrammeName() {
            return programmeName;
        }
    }

    public int getResult() {
        return result;
    }

    public List<WillShowModel.data> getData() {
        return data;
    }
}

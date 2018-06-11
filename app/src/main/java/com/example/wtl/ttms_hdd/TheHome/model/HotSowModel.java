package com.example.wtl.ttms_hdd.TheHome.model;

import java.util.List;

/**
 * 热映类
 * Created by WTL on 2018/6/9.
 */

public class HotSowModel {

    private int result;
    private List<data> data;

    public class data {
        private int programmeId;
        private String programmeName;
        private String programmeDruation;

        public String getProgrammeName() {
            return programmeName;
        }

        public int getProgrammeId() {
            return programmeId;
        }

        public String getProgrammeDruation() {
            return programmeDruation;
        }
    }

    public int getResult() {
        return result;
    }

    public List<HotSowModel.data> getData() {
        return data;
    }
}

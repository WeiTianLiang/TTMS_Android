package com.example.wtl.ttms_hdd.TheHome.model;

import java.util.List;

/**
 * 热映类
 * Created by WTL on 2018/6/9.
 */

public class HotSowModel {

    private int result;
    private String msg;
    private List<data> data;

    public static class data {
        private int programmeId;
        private String programmeName;
        private String duration;
        private String programmeImagePath;

        public String getProgrammeName() {
            return programmeImagePath;
        }

        public int getProgrammeId() {
            return programmeId;
        }

        public String getDuration() {
            return duration;
        }

        public String getProgrammeImagePath() {
            return programmeName;
        }
    }

    public int getResult() {
        return result;
    }

    public List<HotSowModel.data> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

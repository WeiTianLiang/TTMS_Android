package com.example.wtl.ttms_hdd.Film.model;

import java.util.List;

/**
 * 剧目基本信息
 * Created by WTL on 2018/6/8.
 */

public class FilmModel {

    private int result;
    private List<FilmModel.data> data;

    public class data {
        int programmeId;//剧目ID
        String programmeName;//剧目名称
        String programmeDruation;//时长
        String programmeImagePath;//图片

        public int getProgrammeId() {
            return programmeId;
        }

        public String getProgrammeDruation() {
            return programmeDruation;
        }

        public String getProgrammeName() {
            return programmeName;
        }

        public String getProgrammeImagePath() {
            return programmeImagePath;
        }
    }

    public List<FilmModel.data> getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

}

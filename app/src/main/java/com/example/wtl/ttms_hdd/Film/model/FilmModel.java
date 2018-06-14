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
        String duration;//时长
        String programmeImagePath;//图片
        String playDate;//上映日期

        public int getProgrammeId() {
            return programmeId;
        }

        public String getDuration() {
            return duration;
        }

        public String getProgrammeName() {
            return programmeImagePath;
        }

        public String getProgrammeImagePath() {
            return programmeName;
        }

        public String getPlayDate() {
            return playDate;
        }
    }

    public List<FilmModel.data> getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

}

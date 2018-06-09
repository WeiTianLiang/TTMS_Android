package com.example.wtl.ttms_hdd.BuyTicket.model;


/**
 * 影片信息数据
 * Created by WTL on 2018/6/9.
 */

public class FilmdetailModel {

    private int result;
    private data data;

    public class data {
        private int programmeId;
        private String programmeName;
        private int programmeDruation;
        private String programmeTags;
        private String programmeProfile;

        public int getProgrammeDruation() {
            return programmeDruation;
        }

        public int getProgrammeId() {
            return programmeId;
        }

        public String getProgrammeProfile() {
            return programmeProfile;
        }

        public String getProgrammeName() {
            return programmeName;
        }

        public String getProgrammeTags() {
            return programmeTags;
        }
    }

    public FilmdetailModel.data getData() {
        return data;
    }

    public int getResult() {
        return result;
    }
}

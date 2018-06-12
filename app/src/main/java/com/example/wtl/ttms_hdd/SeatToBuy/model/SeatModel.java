package com.example.wtl.ttms_hdd.SeatToBuy.model;

import java.util.List;

/**
 * 座位数据
 * Created by WTL on 2018/6/12.
 */

public class SeatModel {

    private int result;
    private String msg;
    private List<data> data;

    public class data {
        private int seatId;
        private int theaterId;
        private boolean status;
        private int seatRowNumber;
        private int seatColNumber;

        public boolean isStatus() {
            return status;
        }

        public int getSeatColNumber() {
            return seatColNumber;
        }

        public int getSeatId() {
            return seatId;
        }

        public int getSeatRowNumber() {
            return seatRowNumber;
        }

        public int getTheaterId() {
            return theaterId;
        }
    }

    public int getResult() {
        return result;
    }

    public List<SeatModel.data> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

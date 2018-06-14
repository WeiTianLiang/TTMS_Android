package com.example.wtl.ttms_hdd.SeatToBuy.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * 获取票信息
 * Created by WTL on 2018/6/13.
 */

public class GetTicketModel {

    private int result;
    private String msg;
    private List<data> data;

    public static class data implements Parcelable {
        private String name;
        private String performance;
        private String date;
        private int price;
        private String theaterName;
        private int seatRowNumber;
        private int seatColNumber;
        private int status;
        private int id;

        public data(String name,String performance,String date,int price,String theaterName,int seatRowNumber,
                    int seatColNumber,int status,int id) {
            this.name = name;
            this.performance = performance;
            this.date = date;
            this.price = price;
            this.theaterName = theaterName;
            this.seatRowNumber = seatRowNumber;
            this.seatColNumber = seatColNumber;
            this.status = status;
            this.id = id;
        }

        protected data(Parcel in) {
            name = in.readString();
            performance = in.readString();
            date = in.readString();
            price = in.readInt();
            theaterName = in.readString();
            seatRowNumber = in.readInt();
            seatColNumber = in.readInt();
            status = in.readInt();
            id = in.readInt();
        }

        public static final Creator<data> CREATOR = new Creator<data>() {
            @Override
            public data createFromParcel(Parcel in) {
                return new data(in);
            }

            @Override
            public data[] newArray(int size) {
                return new data[size];
            }
        };

        public int getId() {
            return id;
        }

        public int getPrice() {
            return price;
        }

        public int getSeatColNumber() {
            return seatColNumber;
        }

        public int getSeatRowNumber() {
            return seatRowNumber;
        }

        public int getStatus() {
            return status;
        }

        public String getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        public String getPerformance() {
            return performance;
        }

        public String getTheaterName() {
            return theaterName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name);
            parcel.writeString(performance);
            parcel.writeString(date);
            parcel.writeInt(price);
            parcel.writeString(theaterName);
            parcel.writeInt(seatRowNumber);
            parcel.writeInt(seatColNumber);
            parcel.writeInt(status);
            parcel.writeInt(id);
        }
    }

    public int getResult() {
        return result;
    }

    public List<GetTicketModel.data> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}

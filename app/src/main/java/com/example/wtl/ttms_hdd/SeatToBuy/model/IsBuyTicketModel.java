package com.example.wtl.ttms_hdd.SeatToBuy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 已经选中的票的信息
 * Created by WTL on 2018/6/12.
 */

public class IsBuyTicketModel implements Parcelable {

    private String locat;
    private String price;

    public IsBuyTicketModel(String locat,String price) {
        this.locat = locat;
        this.price = price;
    }

    protected IsBuyTicketModel(Parcel in) {
        locat = in.readString();
        price = in.readString();
    }

    public static final Creator<IsBuyTicketModel> CREATOR = new Creator<IsBuyTicketModel>() {
        @Override
        public IsBuyTicketModel createFromParcel(Parcel in) {
            return new IsBuyTicketModel(in);
        }

        @Override
        public IsBuyTicketModel[] newArray(int size) {
            return new IsBuyTicketModel[size];
        }
    };

    public String getLocat() {
        return locat;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(locat);
        parcel.writeString(price);
    }
}

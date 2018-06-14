package com.example.wtl.ttms_hdd.PayMoney.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;

import java.util.List;

/**
 * 座位显示适配器
 * Created by WTL on 2018/6/14.
 */

public class YouSeatsAdapter extends RecyclerView.Adapter<YouSeatsAdapter.ViewHolder> {

    private List<IsBuyTicketModel> stringList;
    private Context context;

    public YouSeatsAdapter(Context context, List<IsBuyTicketModel> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @Override
    public YouSeatsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.showseatcard, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(YouSeatsAdapter.ViewHolder holder, int position) {
        IsBuyTicketModel s = stringList.get(position);
        holder.youeat.setText(s.getLocat());
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView youeat;

        public ViewHolder(View itemView) {
            super(itemView);
            youeat = (TextView) itemView.findViewById(R.id.youseat);
        }
    }
}

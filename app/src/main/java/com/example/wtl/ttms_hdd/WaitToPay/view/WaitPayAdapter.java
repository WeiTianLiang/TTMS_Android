package com.example.wtl.ttms_hdd.WaitToPay.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.PayMoney.view.PayMoneyActivity;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.WaitToPay.model.WaitDateModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public class WaitPayAdapter extends RecyclerView.Adapter<WaitPayAdapter.ViewHolder> {

    private List<WaitDateModel.data> modelList;
    private Context context;

    public WaitPayAdapter(Context context,List<WaitDateModel.data> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public WaitPayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.waitpaycard,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WaitPayAdapter.ViewHolder holder, int position) {
        WaitDateModel.data wait = modelList.get(position);
        holder.waitname.setText(wait.getName());
        holder.waittime.setText(wait.getDate());
        holder.waitthreat.setText(wait.getTheaterName());
        holder.waitlocat.setText(String.valueOf(wait.getSeatRowNumber())+"排"+String.valueOf(wait.getSeatColNumber())+"座");
        holder.waitprice.setText(String.valueOf(wait.getPrice())+"元");
        holder.tobuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PayMoneyActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in,R.anim.activity_left_out);
            }
        });
        holder.ticket_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PayMoneyActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in,R.anim.activity_left_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView waitname;
        RelativeLayout tobuy;
        TextView waittime;
        TextView waitthreat;
        TextView waitlocat;
        TextView waitprice;
        TextView ticket_pay;

        public ViewHolder(View itemView) {
            super(itemView);
            waitname = itemView.findViewById(R.id.waitname);
            tobuy = itemView.findViewById(R.id.tobuy);
            waittime = itemView.findViewById(R.id.waittime);
            waitlocat = itemView.findViewById(R.id.waitlocat);
            waitthreat = itemView.findViewById(R.id.waitthreat);
            waitprice = itemView.findViewById(R.id.waitprice);
            ticket_pay = itemView.findViewById(R.id.ticket_pay);
        }
    }
}

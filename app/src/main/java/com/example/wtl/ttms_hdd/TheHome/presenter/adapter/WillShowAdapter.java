package com.example.wtl.ttms_hdd.TheHome.presenter.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.BuyTicket.view.activity.BuyTicketActivity;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.TheHome.model.WillShowModel;

import java.util.List;

/**
 * 即将上映适配器
 * Created by WTL on 2018/6/9.
 */

public class WillShowAdapter extends RecyclerView.Adapter<WillShowAdapter.ViewHolder> {

    private List<WillShowModel> willShowModels;
    private Context context;

    public WillShowAdapter(Context context,List<WillShowModel> willShowModels) {
        this.context = context;
        this.willShowModels = willShowModels;
    }

    @Override
    public WillShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homeshow_filmcard,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WillShowAdapter.ViewHolder holder, int position) {
        WillShowModel willShowModel = willShowModels.get(position);
        holder.homeshow_image.setImageResource(willShowModel.getHomeshow_image());
        holder.homeshow_name.setText(willShowModel.getHomeshow_name());
        holder.homeshow_time.setText(willShowModel.getHomeshow_time());
        holder.will_show_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BuyTicketActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return willShowModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView homeshow_image;
        TextView homeshow_name;
        TextView homeshow_time;
        LinearLayout will_show_id;

        public ViewHolder(View itemView) {
            super(itemView);
            homeshow_image = itemView.findViewById(R.id.homeshow_image);
            homeshow_name = itemView.findViewById(R.id.homeshow_name);
            homeshow_time = itemView.findViewById(R.id.homeshow_time);
            will_show_id = itemView.findViewById(R.id.will_show_id);
        }
    }

}

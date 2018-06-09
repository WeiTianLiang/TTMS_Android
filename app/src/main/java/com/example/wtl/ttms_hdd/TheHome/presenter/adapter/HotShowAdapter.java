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
import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;
import com.example.wtl.ttms_hdd.Tool.JumpActivity;

import java.util.List;

/**
 * 正在上映适配器
 * Created by WTL on 2018/6/9.
 */

public class HotShowAdapter extends RecyclerView.Adapter<HotShowAdapter.ViewHolder> {

    private List<HotSowModel.data> hotSowModels;
    private Context context;

    public HotShowAdapter(Context context,List<HotSowModel.data> hotSowModels) {
        this.context = context;
        this.hotSowModels = hotSowModels;
    }

    @Override
    public HotShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotshow_filmcard, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HotShowAdapter.ViewHolder holder, int position) {
        final HotSowModel.data hotSowModel = hotSowModels.get(position);
        holder.willshow_image.setImageResource(R.drawable.ceshi);
        holder.willshow_name.setText(hotSowModel.getProgrammeName());
        holder.now_show_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JumpActivity.JumpActivity(context,BuyTicketActivity.class,hotSowModel.getProgrammeName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotSowModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView willshow_image;
        TextView willshow_name;
        LinearLayout now_show_id;

        public ViewHolder(View itemView) {
            super(itemView);
            willshow_image = itemView.findViewById(R.id.willshow_image);
            willshow_name = itemView.findViewById(R.id.willshow_name);
            now_show_id = itemView.findViewById(R.id.now_show_id);
        }
    }
}

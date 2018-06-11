package com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.BuyTicket.model.PlanModel;
import com.example.wtl.ttms_hdd.DrawSiteToBuy.view.ShowBuySiteActivity;
import com.example.wtl.ttms_hdd.R;

import java.util.List;

/**
 * 展示计划适配器
 * Created by WTL on 2018/6/10.
 */

public class Show_PlanAdapter extends RecyclerView.Adapter<Show_PlanAdapter.ViewHolder> {

    private List<PlanModel> planModelList;
    private Context context;

    private OnChangeItemPlan changeItemPlan;

    public Show_PlanAdapter(Context context, List<PlanModel> planModelList) {
        this.context = context;
        this.planModelList = planModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.showplan_card, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlanModel planModel = planModelList.get(position);
        holder.start_time.setText(planModel.getStart_time());
        holder.end_time.setText(planModel.getEnd_time());
        holder.threat_name.setText(planModel.getThreat_name());
        holder.ticket_price.setText(planModel.getTicket_price());
        holder.ticket_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowBuySiteActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
            }
        });
        holder.ticket_buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowBuySiteActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planModelList.size();
    }

    public void changeData(List<PlanModel> planModel) {
        planModelList.removeAll(planModel);
        planModelList = planModel;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView start_time;
        TextView end_time;
        TextView threat_name;
        TextView ticket_price;
        TextView ticket_buy;
        RelativeLayout ticket_buy1;

        public ViewHolder(View itemView) {
            super(itemView);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
            threat_name = itemView.findViewById(R.id.threat_name);
            ticket_price = itemView.findViewById(R.id.ticket_price);
            ticket_buy = itemView.findViewById(R.id.ticket_buy);
            ticket_buy1 = itemView.findViewById(R.id.ticket_buy1);
        }
    }

    public interface OnChangeItemPlan {
        void onChangeItemPlan(int position);
    }

    public void setOnChangeItemPlan(OnChangeItemPlan changeItemPlan) {
        this.changeItemPlan = changeItemPlan;
    }

}

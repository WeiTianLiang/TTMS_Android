package com.example.wtl.ttms_hdd.IsPayTicket.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.IsPayTicket.model.IsDateModel;
import com.example.wtl.ttms_hdd.R;

import java.util.List;

/**
 *
 * Created by WTL on 2018/6/14.
 */

public class IsPayAdapter extends RecyclerView.Adapter<IsPayAdapter.ViewHolder> {

    private List<IsDateModel.data> modelList;
    private Context context;

    public IsPayAdapter(Context context,List<IsDateModel.data> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public IsPayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ispaycar,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IsPayAdapter.ViewHolder holder, int position) {
        IsDateModel.data wait = modelList.get(position);
        holder.isname.setText(wait.getProgrammeName());
        holder.istime.setText(wait.getDateTime());
        holder.isthreat.setText(wait.getTheaterName());
        holder.islocat.setText(String.valueOf(wait.getRowNumber())+"排"+String.valueOf(wait.getColNumber())+"座");
        holder.isprice.setText(String.valueOf(wait.getPrice())+"元");
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView isname;
        TextView istime;
        TextView isthreat;
        TextView islocat;
        TextView isprice;

        public ViewHolder(View itemView) {
            super(itemView);
            isname = itemView.findViewById(R.id.isname);
            istime = itemView.findViewById(R.id.istime);
            islocat = itemView.findViewById(R.id.islocat);
            isthreat = itemView.findViewById(R.id.isthreat);
            isprice = itemView.findViewById(R.id.isprice);
        }
    }

}

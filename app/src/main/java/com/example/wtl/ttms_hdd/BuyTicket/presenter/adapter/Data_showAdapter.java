package com.example.wtl.ttms_hdd.BuyTicket.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.BuyTicket.model.DataModel;
import com.example.wtl.ttms_hdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示日期适配器
 * Created by WTL on 2018/6/10.
 */

public class Data_showAdapter extends RecyclerView.Adapter<Data_showAdapter.ViewHolder> {

    private List<DataModel> dataModelList;
    private Context context;
    private ViewHolder viewHolder;
    private List<Boolean> isclick = new ArrayList<>();
    private OnChangePlanData changePlanData;

    public Data_showAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
        for (int i = 0; i < dataModelList.size(); i++) {
            if (i != 0) {
                isclick.add(false);
            } else {
                isclick.add(true);
            }
        }
    }

    @Override
    public Data_showAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dateshowacard, null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final Data_showAdapter.ViewHolder holder, final int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.showdata.setText(dataModel.getData());
        if (isclick.get(position)) {
            holder.line.setVisibility(View.VISIBLE);
        } else {
            holder.line.setVisibility(View.GONE);
        }
        holder.clickdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dataModelList.size(); i++) {
                    isclick.set(i, false);
                }
                isclick.set(position, true);
                notifyDataSetChanged();

                if (changePlanData != null) {
                    changePlanData.ChangePlanData();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView showdata;
        View line;
        LinearLayout clickdata;

        public ViewHolder(View itemView) {
            super(itemView);
            showdata = itemView.findViewById(R.id.showdata);
            line = itemView.findViewById(R.id.line);
            clickdata = itemView.findViewById(R.id.clickdata);
        }
    }

    public interface OnChangePlanData {
        void ChangePlanData();
    }


    public void setOnChangePlanData(OnChangePlanData changePlanData) {
        this.changePlanData = changePlanData;
    }

}

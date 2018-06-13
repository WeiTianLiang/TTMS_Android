package com.example.wtl.ttms_hdd.SeatToBuy.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.SeatToBuy.model.IsBuyTicketModel;
import com.example.wtl.ttms_hdd.SeatToBuy.view.drawView.SeatView;

import java.util.List;

/**
 * 选中的票适配器
 * Created by WTL on 2018/6/12.
 */

public class YouTicketAdapter extends RecyclerView.Adapter<YouTicketAdapter.ViewHolder> {

    private List<IsBuyTicketModel> modelList;
    private Context context;
    private SeatView seats;

    public YouTicketAdapter(Context context, List<IsBuyTicketModel> modelList, SeatView seats) {
        this.context = context;
        this.modelList = modelList;
        this.seats = seats;
    }

    @Override
    public YouTicketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isbuycard, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(YouTicketAdapter.ViewHolder holder, final int position) {
        IsBuyTicketModel model = modelList.get(position);
        holder.locat.setText(model.getLocat());
        holder.oneprice.setText(model.getPrice());
    }

    /**
     * 删除
     */
    public int removeitem(int position, String locat) {
        if (position != -1 && locat == null) {
            modelList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, modelList.size() - position);
            return -1;
        } else if (position == -1 && locat != null) {
            for (int i = 0; i < modelList.size(); i++) {
                if ((modelList.get(i).getLocat()).equals(locat)) {
                    modelList.remove(i);
                    notifyItemRemoved(i);
                    notifyItemRangeChanged(i, modelList.size() - i);
                }
            }
            return -1;
        }
        return 0;
    }

    /**
     * 添加
     */
    public void additem(IsBuyTicketModel model) {
        modelList.add(model);
        notifyItemInserted(modelList.size() - 1);
        notifyItemRangeInserted(modelList.size() - 1, modelList.size());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView locat;
        TextView oneprice;

        public ViewHolder(View itemView) {
            super(itemView);
            locat = (TextView) itemView.findViewById(R.id.locat);
            oneprice = (TextView) itemView.findViewById(R.id.oneprice);
        }
    }

}

package com.example.wtl.ttms_hdd.HDDMain.presenter;

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

import com.example.wtl.ttms_hdd.BuyTicket.view.BuyTicketActivity;
import com.example.wtl.ttms_hdd.HDDMain.model.FileModel;
import com.example.wtl.ttms_hdd.HDDMain.model.IFile;
import com.example.wtl.ttms_hdd.HDDMain.view.Activity.MainActivity;
import com.example.wtl.ttms_hdd.R;

import java.util.List;

/**
 * 适配器
 * Created by WTL on 2018/6/5.
 */

public class FilmSellAdapter extends RecyclerView.Adapter<FilmSellAdapter.ViewHolder> {

    private List<FileModel> fileModelList;
    private Context context;

    public FilmSellAdapter(List<FileModel> fileModelList,Context context) {
        this.fileModelList = fileModelList;
        this.context = context;
    }

    @Override
    public FilmSellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.filmrecyclercard,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilmSellAdapter.ViewHolder holder, int position) {
        IFile file = fileModelList.get(position);
        holder.film_head.setImageResource(file.getFilm_head());
        holder.film_name.setText(file.getFilm_name());
        holder.film_acters.setText(file.getFilm_acters());
        holder.average_score.setText(file.getAverage_score());
        holder.jump_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                * 跳转详情销售
                * */
                Intent intent = new Intent(context, BuyTicketActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
            }
        });
        holder.jump_buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                * 跳转详情销售
                * */
                Intent intent = new Intent(context, BuyTicketActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView film_head;
        TextView film_name;
        TextView film_acters;
        TextView average_score;
        TextView jump_buy;
        LinearLayout jump_buy2;

        public ViewHolder(View itemView) {
            super(itemView);
            film_head = itemView.findViewById(R.id.film_head);
            film_name = itemView.findViewById(R.id.film_name);
            film_acters = itemView.findViewById(R.id.film_acters);
            average_score = itemView.findViewById(R.id.average_score);
            jump_buy = itemView.findViewById(R.id.jump_buy);
            jump_buy2 = itemView.findViewById(R.id.jump_buy2);
        }
    }
}

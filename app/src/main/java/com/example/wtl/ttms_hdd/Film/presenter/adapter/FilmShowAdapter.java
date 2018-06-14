package com.example.wtl.ttms_hdd.Film.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wtl.ttms_hdd.BuyTicket.view.activity.BuyTicketActivity;
import com.example.wtl.ttms_hdd.Film.model.FilmModel;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.JumpActivity;

import java.util.List;

/**
 * 影片展示适配器
 * Created by WTL on 2018/6/8.
 */

public class FilmShowAdapter extends RecyclerView.Adapter<FilmShowAdapter.ViewHolder> {

    private List<FilmModel.data> filmModelList;
    private Context context;

    public FilmShowAdapter(List<FilmModel.data> fileModelList, Context context) {
        this.filmModelList = fileModelList;
        this.context = context;
    }

    @Override
    public FilmShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.filmrecyclercard, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final FilmShowAdapter.ViewHolder holder, int position) {
        final FilmModel.data file = filmModelList.get(position);
        String startTime = formatDate(file.getPlayDate());
        final String image = "http://123.206.82.241:8090/" + file.getProgrammeImagePath();
        Glide.with(context).load(image).into(holder.film_head);
        holder.film_name.setText(file.getProgrammeName());
        holder.film_time.setText(file.getDuration());
        holder.film_timestart.setText(startTime);
        holder.jump_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                * 跳转详情销售
                * */
                JumpActivity.JumpActivity(context, BuyTicketActivity.class, file.getProgrammeName(),
                        file.getProgrammeId(), file.getDuration(), image);
            }
        });
        holder.jump_buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                * 跳转详情销售
                * */
                JumpActivity.JumpActivity(context, BuyTicketActivity.class, file.getProgrammeName(),
                        file.getProgrammeId(), file.getDuration(), image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView film_head;
        TextView film_name;
        TextView film_time;
        TextView average_score;
        TextView jump_buy;
        LinearLayout jump_buy2;
        TextView film_timestart;

        public ViewHolder(View itemView) {
            super(itemView);
            film_head = itemView.findViewById(R.id.film_head);
            film_name = itemView.findViewById(R.id.film_name);
            film_time = itemView.findViewById(R.id.film_time);
            average_score = itemView.findViewById(R.id.average_score);
            film_timestart = itemView.findViewById(R.id.film_timestart);
            jump_buy = itemView.findViewById(R.id.jump_buy);
            jump_buy2 = itemView.findViewById(R.id.jump_buy2);
        }
    }

    private String formatDate(String date) {
        String[] dates = date.split("T");
        return dates[0];
    }

}

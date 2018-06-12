package com.example.wtl.ttms_hdd.Film.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.Film.model.FilmModel;
import com.example.wtl.ttms_hdd.Film.presenter.adapter.FilmShowAdapter;
import com.example.wtl.ttms_hdd.Film.presenter.adapter.HDDPagerAdapter;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.Tool.FileOperate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 电影逻辑
 * Created by WTL on 2018/6/8.
 */

public class FilmResenterCompl implements IFilmPresenter {

    private Context context;

    public FilmResenterCompl(Context context) {
        this.context = context;
    }

    private List<FilmModel.data> dataList = new ArrayList<>();

    @Override
    public void setFilmSellAdapter(final RecyclerView recyclerView, final Context context) {
        GetFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetFilm_Inference.class);
        Call<FilmModel> call = request.getFilmBase();
        call.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            for (FilmModel.data data : response.body().getData()) {
                                dataList.add(data);
                            }
                            if (dataList.size() != 0) {
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        FilmShowAdapter adapter = new FilmShowAdapter(dataList, context);
                                        recyclerView.setAdapter(adapter);
                                    }
                                });
                            } else {
                                Toast.makeText(context, "没有新的电影了!!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "请求失败!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "请求失败!!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("onFailure", "请求失败!!!");
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void setHDDPagerAdapter(ViewPager viewPager, FragmentManager fm, List<Fragment> fragmentList, List<String> list) {
        HDDPagerAdapter pagerAdapter = new HDDPagerAdapter(fm, fragmentList, list);
        viewPager.setAdapter(pagerAdapter);
    }
}

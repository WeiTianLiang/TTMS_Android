package com.example.wtl.ttms_hdd.Film.presenter;

import android.app.Activity;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
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
import com.example.wtl.ttms_hdd.Tool.PackageGson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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

    @Override
    public void setFilmSellAdapter(final RecyclerView recyclerView) {
        final List<FilmModel.data> dataList = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("playDate", getTime());
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        GetFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetFilm_Inference.class);
        Call<FilmModel> call = request.getFilmBase(body);
        call.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(final Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            int k = 0;
                            for (FilmModel.data data : response.body().getData()) {
                                if (dataList.size() == 0) {
                                    dataList.add(data);
                                } else {
                                    for (int i = 0; i < dataList.size(); i++) {
                                        if ((dataList.get(i).getProgrammeName()).equals(data.getProgrammeName())) {
                                            k = 0;
                                        } else {
                                            k = 1;
                                        }
                                    }
                                    if(k == 1) {
                                        dataList.add(data);
                                    }
                                }
                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    FilmShowAdapter adapter = new FilmShowAdapter(dataList, context);
                                    recyclerView.setAdapter(adapter);
                                }
                            });
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
    public void setWillFilmSellAdapter(final RecyclerView recyclerView) {
        final List<FilmModel.data> dataList = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("playDate", getNextTime(1));
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        GetFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetFilm_Inference.class);
        Call<FilmModel> call = request.getFilmBase(body);
        call.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(final Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            int k = 0;
                            for (FilmModel.data data : response.body().getData()) {
                                if (dataList.size() == 0) {
                                    dataList.add(data);
                                } else {
                                    for (int i = 0; i < dataList.size(); i++) {
                                        if ((dataList.get(i).getProgrammeName()).equals(data.getProgrammeName())) {
                                            k = 0;
                                            break;
                                        } else {
                                            k = 1;
                                        }
                                    }
                                    if(k == 1) {
                                        dataList.add(data);
                                    }
                                }
                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    FilmShowAdapter adapter = new FilmShowAdapter(dataList, context);
                                    recyclerView.setAdapter(adapter);
                                }
                            });
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

    /**
     * 获取当前时间
     */
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String time = format.format(date);
        return time;
    }

    /**
     * 获取之后时间
     */
    private String getNextTime(int tc) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        Date date = new Date();
        String time = format.format(date);
        String[] t = time.split("-");
        int tcc = Integer.parseInt(t[2]) + tc;
        t[2] = String.valueOf(tcc);
        String s = t[0] + "-" + t[1] + "-" + t[2];
        return s;
    }
}

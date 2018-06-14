package com.example.wtl.ttms_hdd.TheHome.presenter;

import android.app.Activity;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.BuyTicket.view.activity.BuyTicketActivity;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.HotShowAdapter;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.ImageGlideAdapter;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.Tool.JumpActivity;
import com.example.wtl.ttms_hdd.Tool.PackageGson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

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
 * 主页逻辑层实现
 * Created by WTL on 2018/6/8.
 */

public class TheHomePresenterCompl implements ITheHomePresenter {

    private List<String> urlImage;
    private Context context;
    private List<HotSowModel.data> hotshowlist;

    public TheHomePresenterCompl(Context context) {
        this.context = context;
    }

    private void loadImage(Banner banner) {
        banner.setImageLoader(new ImageGlideAdapter());
        banner.setDelayTime(4000);
        banner.setImages(urlImage);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                JumpActivity.JumpActivity(context, BuyTicketActivity.class, hotshowlist.get(position).getProgrammeName()
                        , hotshowlist.get(position).getProgrammeId(), hotshowlist.get(position).getDuration(), urlImage.get(position));
            }
        });
    }

    @Override
    public void setHotAdapter(final RecyclerView recyclerView, final TextView text, final Banner banner) {
        hotshowlist = new ArrayList<>();
        urlImage = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("playDate", getTime());
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        GetHomeFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetHomeFilm_Inference.class);
        Call<HotSowModel> call = request.getFilmMess(body);
        call.enqueue(new Callback<HotSowModel>() {
            @Override
            public void onResponse(Call<HotSowModel> call, Response<HotSowModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            int k = 0;
                            for (HotSowModel.data data : response.body().getData()) {
                                if (hotshowlist.size() == 0) {
                                    hotshowlist.add(data);
                                    urlImage.add("http://123.206.82.241:8090/" + data.getProgrammeImagePath());
                                } else {
                                    for (int i = 0; i < hotshowlist.size(); i++) {
                                        if ((hotshowlist.get(i).getProgrammeName()).equals(data.getProgrammeName())) {
                                            k = 0;
                                            break;
                                        } else {
                                            k = 1;
                                        }
                                    }
                                    if(k == 1) {
                                        hotshowlist.add(data);
                                        if (urlImage.size() <= 5) {
                                            urlImage.add("http://123.206.82.241:8090/" + data.getProgrammeImagePath());
                                        }
                                    }
                                }
                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    text.setText("全部"+hotshowlist.size()+"部");
                                    HotShowAdapter adapter = new HotShowAdapter(context, hotshowlist);
                                    recyclerView.setAdapter(adapter);
                                    loadImage(banner);
                                }
                            });
                        } else {
                            Log.e("onFailure", response.body().getMsg());
                        }
                    } else {
                        Log.e("onFailure", "获取数据为空！！！");
                    }
                } else {
                    Log.e("onFailure", "获取失败！！！");
                }
            }

            @Override
            public void onFailure(Call<HotSowModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void setWillAdapter(final RecyclerView recyclerView, final TextView text) {
        final List<HotSowModel.data> willshowlist = new ArrayList<>();
        GetHomeFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetHomeFilm_Inference.class);
        Map<Object, Object> map = new HashMap<>();
        map.put("playDate", getNextTime(1));
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
        Call<HotSowModel> call = request.getFilmMess(body);
        call.enqueue(new Callback<HotSowModel>() {
            @Override
            public void onResponse(Call<HotSowModel> call, Response<HotSowModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            int k = 0;
                            for (HotSowModel.data data : response.body().getData()) {
                                if (willshowlist.size() == 0) {
                                    willshowlist.add(data);
                                } else {
                                    for (int i = 0; i < willshowlist.size(); i++) {
                                        if ((willshowlist.get(i).getProgrammeName()).equals(data.getProgrammeName())) {
                                            k = 0;
                                        } else {
                                            k = 1;
                                        }
                                    }
                                    if(k == 1) {
                                        willshowlist.add(data);
                                    }
                                }
                            }
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    text.setText("全部"+willshowlist.size()+"部");
                                    HotShowAdapter adapter = new HotShowAdapter(context, willshowlist);
                                    recyclerView.setAdapter(adapter);
                                }
                            });
                        } else {
                            Log.e("onFailure", response.body().getMsg());
                        }
                    } else {
                        Log.e("onFailure", "获取数据为空！！！");
                    }
                } else {
                    Log.e("onFailure", "获取失败！！！");
                }
            }

            @Override
            public void onFailure(Call<HotSowModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
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

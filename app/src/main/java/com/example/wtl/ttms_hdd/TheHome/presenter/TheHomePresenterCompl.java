package com.example.wtl.ttms_hdd.TheHome.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.TheHome.model.HotSowModel;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.HotShowAdapter;
import com.example.wtl.ttms_hdd.TheHome.presenter.adapter.ImageGlideAdapter;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 主页逻辑层实现
 * Created by WTL on 2018/6/8.
 */

public class TheHomePresenterCompl implements ITheHomePresenter {

    private List<String> urlImage = new ArrayList<>();
    private Context context;

    private List<HotSowModel.data> hotSowModels = new ArrayList<>();
    private List<HotSowModel.data> willShowModels = new ArrayList<>();

    public TheHomePresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public List<String> loadImage(Banner banner) {
        banner.setImageLoader(new ImageGlideAdapter());
        banner.setDelayTime(4000);
        urlImage.add("http://2t.5068.com/uploads/allimg/151027/57-15102G45306-51.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/06.jpg");
        urlImage.add("http://uploads.5068.com/allimg/1712/151-1G2010U113.jpg");
        urlImage.add("http://pic1.win4000.com/wallpaper/8/596345446e294.jpg");
        urlImage.add("http://pic1.5442.com/2015/0613/04/07.jpg");
        banner.setImages(urlImage);
        banner.start();
        return null;
    }

    @Override
    public void setHotAdapter(final RecyclerView recyclerView) {
        GetHomeFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetHomeFilm_Inference.class);
        Call<HotSowModel> call = request.getHotShow();
        call.enqueue(new Callback<HotSowModel>() {
            @Override
            public void onResponse(Call<HotSowModel> call, final Response<HotSowModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    for(HotSowModel.data data:response.body().getData()) {
                                        hotSowModels.add(data);
                                    }
                                    HotShowAdapter adapter = new HotShowAdapter(context,hotSowModels);
                                    recyclerView.setAdapter(adapter);
                                }
                            });
                        } else {
                            Log.e("onFailure", "请求格式错误或网络问题");
                        }
                    } else {
                        Log.e("onFailure", "数据不存在");
                    }
                } else {
                    Log.e("onFailure", "失败");
                }
            }

            @Override
            public void onFailure(Call<HotSowModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void setWillAdapter(final RecyclerView recyclerView) {
        GetHomeFilm_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetHomeFilm_Inference.class);
        Call<HotSowModel> call = request.getWillShow();
        call.enqueue(new Callback<HotSowModel>() {
            @Override
            public void onResponse(Call<HotSowModel> call, final Response<HotSowModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() == 200) {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    for(HotSowModel.data data:response.body().getData()) {
                                        willShowModels.add(data);
                                    }
                                    HotShowAdapter adapter = new HotShowAdapter(context,willShowModels);
                                    recyclerView.setAdapter(adapter);
                                }
                            });
                        } else {
                            Log.e("onFailure", "请求格式错误或网络问题");
                        }
                    } else {
                        Log.e("onFailure", "数据不存在");
                    }
                } else {
                    Log.e("onFailure", "失败");
                }
            }

            @Override
            public void onFailure(Call<HotSowModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }
}

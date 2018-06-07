package com.example.wtl.ttms_hdd.ChangePassword.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.ChangePassword.model.userIdModel;
import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.Tool.PackageGson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 找回密码逻辑层实现
 * Created by WTL on 2018/6/7.
 */

public class ChangePassPresenterCompl implements IChangePassPresenter {

    private Context context;

    public ChangePassPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void doChange(String account, final String password, String re_password) {

        if (account == null || password == null || re_password == null || !password.equals(re_password)) {
            Toast.makeText(context,"账号密码不能为空,确保您的密码正确",Toast.LENGTH_SHORT).show();
        } else {

            GetChange_interface request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetChange_interface.class);
            Call<userIdModel> call = request.getUserId(account);
            /*
            * 异步网络请求
            * */
            call.enqueue(new Callback<userIdModel>() {
                @Override
                public void onResponse(Call<userIdModel> call, Response<userIdModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            /*
                            * 获取账号的Id
                            * */
                            if (response.body().getResult() == 200 && response.body().getMsg().equals("successful")) {
                                int userId = response.body().getData().getUserId();
                                changePass(userId, password);
                            } else {
                                Toast.makeText(context, "账户不存在!!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "账户不存在!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "请求失败!!!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<userIdModel> call, Throwable t) {
                    Log.e("onFailure", t.getMessage() + "失败");
                }
            });
        }
    }

    private void changePass(int userId, String pass) {
        Map<String, Object> changeMap = new HashMap<>();
        changeMap.put("id", userId);
        changeMap.put("password", pass);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(changeMap));

        GetChange_interface request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetChange_interface.class);
        Call<ResultModel> call = request.postChangePass(body);

        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        /*
                        * 根据id进行密码修改
                        * */
                        if (response.body().getResult() == 200) {
                            ((Activity) context).finish();
                            ((Activity) context).overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                        } else {
                            Toast.makeText(context, "修改失败!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "修改失败!!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "修改失败!!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }
}

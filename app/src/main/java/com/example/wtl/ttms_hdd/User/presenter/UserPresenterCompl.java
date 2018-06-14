package com.example.wtl.ttms_hdd.User.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.User.model.UserMessModel;
import com.example.wtl.ttms_hdd.User.view.activity.ChangePassActivity;
import com.example.wtl.ttms_hdd.User.view.activity.OutLoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 逻辑实现
 * Created by WTL on 2018/6/14.
 */

public class UserPresenterCompl implements IUserPresenter {

    private Context context;
    private String password;

    public UserPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(context, OutLoginActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
    }

    @Override
    public void getUserMessage(final TextView name) {
        SharedPreferences preferences = context.getSharedPreferences("userId",Context.MODE_PRIVATE);
        String userId = preferences.getString("userId","");
        GetAccout_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(context)).create(GetAccout_Inference.class);
        Call<UserMessModel> call = request.getUserMess(Integer.parseInt(userId));
        call.enqueue(new Callback<UserMessModel>() {
            @Override
            public void onResponse(Call<UserMessModel> call, Response<UserMessModel> response) {
                if(response.isSuccessful()) {
                    if(response.body().getResult() == 200) {
                        final String userName = response.body().getData().getUserName();
                        password = response.body().getData().getUserPassword();
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                name.setText(userName);
                            }
                        });
                    }
                } else {
                    Log.e("onFailure", "请求失败");
                }
            }

            @Override
            public void onFailure(Call<UserMessModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage() + "失败");
            }
        });
    }

    @Override
    public void changePassword() {
        Intent intent = new Intent(context, ChangePassActivity.class);
        intent.putExtra("password",password);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
    }
}

package com.example.wtl.ttms_hdd.Register.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.HDDMain.view.Activity.MainActivity;
import com.example.wtl.ttms_hdd.Login.presenter.LoginPresenterCompl;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.CreateRetrofit;
import com.example.wtl.ttms_hdd.Tool.ResultModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 注册业务逻辑
 * 接口功能实现
 * Created by WTL on 2018/6/4.
 */

public class RegisterPresenterCompl implements IRegisterPresenter {

    private Context context;

    public RegisterPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void registerClear(EditText edit) {
        edit.setText("");
    }

    @Override
    public void registerAddTextEdit(final EditText edit, final ImageView delete) {
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*
                * 不为空时显示清除
                * */
                if (!edit.getText().toString().equals("")) {
                    delete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*
                * 为空时不显示清除
                * */
                if (edit.getText().toString().equals("")) {
                    delete.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void doBack() {
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
    }

    @Override
    public void doRegister(String name, String account, String password, String sex, String tel) {
        /*
        * 执行注册的动作
        * */
        if (name == null || account == null || password == null || sex == null || tel == null) {
            Toast.makeText(context, "注册失败!数据不能为空!", Toast.LENGTH_SHORT).show();
        } else {
            Map<String, Object> registerMap = new HashMap<>();
            registerMap.put("name", name);
            registerMap.put("account", account);
            registerMap.put("password", password);
            registerMap.put("level","售票员");
            registerMap.put("sex", sex);
            registerMap.put("tel", tel);
            registerMap.put("theaterId",-1);

            Gson gson = new Gson();
            String jsonDate = gson.toJson(registerMap);

            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonDate);
            GetRegister_Interface request = CreateRetrofit.requestRetrofit(LoginPresenterCompl.sessionId).create(GetRegister_Interface.class);
            Call<ResultModel> call = request.postCreateUser(body);
            call.enqueue(new Callback<ResultModel>() {
                @Override
                public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 200 && response.body().getMsg().equals("successful")) {
                                ((Activity) context).finish();
                                ((Activity) context).overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                            } else {
                                Toast.makeText(context, "注册失败1!!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "注册失败2!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "注册失败3!!!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResultModel> call, Throwable t) {
                    Log.e("onFailure", t.getMessage() + "失败");
                }
            });
        }

    }
}

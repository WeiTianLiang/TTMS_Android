package com.example.wtl.ttms_hdd.User.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.NetTool.CreateRetrofit;
import com.example.wtl.ttms_hdd.NetTool.ResultModel;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.FileOperate;
import com.example.wtl.ttms_hdd.Tool.HideScreenTop;
import com.example.wtl.ttms_hdd.Tool.PackageGson;
import com.example.wtl.ttms_hdd.User.presenter.GetAccout_Inference;
import com.example.wtl.ttms_hdd.User.presenter.IUserPresenter;
import com.example.wtl.ttms_hdd.User.presenter.UserPresenterCompl;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText oldpass;
    private EditText newpass;
    private EditText repnewpass;
    private ImageView changeback;
    private TextView change;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        password = getIntent().getStringExtra("password");
        HideScreenTop.HideScreenTop(getWindow());
        Montior();
    }

    private void Montior() {
        oldpass = (EditText) findViewById(R.id.oldpass);
        newpass = (EditText) findViewById(R.id.newpass);
        repnewpass = (EditText) findViewById(R.id.repnewpass);
        changeback = (ImageView) findViewById(R.id.changeback);
        change = (TextView) findViewById(R.id.change);

        change.setOnClickListener(this);
        changeback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change:
                SharedPreferences preferences = this.getSharedPreferences("userId", Context.MODE_PRIVATE);
                String userId = preferences.getString("userId","");
                if(oldpass.getText().toString().equals(password) && newpass.getText().toString().equals(repnewpass.getText().toString())) {
                    Map<Object, Object> map = new HashMap<>();
                    map.put("id", userId);
                    map.put("password", newpass.getText().toString());
                    RequestBody body = RequestBody.create(MediaType.parse("application/json"), PackageGson.PacketGson(map));
                    GetAccout_Inference request = CreateRetrofit.requestRetrofit(FileOperate.readFile(this)).create(GetAccout_Inference.class);
                    Call<ResultModel> call = request.postPassword(body);
                    call.enqueue(new Callback<ResultModel>() {
                        @Override
                        public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                            if(response.isSuccessful()) {
                                if(response.body()!=null && response.body().getResult() == 200) {
                                    Toast.makeText(ChangePassActivity.this,"修改成功!!!!",Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Log.e("onFailure", "请求失败");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResultModel> call, Throwable t) {
                            Log.e("onFailure", t.getMessage() + "失败");
                        }
                    });
                }
                break;
            case R.id.changeback:
                finish();
                overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
                break;
        }
    }
}

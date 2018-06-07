package com.example.wtl.ttms_hdd.Register.view;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Register.presenter.IRegisterPresenter;
import com.example.wtl.ttms_hdd.Register.presenter.RegisterPresenterCompl;
import com.example.wtl.ttms_hdd.Tool.ClearEditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private ImageView register_back;
    /**
     * 注册电话号
     */
    private EditText register_input_phone;
    /**
     * 注册姓名
     */
    private EditText register_input_name;
    /**
     * 注册账号
     */
    private EditText register_input_account;
    /**
     * 注册密码
     */
    private EditText register_input_password;
    /**
     * 重复密码
     */
    private EditText repeat_input_password;
    /**
     * 清空注册账户
     */
    private ImageView register_clear_account;
    /**
     * 清空注册密码
     */
    private ImageView register_clear_password;
    /**
     * 清空重复密码
     */
    private ImageView repeat_clear_password;
    /**
     * 清空姓名
     */
    private ImageView register_clear_name;
    /**
     * 清空电话号
     */
    private ImageView register_clear_phone;
    /**
     * 注册完成
     */
    private TextView main_register;
    /**
     * 注册接口初始化
     */
    private IRegisterPresenter presenter;
    /**
     * 性别单选组
     */
    private RadioGroup sex_group;
    /**
     * 性别
     */
    private String sexString = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Montior();
    }

    private void Montior() {
        register_back = findViewById(R.id.register_back);
        register_input_account = findViewById(R.id.register_input_account);
        register_input_password = findViewById(R.id.register_input_password);
        repeat_input_password = findViewById(R.id.repeat_input_password);
        register_clear_account = findViewById(R.id.register_clear_account);
        register_clear_password = findViewById(R.id.register_clear_password);
        repeat_clear_password = findViewById(R.id.repeat_clear_password);
        main_register = findViewById(R.id.main_register);
        register_input_phone = findViewById(R.id.register_input_phone);
        register_input_name = findViewById(R.id.register_input_name);
        register_clear_phone = findViewById(R.id.register_clear_phone);
        register_clear_name = findViewById(R.id.register_clear_name);
        sex_group = findViewById(R.id.sex_group);

        register_clear_account.setOnClickListener(this);
        register_clear_password.setOnClickListener(this);
        repeat_clear_password.setOnClickListener(this);
        register_back.setOnClickListener(this);
        main_register.setOnClickListener(this);
        register_clear_name.setOnClickListener(this);
        register_clear_phone.setOnClickListener(this);
        sex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                /*
                * 获取选择的性别
                * */
                RadioButton sex = findViewById(i);
                sexString = sex.getText().toString();
            }
        });

        if (presenter == null) {
            presenter = new RegisterPresenterCompl(this);
        }
        ClearEditText.clearEditText(register_input_account, register_clear_account);
        ClearEditText.clearEditText(register_input_password, register_clear_password);
        ClearEditText.clearEditText(repeat_input_password, repeat_clear_password);
        ClearEditText.clearEditText(register_input_name, register_clear_name);
        ClearEditText.clearEditText(register_input_phone, register_clear_phone);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                /*
                * 返回
                * */
                if (presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.doBack();
                break;
            case R.id.register_clear_account:
                /*
                * 清除
                * */
                ClearEditText.clear(register_input_account);
                break;
            case R.id.register_clear_password:
                /*
                * 清除
                * */
                ClearEditText.clear(register_input_password);
                break;
            case R.id.repeat_clear_password:
                /*
                * 清除
                * */
                ClearEditText.clear(repeat_input_password);
                break;
            case R.id.register_clear_phone:
                /*
                * 清除
                * */
                ClearEditText.clear(register_input_phone);
                break;
            case R.id.register_clear_name:
                /*
                * 清除
                * */
                ClearEditText.clear(register_input_name);
                break;
            case R.id.main_register:
                /*
                * 注册
                * */
                if (presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.doRegister(register_input_name.getText().toString(),register_input_account.getText().toString()
                        ,register_input_password.getText().toString(),sexString,register_input_phone.getText().toString());
                break;
        }
    }
}

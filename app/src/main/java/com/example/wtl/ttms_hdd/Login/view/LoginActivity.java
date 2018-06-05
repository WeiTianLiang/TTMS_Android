package com.example.wtl.ttms_hdd.Login.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.HDDMain.view.Activity.MainActivity;
import com.example.wtl.ttms_hdd.Login.presenter.ILoginPresenter;
import com.example.wtl.ttms_hdd.Login.presenter.LoginPresenterCompl;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Register.view.RegisterActivity;

/**
 * 登陆界面实现
 * Created by WTL on 2018/6/4.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * 监护账户输入
     */
    private EditText input_account;
    /**
     * 监护密码输入
     */
    private EditText input_password;
    /**
     * 主登陆
     */
    private TextView main_login;
    /**
     * 忘记密码
     */
    private TextView forgot_password;
    /**
     * 注册
     */
    private TextView toregister;
    /**
     * 实例化ILoginPresenter接口
     */
    private ILoginPresenter compl;
    /**
     * 清空account
     */
    private ImageView clear_account;
    /**
     * 清空password
     */
    private ImageView clear_password;
    /**
     * 显示验证码
     */
    private ImageView get_validate;
    /**
     * 输入验证码
     */
    private EditText input_validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Montior();
        if(compl==null) {compl = new LoginPresenterCompl(this);}
        compl.addTextEdit(input_account,clear_account);
        compl.addTextEdit(input_password,clear_password);
        compl.showValidate(get_validate);
    }

    /**
    * 连接界面
    * */
    private void Montior() {
        input_account = findViewById(R.id.input_account);
        input_password = findViewById(R.id.input_password);
        main_login = findViewById(R.id.main_login);
        forgot_password = findViewById(R.id.forgot_password);
        toregister = findViewById(R.id.toregister);
        clear_account = findViewById(R.id.clear_account);
        clear_password = findViewById(R.id.clear_password);
        get_validate = findViewById(R.id.get_validate);
        input_validate = findViewById(R.id.input_validate);

        main_login.setOnClickListener(this);
        forgot_password.setOnClickListener(this);
        toregister.setOnClickListener(this);
        clear_account.setOnClickListener(this);
        clear_password.setOnClickListener(this);
        get_validate.setOnClickListener(this);
        input_validate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_login:
                /*
                * 处理登陆
                * */
//                if(compl==null) {compl = new LoginPresenterCompl(this);}
//                compl.doLogin(input_account.getText().toString(),input_password.getText().toString()
//                        ,input_validate.getText().toString());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);


                break;
            case R.id.forgot_password:
                /*
                * 处理忘记密码
                * */
                break;
            case R.id.toregister:
                /*
                * 处理注册
                * */
                if(compl==null) {compl = new LoginPresenterCompl(this);}
                compl.doRegister();
                break;
            case R.id.clear_account:
                /*
                * 清空账号
                * */
                if(compl==null) {compl = new LoginPresenterCompl(this);}
                compl.clear(input_account);
                break;
            case R.id.clear_password:
                /*
                * 清空密码
                * */
                if(compl==null) {compl = new LoginPresenterCompl(this);}
                compl.clear(input_password);
                break;
        }
    }

}

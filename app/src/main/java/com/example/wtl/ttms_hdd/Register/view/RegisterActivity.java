package com.example.wtl.ttms_hdd.Register.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Register.presenter.IRegisterPresenter;
import com.example.wtl.ttms_hdd.Register.presenter.RegisterPresenterCompl;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    /**
    * 返回
    * */
    private ImageView register_back;
    /**
     * 注册账号
     * */
    private EditText register_input_account;
    /**
     * 注册密码
     * */
    private EditText register_input_password;
    /**
     * 重复密码
     * */
    private EditText repeat_input_password;
    /**
     * 输入验证码
     * */
    private EditText input_validate;
    /**
     * 发送验证码
     * */
    private Button send_validate;
    /**
     * 清空注册账户
     * */
    private ImageView register_clear_account;
    /**
     * 清空注册密码
     * */
    private ImageView register_clear_password;
    /**
     * 清空重复密码
     * */
    private ImageView repeat_clear_password;
    /**
    * 注册完成
    * */
    private TextView main_register;
    /**
     * 注册接口初始化
     * */
    private IRegisterPresenter presenter;

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
        input_validate = findViewById(R.id.input_validate);
        send_validate = findViewById(R.id.send_validate);
        register_clear_account = findViewById(R.id.register_clear_account);
        register_clear_password = findViewById(R.id.register_clear_password);
        repeat_clear_password = findViewById(R.id.repeat_clear_password);
        main_register = findViewById(R.id.main_register);

        register_clear_account.setOnClickListener(this);
        register_clear_password.setOnClickListener(this);
        repeat_clear_password.setOnClickListener(this);
        send_validate.setOnClickListener(this);
        register_back.setOnClickListener(this);
        main_register.setOnClickListener(this);

        if(presenter == null) {presenter = new RegisterPresenterCompl(this);}
        presenter.registerAddTextEdit(register_input_account,register_clear_account);
        presenter.registerAddTextEdit(register_input_password,register_clear_password);
        presenter.registerAddTextEdit(repeat_input_password,repeat_clear_password);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.activity_right_out,R.anim.activity_right_in);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                /*
                * 返回
                * */
                if(presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.doBack();
                break;
            case R.id.register_clear_account:
                /*
                * 清除
                * */
                if(presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.registerClear(register_input_account);
                break;
            case R.id.register_clear_password:
                /*
                * 清除
                * */
                if(presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.registerClear(register_input_password);
                break;
            case R.id.repeat_clear_password:
                /*
                * 清除
                * */
                if(presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.registerClear(repeat_input_password);
                break;
            case R.id.send_validate:
                /*
                * 发送验证码
                * */
                break;
            case R.id.main_register:
                /*
                * 注册
                * */
                if(presenter == null) {
                    presenter = new RegisterPresenterCompl(this);
                }
                presenter.doBack();
                break;
        }
    }
}

package com.example.wtl.ttms_hdd.ChangePassword.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.ttms_hdd.ChangePassword.presenter.ChangePassPresenterCompl;
import com.example.wtl.ttms_hdd.ChangePassword.presenter.IChangePassPresenter;
import com.example.wtl.ttms_hdd.R;
import com.example.wtl.ttms_hdd.Tool.ClearEditText;

public class ChangePassActivity extends AppCompatActivity implements View.OnClickListener{

    /**
    * 修改按钮
    * */
    private TextView main_change;
    /**
    * 返回
    * */
    private ImageView register_back;
    /**
    * 账户输入
    * */
    private EditText change_input_account;
    /**
     * 密码输入
     * */
    private EditText change_input_password;
    /**
     * 密码重复输入
     * */
    private EditText change_re_password;
    /**
     * 账号
     * 清空
     * */
    private ImageView change_clear_account;
    /**
     * 密码
     * 清空
     * */
    private ImageView change_clear_password;
    /**
     * 重复密码
     * 清空
     * */
    private ImageView change_rec_password;

    private IChangePassPresenter passPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        passPresenter = new ChangePassPresenterCompl(this);
        Montior();
    }

    private void Montior() {
        main_change = findViewById(R.id.main_change);
        register_back = findViewById(R.id.register_back);
        change_input_account = findViewById(R.id.change_input_account);
        change_input_password = findViewById(R.id.change_input_password);
        change_re_password = findViewById(R.id.change_re_password);
        change_clear_account = findViewById(R.id.change_clear_account);
        change_clear_password = findViewById(R.id.change_clear_password);
        change_rec_password = findViewById(R.id.change_rec_password);

        main_change.setOnClickListener(this);
        register_back.setOnClickListener(this);
        change_clear_account.setOnClickListener(this);
        change_clear_password.setOnClickListener(this);
        change_rec_password.setOnClickListener(this);

        ClearEditText.clearEditText(change_input_account,change_clear_account);
        ClearEditText.clearEditText(change_input_password,change_clear_password);
        ClearEditText.clearEditText(change_re_password,change_rec_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_change:
                /*
                * 修改
                * */
                if(passPresenter==null) {
                    passPresenter = new ChangePassPresenterCompl(this);
                }
                passPresenter.doChange(change_input_account.getText().toString(),change_input_password.getText().toString());
                break;
            case R.id.register_back:
                /*
                * 返回
                * */
                finish();
                overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
                break;
            case R.id.change_clear_account:
                /*
                * 清空账号
                * */
                ClearEditText.clear(change_input_account);
                break;
            case R.id.change_clear_password:
                /*
                * 清空密码
                * */
                ClearEditText.clear(change_input_password);
                break;
            case R.id.change_rec_password:
                /*
                * 清空重复密码
                * */
                ClearEditText.clear(change_re_password);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.activity_right_out, R.anim.activity_right_in);
        return super.onKeyDown(keyCode, event);
    }
}

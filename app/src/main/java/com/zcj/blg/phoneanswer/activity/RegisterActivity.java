package com.zcj.blg.phoneanswer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zcj.blg.phoneanswer.R;
import com.zcj.blg.phoneanswer.bean.User;
import com.zcj.blg.phoneanswer.util.SharePreferencTools;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText etusername;
    private EditText etpassword;
    private EditText etemail;
    private EditText eticon;
    private Button register;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {

        etusername = (EditText) findViewById(R.id.et_username);
        etpassword = (EditText) findViewById(R.id.et_password);
        etemail = (EditText) findViewById(R.id.et_email);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                registerData();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

    /**
     * 注册
     */
    private void registerData() {

        final String name = etusername.getText().toString();
        final String password = etpassword.getText().toString();
        final String email = etemail.getText().toString();
        User bu = new User();
        bu.setUsername(name);
        bu.setPassword(password);
        bu.setUserNick("user_" + name);
        bu.setEmail(email);
        //注意：不能用save方法进行注册
        bu.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Toast.makeText(RegisterActivity.this, "手机答题系统欢迎你" + user.getUsername(), Toast.LENGTH_LONG).show();
                    MainActivity.startMainActivity(RegisterActivity.this, user.getUsername());
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
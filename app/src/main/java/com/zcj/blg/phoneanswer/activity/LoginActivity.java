package com.zcj.blg.phoneanswer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zcj.blg.phoneanswer.R;
import com.zcj.blg.phoneanswer.bean.User;
import com.zcj.blg.phoneanswer.util.SharePreferencTools;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class LoginActivity extends Activity implements View.OnClickListener {


    private static final String TAG = LoginActivity.class.getName();
    private EditText etusername;
    private EditText etpassword;
    private Button login;
    private Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //这里的AppLication ID 写上自己创建项目得到的那个AppLication ID
        BmobUser user = BmobUser.getCurrentUser(User.class);
        if (user == null) {
            initialize();
        } else {
            MainActivity.startMainActivity(this, user.getUsername());
            finish();
        }
    }

    private void initialize() {
        etusername = (EditText) findViewById(R.id.et_username);
        etpassword = (EditText) findViewById(R.id.et_password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        sign = (Button) findViewById(R.id.sign);
        sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                final String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    BmobUser bmobUser = new BmobUser();
                    bmobUser.setUsername(username);
                    bmobUser.setPassword(password);

                    bmobUser.login(new SaveListener<BmobUser>() {

                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if (e == null) {
                                User user = BmobUser.getCurrentUser(User.class);
                                MainActivity.startMainActivity(LoginActivity.this, user.getUsername());
                                //登录成功
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Log.d(TAG, "done: " + e);
                            }
                        }

                    });
                }
                break;
            case R.id.sign:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }
}


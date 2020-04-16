package com.lightning.demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lightning.demo.R;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置启动页面的主题
        setTheme(R.style.splashLauncher);
        setContentView(R.layout.activity_splash);

        initView();
    }


    public void initView() {
        if (canAutoLogin()) {
            //登录到主界面
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    /**
     * 判断是否可以自动登录
     */
    public boolean canAutoLogin() {
        return true;
    }
}

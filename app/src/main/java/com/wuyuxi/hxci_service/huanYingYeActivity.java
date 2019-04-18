package com.wuyuxi.hxci_service;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class huanYingYeActivity extends AppCompatActivity {
    //设置时间为2000
    private static  final int time=2000;
    //创建Handler对象
    private Handler mHander=new Handler(){

        public  void handleMessage(Message msg)
        {

            goHome();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huan_ying_ye);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //状态栏透明
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        //启动线程
        mHander.sendEmptyMessageDelayed(0,time);
    }
    private  void goHome()
    {

        Intent intent=new Intent(huanYingYeActivity.this,MainActivity.class);
        startActivity(intent);
        //结束该页面
        this.finish();

    }
}

package com.example.wzes.delimover;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by WZES on 2016/10/26.
 * 每次从StartActivity启动
 */

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        //子线程，加载广告
        new Thread() {
            public void run() {
                try {
                    //加钱才可以调低！
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                Message msg = hand.obtainMessage();
                hand.sendMessage(msg);
            }

        }.start();

    }
    Handler hand = new Handler() {
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            //首次登陆加载引导界面，进入引导的Activity
            if (isFristRun()) {
                Intent intent = new Intent(StartActivity.this,
                        GuideActivity.class);
                startActivity(intent);
            }
            //否则直接到主界面，进入主Activity
            else {
                Intent intent = new Intent(StartActivity.this,

                        MainActivity.class);
               startActivity(intent);
            }
            finish();
        }
    };
    /*
    * 从本地读取文件判断是否是首次登陆
    */
    private boolean isFristRun() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "share", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!isFirstRun) {
            return false;
        } else {
            editor.putBoolean("isFirstRun", false);
            editor.commit();
            return true;
        }
    }

}

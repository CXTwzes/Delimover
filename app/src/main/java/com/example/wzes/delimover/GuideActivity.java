package com.example.wzes.delimover;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.wzes.adapter.ViewPagerAdapter;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        /*viewPager容器用来装多个fragment*/
        mViewPager = (ViewPager) findViewById(R.id.activity_guide_viewpager);
        ViewPagerAdapter myAdapter = new ViewPagerAdapter(
            this.getSupportFragmentManager(), GuideActivity.this);
        mViewPager.setAdapter(myAdapter);
    }

    protected void onStop() {
        finish();
        super.onStop();
    }
    /*返回按钮*/
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        }
        return true;
    }
}

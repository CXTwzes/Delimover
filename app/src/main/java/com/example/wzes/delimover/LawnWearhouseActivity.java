package com.example.wzes.delimover;


import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZES on 2016/10/26.
 */

public class LawnWearhouseActivity extends ActivityGroup {
    private LinearLayout mMyWarehouseLeftBtn, mMyWarehouseRightBtn;

    private Button mMyWarehouseBackBtn;

    private List<View> list = new ArrayList<View>();
    private View view = null;
    private View view1 = null;

    private ViewPager mViewPager;

    private PagerAdapter pagerAdapter = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lawn_warehouse_fragment);
        initView();
        mMyWarehouseBackBtn = (Button) findViewById(R.id.activityLawnWarehouseFragment1BackBtn);
        mMyWarehouseBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // 初始化控件
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.lawnWarehouseViewPager);

        mMyWarehouseLeftBtn = (LinearLayout) findViewById(R.id.activityLawnWarehouseFragment1);
        mMyWarehouseRightBtn = (LinearLayout) findViewById(R.id.activityLawnWarehouseFragment2);


        createView();

        pagerAdapter = new PagerAdapter() {
            /*必须重写四个方法*/
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
            public int getCount() {
                return list.size();
            }
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(list.get(position));
            }
            public Object instantiateItem(ViewGroup container, int position) {
                View v = list.get(position);
                container.addView(v);
                return v;
            }
        };
        // 设置我们的adapter
        mViewPager.setAdapter(pagerAdapter);

        // 设置viewpager界面切换监听,监听viewpager切换第几个界面以及滑动的
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // arg0 获取 viewpager里面的界面切换到第几个的
            @Override
            public void onPageSelected(int arg0) {
                // 先清除按钮样式
                initBottemBtn();
                // 按照对应的view的tag来判断到底切换到哪个界面。
                // 更改对应的button状态
                int flag = (Integer) list.get((arg0)).getTag();
                if (flag == 0) {

                   // mMyLawnLeftGgTxt.setTextColor(Color.parseColor("#FF8C00"));
                } else if (flag == 1) {

                    //mMyLawnLeftWhTxt.setTextColor(Color.parseColor("#FF8C00"));
                }
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    // 把viewpager里面要显示的view实例化出来，并且把相关的view添加到一个list当中
    private void createView(){
        view = this
                .getLocalActivityManager()
                .startActivity("WhF1",
                               new Intent(LawnWearhouseActivity.this, WarehouseFm1Activity.class))
                .getDecorView();
        view.setTag(1);
        list.add(view);

        view1 = this
                .getLocalActivityManager()
                .startActivity("WhF2",
                        new Intent(LawnWearhouseActivity.this, WarehouseFm2Activity.class))
                .getDecorView();
        view1.setTag(0);
        list.add(view1);

    }

    private void initBottemBtn() {
    }

}

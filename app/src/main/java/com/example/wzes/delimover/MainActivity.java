package com.example.wzes.delimover;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityGroup {
    private LinearLayout mMyBottemNearBtn, mMyBottemGrowBtn,
            mMyBottemFindBtn, mMyBottemMyBtn;
    private ImageView mMyBottemNearImg, mMyBottemGrowImg,
            mMyBottemFindImg, mMyBottemMyImg;
    private TextView mMyBottemNearTxt, mMyBottemGrowTxt, mMyBottemFindTxt,
            mMyBottemMyTxt;
    private List<View> list = new ArrayList<View>();
    private View view = null;
    private View view1 = null;
    private View view2 = null;
    private View view3 = null;
    private android.support.v4.view.ViewPager mViewPager;
    private int item ;

    private PagerAdapter pagerAdapter = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        item = intent.getIntExtra("item",0);
        initView();
    }

    // 初始化控件
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.FramePager);

        mMyBottemNearBtn = (LinearLayout) findViewById(R.id.MyBottemNearBtn);
        mMyBottemGrowBtn = (LinearLayout) findViewById(R.id.MyBottemGrowBtn);
        mMyBottemFindBtn = (LinearLayout) findViewById(R.id.MyBottemFindBtn);
        mMyBottemMyBtn = (LinearLayout) findViewById(R.id.MyBottemMyBtn);
        // 查找linearlayout中的imageview
        mMyBottemNearImg = (ImageView) findViewById(R.id.MyBottemNearImg);
        mMyBottemGrowImg = (ImageView) findViewById(R.id.MyBottemGrowImg);
        mMyBottemFindImg = (ImageView) findViewById(R.id.MyBottemFindImg);
        mMyBottemMyImg = (ImageView) findViewById(R.id.MyBottemMyImg);
        // 查找linearlayout中的textview
        mMyBottemNearTxt = (TextView) findViewById(R.id.MyBottemNearTxt);
        mMyBottemGrowTxt = (TextView) findViewById(R.id.MyBottemGrowTxt);
        mMyBottemFindTxt = (TextView) findViewById(R.id.MyBottemFindTxt);
        mMyBottemMyTxt = (TextView) findViewById(R.id.MyBottemMyTxt);
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

        MyBtnOnclick mytouchlistener = new MyBtnOnclick();

        mMyBottemNearBtn.setOnClickListener(mytouchlistener);
        mMyBottemGrowBtn.setOnClickListener(mytouchlistener);
        mMyBottemFindBtn.setOnClickListener(mytouchlistener);
        mMyBottemMyBtn.setOnClickListener(mytouchlistener);

        mViewPager.setCurrentItem(item);
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
                    mMyBottemNearImg
                            .setImageResource(R.drawable.main_index_grow_pressed);
                    mMyBottemNearTxt.setTextColor(Color.parseColor("#FF8C00"));
                } else if (flag == 1) {
                    mMyBottemGrowImg
                            .setImageResource(R.drawable.main_index_near_pressed);
                    mMyBottemGrowTxt.setTextColor(Color.parseColor("#FF8C00"));
                } else if (flag == 2) {
                    mMyBottemFindImg
                            .setImageResource(R.drawable.main_index_find_pressed);
                    mMyBottemFindTxt.setTextColor(Color
                            .parseColor("#FF8C00"));
                } else if (flag == 3) {
                    mMyBottemMyImg
                            .setImageResource(R.drawable.main_index_my_pressed);
                    mMyBottemMyTxt.setTextColor(Color.parseColor("#FF8C00"));
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
                .startActivity("select",
                               new Intent(MainActivity.this, SelectActivity.class))
                .getDecorView();
        view.setTag(0);
        list.add(view);

        view1 = this
                .getLocalActivityManager()
                .startActivity("growGrass",
                        new Intent(MainActivity.this, LawnActivity.class))
                .getDecorView();
        view1.setTag(1);
        list.add(view1);
        view2 = this
                .getLocalActivityManager()
                .startActivity("find",
                        new Intent(MainActivity.this, FindActivity.class))
                .getDecorView();
        view2.setTag(2);
        list.add(view2);
        view3 = this
                .getLocalActivityManager()
                .startActivity("my",
                        new Intent(MainActivity.this, MyActivity.class))
                .getDecorView();
        view3.setTag(3);
        list.add(view3);


    }

    /**
     * 用linearlayout作为按钮的监听事件
     * */
    private class MyBtnOnclick implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            int mBtnid = arg0.getId();
            switch (mBtnid) {
                case R.id.MyBottemNearBtn:
                    // //设置viewpager跳转那个界面0这个参数和我们的list相关,相当于list里面的下标
                    mViewPager.setCurrentItem(0);
                    initBottemBtn();
                    mMyBottemNearImg
                            .setImageResource(R.drawable.main_index_grow_pressed);
                    mMyBottemNearTxt.setTextColor(Color.parseColor("#FF8C00"));
                    break;
                case R.id.MyBottemGrowBtn:
                    mViewPager.setCurrentItem(1);
                    initBottemBtn();
                    mMyBottemGrowImg
                            .setImageResource(R.drawable.main_index_near_pressed);
                    mMyBottemGrowTxt.setTextColor(Color.parseColor("#FF8C00"));
                    break;
                case R.id.MyBottemFindBtn:
                    mViewPager.setCurrentItem(2);
                    initBottemBtn();
                    mMyBottemFindImg
                            .setImageResource(R.drawable.main_index_find_pressed);
                    mMyBottemFindTxt.setTextColor(Color.parseColor("#FF8C00"));
                    break;
                case R.id.MyBottemMyBtn:
                    mViewPager.setCurrentItem(3);
                    initBottemBtn();
                    mMyBottemMyImg
                            .setImageResource(R.drawable.main_index_my_pressed);
                    mMyBottemMyTxt.setTextColor(Color.parseColor("#FF8C00"));
                    break;
            }

        }

    }

    /**
     * 初始化控件的颜色
     * */
    private void initBottemBtn() {
        mMyBottemNearImg.setImageResource(R.drawable.main_index_grow_normal);
        mMyBottemGrowImg.setImageResource(R.drawable.main_index_near_normal);
        mMyBottemFindImg.setImageResource(R.drawable.main_index_find_normal);
        mMyBottemMyImg.setImageResource(R.drawable.main_index_my_normal);

        mMyBottemNearTxt.setTextColor(getResources().getColor(
                R.color.cardview_shadow_start_color));
        mMyBottemGrowTxt.setTextColor(getResources().getColor(
                R.color.cardview_shadow_start_color));
        mMyBottemFindTxt.setTextColor(getResources().getColor(
                R.color.cardview_shadow_start_color));
        mMyBottemMyTxt.setTextColor(getResources().getColor(
                R.color.cardview_shadow_start_color));

    }

    /**
     * 返回按钮的监听，用来询问用户是否退出程序
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示");
                builder.setMessage("你确定要退出吗？");

                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                            arg0.cancel();
                        } else if (arg1 == DialogInterface.BUTTON_NEGATIVE) {
                            MainActivity.this.finish();
                        }
                    }
                };
                builder.setPositiveButton("取消", dialog);
                builder.setNegativeButton("确定", dialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        }
        return false;
    }

}

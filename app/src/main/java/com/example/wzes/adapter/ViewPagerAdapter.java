package com.example.wzes.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wzes.fragment.MyFragmentFour;
import com.example.wzes.fragment.MyFragmentOne;
import com.example.wzes.fragment.MyFragmentThree;
import com.example.wzes.fragment.MyFragmentTwo;

/*引导的四个fragment ViewPager容器*/
public class ViewPagerAdapter extends FragmentPagerAdapter {

	private Context ctx;

	public ViewPagerAdapter(FragmentManager fm, Context ctx) {
		super(fm);
		this.ctx = ctx;
	}
    /*自动加载，根据你滑到第几个界面*/
	public Fragment getItem(int arg0) {
		Fragment mFragment = null;
		if (arg0 == 0) {
			mFragment = new MyFragmentOne(ctx);
		} else if (arg0 == 1) {
			mFragment = new MyFragmentTwo(ctx);
		} else if (arg0 == 2) {
			mFragment = new MyFragmentThree(ctx);
		} else if (arg0 == 3) {
			mFragment = new MyFragmentFour(ctx);
		}
		return mFragment;
	}
	/*容器大小*/
	public int getCount() {
		return 4;
	}

}

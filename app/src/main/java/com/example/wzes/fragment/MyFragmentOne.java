package com.example.wzes.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wzes.delimover.R;


public class MyFragmentOne extends Fragment {

	private Context ctx;

	public MyFragmentOne(Context ctx) {
		super();
		this.ctx = ctx;
	}
	/*重写onCreateView方法*/
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = null;
		/*加载第一个引导页面*/
		view = View.inflate(ctx,
				R.layout.framgent_start1, null);
		return view;
	}

}

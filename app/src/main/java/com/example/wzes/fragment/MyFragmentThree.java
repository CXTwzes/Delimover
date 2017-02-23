package com.example.wzes.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wzes.delimover.R;

public class MyFragmentThree extends Fragment {

	private Context ctx;

	public MyFragmentThree(Context ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = null;
		/*加载第三个引导页面*/
		view = View.inflate(ctx, R
				.layout.framgent_start3, null);
		return view;
	}

}

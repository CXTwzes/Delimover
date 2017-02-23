package com.example.wzes.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wzes.delimover.R;


@SuppressLint("ValidFragment")
public class MyFragmentTwo extends Fragment {

	private Context ctx;

	public MyFragmentTwo(Context ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = null;
		/*加载第二个引导页面*/
		view = View.inflate(ctx, R.layout.framgent_start2, null);
		return view;
	}

}

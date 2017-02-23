package com.example.wzes.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.wzes.delimover.MainActivity;
import com.example.wzes.delimover.R;

public class MyFragmentFour extends Fragment {

	private Context ctx;

	public MyFragmentFour(Context ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = null;
		/*加载第四个引导页面*/
		view = View.inflate(ctx, R.layout.framgent_start4, null);
		/*点击进入按钮*/
		Button mBtn = (Button) view.findViewById(R.id.start_btn);
		mBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				/*跳转到主界面*/
				Intent intent = new Intent(ctx, MainActivity.class);
				ctx.startActivity(intent);

			}
		});
		return view;
	}
}

package com.example.wzes.delimover;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by WZES on 2016/10/31.
 */

public class FindInfoActivity extends Activity{
    private Button backBtn, shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_his_info);
        init();
    }
    public void init(){
        backBtn = (Button) findViewById(R.id.findDetailHisBackBtn);
        shareBtn = (Button) findViewById(R.id.findDetailHisShareBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "分享成功", Toast.LENGTH_LONG);
            }
        });

    }
}

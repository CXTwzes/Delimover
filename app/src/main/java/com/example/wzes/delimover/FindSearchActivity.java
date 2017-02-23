package com.example.wzes.delimover;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.platform.comapi.map.A;

/**
 * Created by WZES on 2016/11/1.
 */

public class FindSearchActivity extends Activity {
    private Button searchBtn, backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_search);
        init();
    }
    public void init(){
        searchBtn = (Button) findViewById(R.id.findDetailSearchBtn);
        backBtn = (Button) findViewById(R.id.findDetailSearchBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

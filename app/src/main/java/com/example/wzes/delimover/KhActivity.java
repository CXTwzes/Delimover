package com.example.wzes.delimover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by WZES on 2016/10/30.
 */

public class KhActivity extends Activity{
    private Button mBackBtn, mFinishBtn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn_growgrass);
        init();
    }
    public void init(){
        mBackBtn = (Button) findViewById(R.id.lawnGrowgrassKhBackBtn);
        mFinishBtn = (Button) findViewById(R.id.LawnGrowgrassKhFinishBtn);
        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "保存成功",Toast.LENGTH_SHORT);

                startActivity(new Intent(KhActivity.this, MainActivity.class));
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}

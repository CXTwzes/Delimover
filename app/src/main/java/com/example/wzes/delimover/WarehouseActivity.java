package com.example.wzes.delimover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by WZES on 2016/10/30.
 */
public class WarehouseActivity extends Activity{
    private ImageView imageView;
    private Button mWarehouseBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn_warehouse);
        imageView = (ImageView) findViewById(R.id.lawnMyGrass);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WarehouseActivity.this, LawnWearhouseActivity.class));
            }
        });
        mWarehouseBtn = (Button) findViewById(R.id.lawnMywarehouse);
        mWarehouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WarehouseActivity.this, WarehouseCommentActivity.class));
            }
        });
    }
}

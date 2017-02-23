package com.example.wzes.delimover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by WZES on 2016/11/1.
 */

public class WarehouseCommentActivity extends Activity{
    private ImageView goodGrassImagview;
    private Button  backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn_warehouse_comment);
        backBtn = (Button) findViewById(R.id.lawnWarehouseCommentBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        goodGrassImagview = (ImageView) findViewById(R.id.lawnWarehouseGoodGrass);
        goodGrassImagview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WarehouseCommentActivity.this, LawnWearhouseActivity.class));
            }
        });
    }
}

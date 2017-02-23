package com.example.wzes.delimover;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by WZES on 2016/10/26.
 */

import android.app.Activity;
import view.ArcMenu;


public class LawnActivity extends Activity {

    private ArcMenu mArcMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn);
        initView();


        mArcMenu.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener()
        {
            @Override
            public void onClick(View view, int pos)
            {
                switch (pos){
                    //仓库
                    case 1:
                        startActivity(new Intent(LawnActivity.this,
                                FriendsActivity.class));
                        break;
                    //好友
                    case 2:
                        startActivity(new Intent(LawnActivity.this,
                                KhActivity.class));
                        break;
                }
            }
        });
    }

    private void initView()
    {
        mArcMenu = (ArcMenu) findViewById(R.id.id_menu);
    }

}



package com.example.wzes.delimover;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WZES on 2016/11/1.
 */

public class WarehouseFm2Activity extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn_warehouse_fragment2);
        init();


    }
    public void init(){
        listView = (ListView) findViewById(R.id.lawnWarehouseFragment2List);
        ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
        for(int i = 0; i<20;i++){
            Map<String, Object> item = new HashMap<String, Object>();

            if( i%2 == 0){
                item.put("Icon",R.drawable.kaoya);
                mData.add(item);
            }else {
                item.put("Icon",R.drawable.qiu);
                mData.add(item);
            }

        }
        SimpleAdapter adapter= new SimpleAdapter(this, mData, R.layout.activity_find_show_food,new String[]{"Icon"},
                new int[]{ R.id.findDetailFragmentShowFoodImageView});


        listView.setAdapter(adapter);
    }
}

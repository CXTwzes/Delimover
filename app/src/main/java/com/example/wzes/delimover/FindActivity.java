package com.example.wzes.delimover;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.wzes.chat.ChatActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by WZES on 2016/10/26.
 */

public class FindActivity extends Activity {
    //private ListView listViewFindLeft;
//            listViewFindRight;
    private PullToRefreshListView pullToListView;
    //private GridView gridView = null;
    private ArrayList<Map<String, Object>> mData;
    private Button mapBtn;
    private Button searchBtn;
    private SimpleAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        init();
    }
    private class GetListDataTaskDown extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            return "这是刷新后的数据";
        }

        @Override
        protected void onPostExecute(String result) {

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("Icon",R.drawable.kaoya);
            mData.add(0, item);

            //mDatas.add(0 , result);
            mAdapter.notifyDataSetChanged();
            pullToListView.onRefreshComplete();
        }
    }

    private class GetListDataTaskUp extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            return "这是刷新后的数据";
        }

        @Override
        protected void onPostExecute(String result) {

            Map<String, Object> item = new HashMap<String, Object>();
            item.put("Icon",R.drawable.kaoya);
            mData.add(item);
            mAdapter.notifyDataSetChanged();
            pullToListView.onRefreshComplete();
        }
    }
    public void init(){
        pullToListView = (PullToRefreshListView) findViewById(R.id.find_pullListView);
        searchBtn = (Button) findViewById(R.id.findDetailsFindBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindActivity.this, FindSearchActivity.class));
            }
        });
        mapBtn = (Button) findViewById(R.id.find_details_near_btn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindActivity.this, FindMapActivity.class));
            }
        });
        mData = new ArrayList<Map<String, Object>>();

        for(int i = 0; i<5;i++){
            Map<String, Object> item = new HashMap<String, Object>();

            item.put("Icon",R.drawable.nice_selector);
            mData.add(item);

        }
        mAdapter= new SimpleAdapter(this, mData, R.layout.activity_find_show_food,new String[]{"Icon"},
                new int[]{ R.id.findDetailFragmentShowFoodImageView});


        pullToListView.setAdapter(mAdapter);
        //上拉加载
        pullToListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new FindActivity.GetListDataTaskDown().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new FindActivity.GetListDataTaskUp().execute();
            }
        });


        pullToListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(FindActivity.this, FindInfoActivity.class));
            }
        });

    }
}
package com.example.wzes.delimover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.wzes.chat.ChatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WZES on 2016/10/30.
 */
public class FriendsActivity extends Activity {
    private ListView listViewFriends;

    //private Button wareHouseBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawn_friends_list);
        init();
    }
    public void init(){
       /* wareHouseBtn = (Button) findViewById(R.id.activityLawnChatInBtn);
        wareHouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(FriendsActivity.this, WarehouseActivity.class));
            }
        });*/

        listViewFriends = (ListView) findViewById(R.id.lawnFriendsList);
        ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

        for(int i = 0; i<20;i++){
            Map<String, Object> item = new HashMap<String, Object>();

            item.put("Icon",R.drawable.touxiang);
            item.put("id", "好友 "+ String.valueOf(i+1));
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, mData, R.layout.friends_info,new String[]{"Icon","id"},
                new int[]{ R.id.friendsIcon, R.id.friendsId });
        listViewFriends.setAdapter(adapter);

        listViewFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(FriendsActivity.this, ChatActivity.class));
            }
        });
    }

}

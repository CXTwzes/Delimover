package com.example.wzes.delimover;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;

public class SelectActivity extends Activity {
    ///////////////////////////////////////////////////////////////////////
    String[] titles = { "No.1", "No.2", "No.3", "No.4", "No.5", "No.6", "No.7" };
    int[] resIds = { R.drawable.nice_list_img, R.drawable.nice_list_img, R.drawable.nice_list_img,
            R.drawable.nice_list_img, R.drawable.nice_list_img,
            R.drawable.nice_list_img, R.drawable.nice_list_img };
    ///////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ///////////////////////////////////////////////////////////////////
        ListView listView = (ListView) findViewById(R.id.list_view_activity_select);
        listView.setAdapter(new ListViewAdapter(titles, resIds));
        ///////////////////////////////////////////////////////////////////
    }

    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(String[] itemTitles, int[] itemImageRes) {
            itemViews = new View[itemTitles.length];

            for (int i = 0; i < itemViews.length; i++) {
                itemViews[i] = makeItemView(itemTitles[i], itemImageRes[i]);
            }
        }

        public int getCount() {
            return itemViews.length;
        }

        public View getItem(int position) {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String strTitle, int resId) {
            LayoutInflater inflater = (LayoutInflater) SelectActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.nice_listitem, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView) itemView.findViewById(R.id.title);
            title.setText(strTitle);
            ImageView image = (ImageView) itemView.findViewById(R.id.img);
            image.setImageResource(resId);

            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }

    //On click of the menu image
    public void menuOnClick(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    //On click of the search image
    public void searchOnClick(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}

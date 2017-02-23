package com.example.wzes.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wzes.delimover.R;

import java.util.List;

/**
 * Created by WZES on 2016/10/11.
 */
public class ChatMessageAdapter extends BaseAdapter {
    private LayoutInflater mInflater;   //存放listview

    private List<ChatMessage> mDatas;

    public ChatMessageAdapter(Context context, List<ChatMessage> datas)
    {
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
    }


    public int getCount()
    {
        return mDatas.size();
    }


    public Object getItem(int position)
    {
        return mDatas.get(position);
    }


    public long getItemId(int position)
    {
        return position;
    }

    /**
     * 接受到消息为1，发送消息为0
     */

    public int getItemViewType(int position)
    {
        ChatMessage msg = mDatas.get(position);
        return msg.getType() == ChatMessage.Type.INPUT ? 1 : 0;
    }


    public int getViewTypeCount()
    {
        return 2;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ChatMessage chatMessage = mDatas.get(position);

        ViewHolder viewHolder = null;

        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            if (chatMessage.getType() == ChatMessage.Type.INPUT)
            {
                convertView = mInflater.inflate(R.layout.chat_friends,
                        null);

                viewHolder.createDate = (TextView) convertView
                        .findViewById(R.id.chat_from_createDate);
                viewHolder.content = (TextView) convertView
                        .findViewById(R.id.chat_from_content);
                convertView.setTag(viewHolder);
            } else
            {
                convertView = mInflater.inflate(R.layout.chat_my,
                        parent, false);
                viewHolder.createDate = (TextView) convertView
                        .findViewById(R.id.chat_to_createDate);
                viewHolder.content = (TextView) convertView
                        .findViewById(R.id.chat_to_content);
                convertView.setTag(viewHolder);

            }

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.content.setText(chatMessage.getMsg());
        viewHolder.createDate.setText(chatMessage.getDateStr());

        return convertView;
    }

    private class ViewHolder {
        public TextView createDate;
        public TextView name;
        public TextView content;
    }


}

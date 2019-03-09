package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapterMessage extends BaseAdapter {
    private List<ItemBeanMessage> list;

    public ListAdapterMessage(List<ItemBeanMessage> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ;imageResId
//        ;username
//        ;content
//        ;time
        return null;
    }
    class ViewHolder{
        ImageView portrait;
        TextView username;
        TextView content;
        TextView time;
    }
}

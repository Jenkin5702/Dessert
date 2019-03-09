package com.example.myapplication;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapterFavor extends BaseAdapter {
    private List<ItemBeanFavor> list;
    private LayoutInflater inflater;

    public ListAdapterFavor(List<ItemBeanFavor> list, Context context) {
        this.list = list;
        this.inflater=LayoutInflater.from(context);
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
       ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_homepage,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.portrait =convertView.findViewById(R.id.imageView3);
            viewHolder.image=convertView.findViewById(R.id.imageView4);
            viewHolder.username=convertView.findViewById(R.id.textView);
            viewHolder.time=convertView.findViewById(R.id.textView2);
            viewHolder.intro=convertView.findViewById(R.id.textView3);
            viewHolder.title=convertView.findViewById(R.id.textView4);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ItemBeanFavor itemBeanFavor=list.get(position);
        viewHolder.username.setText(itemBeanFavor.username);
        viewHolder.intro.setText(itemBeanFavor.intro);
        viewHolder.title.setText(itemBeanFavor.title);
        return convertView;
    }

    class ViewHolder{
        ImageView portrait;
        ImageView image;
        TextView time;
        TextView username;
        TextView intro;
        TextView title;
    }
}

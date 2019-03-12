package com.example.myapplication;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapterHomepage extends BaseAdapter {
    private List<ItemBeanHomepage> list;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapterHomepage(List<ItemBeanHomepage> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
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
        if (convertView == null || convertView.getTag()==null) {
            convertView = inflater.inflate(R.layout.item_homepage, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image = convertView.findViewById(R.id.imageView2);
            viewHolder.title = convertView.findViewById(R.id.textView5);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            View view=inflater.inflate(R.layout.header_homepage,parent,false);
            ViewPager vp=view.findViewById(R.id.vp_header);
            PagerAdapterHeader adapterHeader=new PagerAdapterHeader(context);
            vp.setAdapter(adapterHeader);
//            ImageView imageView = new ImageView(context);
//            imageView.setImageResource(R.drawable.bg);
            return view;
        } else {
            ItemBeanHomepage itemBeanHomepage = list.get(position-1);
            viewHolder.title.setText(itemBeanHomepage.title);
            viewHolder.image.setImageResource(itemBeanHomepage.imageRes);
            return convertView;
        }
    }

    class ViewHolder {
        ImageView image;
        TextView title;
    }
}

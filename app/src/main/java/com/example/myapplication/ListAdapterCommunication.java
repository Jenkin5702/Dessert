package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ListAdapterCommunication extends BaseAdapter {
    private List<ItemBeanCommunication> list;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapterCommunication(List<ItemBeanCommunication> list, Context context) {
        this.list = list;
        this.context=context;
        inflater= LayoutInflater.from(context);
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_communication,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.portrait =convertView.findViewById(R.id.imageView3);
            viewHolder.image=convertView.findViewById(R.id.imageView4);
            viewHolder.username=convertView.findViewById(R.id.textView);
            viewHolder.time=convertView.findViewById(R.id.textView2);
            viewHolder.intro=convertView.findViewById(R.id.textView3);
            viewHolder.title=convertView.findViewById(R.id.textView4);
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ActivityNewPicture.class);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ItemBeanCommunication itemBeanCommunication=list.get(position);
        viewHolder.portrait.setImageBitmap(BitmapFactory.decodeResource(parent.getResources(), itemBeanCommunication.portraitRes));
        viewHolder.image.setImageBitmap(BitmapFactory.decodeResource(parent.getResources(), itemBeanCommunication.imageResId));
        viewHolder.time.setText(itemBeanCommunication.time);
        viewHolder.username.setText(itemBeanCommunication.username);
        viewHolder.intro.setText(itemBeanCommunication.intro);
        viewHolder.title.setText(itemBeanCommunication.title);
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

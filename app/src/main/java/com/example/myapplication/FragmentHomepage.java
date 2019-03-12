package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class FragmentHomepage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_homepage,container,false);
        ListView lvHomepage=view.findViewById(R.id.lv_homepage);
        List<ItemBeanHomepage> list=new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new ItemBeanHomepage(R.drawable.ss,"这是视频或文章的标题-----"+i));
        }
        ListAdapterHomepage adapterHomepage=new ListAdapterHomepage(list,getContext());
        lvHomepage.setAdapter(adapterHomepage);
        return view;
    }
}

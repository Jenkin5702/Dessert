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

public class FragmentHomepage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_homepage,container,false);
        ListView lvHomepage=view.findViewById(R.id.lv_homepage);
        ViewPager vpHomepage=view.findViewById(R.id.viewPager);
        SearchView searchView=view.findViewById(R.id.searchView);
        return view;
    }
}

package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

public class ActivitySearch extends AppCompatActivity {
    Toolbar tbSearch;
    SearchView svSearch;
    ListView lvSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tbSearch=findViewById(R.id.toolbar_search);
        svSearch=findViewById(R.id.searchView2);
        lvSearch=findViewById(R.id.lv_search);
        tbSearch.setTitle("搜索");
        setSupportActionBar(tbSearch);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbSearch.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

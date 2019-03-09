package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

public class ActivityFavor extends AppCompatActivity {
    Toolbar tbFavor;
    ListView lvFavor;
    TabLayout tabFavor;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_favor);
        tbFavor=findViewById(R.id.toolbar_favor);
        tbFavor.setTitle("收藏");
        tbFavor.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(tbFavor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvFavor=findViewById(R.id.lv_favor);
        tabFavor=findViewById(R.id.tab_favor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}

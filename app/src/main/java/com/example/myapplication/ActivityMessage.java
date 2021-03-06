package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;


public class ActivityMessage extends AppCompatActivity {
    Toolbar tbMessage;
    TabLayout tabMessage;
    ListView lvMessage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        tbMessage=findViewById(R.id.toolbar_message);
        tbMessage.setTitle("消息");
        setSupportActionBar(tbMessage);
        tabMessage=findViewById(R.id.tab_message);
        lvMessage=findViewById(R.id.lv_message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbMessage.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

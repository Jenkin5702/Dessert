package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class ActivitySetting extends AppCompatActivity {
    ListView lvSetting;
    Toolbar toolbarSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbarSetting=findViewById(R.id.toolbar_setting);
        toolbarSetting.setTitle("设置");
        setSupportActionBar(toolbarSetting);
        lvSetting=findViewById(R.id.lv_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarSetting.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

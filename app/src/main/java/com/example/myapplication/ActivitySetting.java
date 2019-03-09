package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class ActivitySetting extends AppCompatActivity {
    ListView lvSetting;
    Toolbar toolbarSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setSupportActionBar(toolbarSetting);
        lvSetting=findViewById(R.id.lv_setting);
        toolbarSetting=findViewById(R.id.toolbar_setting);
    }
}

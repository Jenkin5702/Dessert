package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySignin extends AppCompatActivity {
    EditText etPhone;
    EditText etIdentify;
    Button btnSignin;
    Button btnGetid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        etPhone=findViewById(R.id.et_phone);
        etIdentify=findViewById(R.id.et_identify);
        btnSignin=findViewById(R.id.btn_signin);
        btnGetid=findViewById(R.id.btn_getid);
    }
}

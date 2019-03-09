package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.vitamio.widget.VideoView;

public class ContentVideo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_video);
        Uri uri=Uri.parse("http://www.modrails.com/videos/passenger_nginx.mov");
        VideoView videoView=findViewById(R.id.video);
        videoView.setVideoURI(uri);
    }
}

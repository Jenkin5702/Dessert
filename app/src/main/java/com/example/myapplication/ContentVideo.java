package com.example.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;


public class ContentVideo extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;

    private Button play;
    private Button pause;
    private Button replay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_video);
        videoView = findViewById(R.id.video);

        Toolbar tbVideo=findViewById(R.id.toolbar_video);
        tbVideo.setTitle("trailer");
        setSupportActionBar(tbVideo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbVideo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        play = findViewById(R.id.button);
        pause = findViewById(R.id.button2);
        replay = findViewById(R.id.button3);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);

        play.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.INVISIBLE);
        replay.setVisibility(View.INVISIBLE);

        initVideoPath();//初始化
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("tag", "准备完毕,可以播放了");
                Toast.makeText(ContentVideo.this,"视频加载完成",Toast.LENGTH_SHORT).show();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.i("tag", "播放完毕");
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("tag", "播放失败");
                Toast.makeText(ContentVideo.this,"播放失败",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initVideoPath() {
        /*媒体控制面版常用方法：MediaController:
         hide();     隐藏MediaController;
         show();     显示MediaController
         show(int timeout);设置MediaController显示的时间，以毫秒计算，如果设置为0则一直到调用hide()时隐藏；
         */
        videoView.setMediaController(new MediaController(this));//这样就有滑动条了
//        File file = new File(Environment.getExternalStorageDirectory(),"valentine Video/Valentine_Sakura.mp4");
//        videoView.setVideoPath(file.getAbsolutePath()); // 指定视频文件的路径
        videoView.setVideoURI(Uri.parse("https://media.w3.org/2010/05/sintel/trailer.mp4"));//播放网络视频
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (!videoView.isPlaying()) {
                    videoView.start(); // 开始播放
                }
                break;
            case R.id.button2:
                if (videoView.isPlaying()) {
                    videoView.pause(); // 暂时播放
                }
                break;
            case R.id.button3: //重新指定资源开始播放
                if (videoView.isPlaying()) {
                    //videoView.resume(); // 重新播放,无效
                    videoView.pause();//暂停
                    videoView.stopPlayback();//停止播放,释放资源
                    videoView.start();//开始播放,可以不在准备监听中播放
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}

package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;

public class Upload extends AsyncTask<String,Void,String> {
    private File file;
    private Context context;
    Upload(File file, Context context){
        this.file = file;
        this.context=context;
    }
    @Override
    protected String doInBackground(String... strings) {
        return ImageUploader.uploadFile(file,strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s != null){
            Toast.makeText(context,"上传成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"上传失败",Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.myapplication;

public class ItemBeanMessage {
    int imageResId;

    public ItemBeanMessage(int imageResId, String username, String content, String time) {
        this.imageResId = imageResId;
        this.username = username;
        this.content = content;
        this.time = time;
    }

    String username;
    String content;
    String time;
}

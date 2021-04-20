package com.example.witsly;


import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");


    public String title, body, uid, date;
    public int vote;


    Post() {
    }

    public Post(String title, String body, String uid) {

        this.title = title;
        this.body = body;
        this.uid = uid;
        date = ISO_8601_FORMAT.format(new Date());
        vote = 0;
    }

    public String getUid() {
        return uid;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public int getVote() {
        return vote;
    }
}

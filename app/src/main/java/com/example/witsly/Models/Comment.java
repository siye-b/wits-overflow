package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    private String comment, uid, aid, date;

    @SuppressLint("SimpleDateFormat")
    private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

    public Comment(String comment, String uid, String aid){
        this.comment = comment;
        this.aid = aid;
        this.uid = uid;
        date = ISO_8601_FORMAT.format(new Date());
    }

    public String getComment(){return comment;}

    public String getUID(){return uid;}

    public String getAID(){return aid;}

    public String getDate(){return date;}

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setUID(String uid){
         this.uid = uid;
    }

    public void setAID(String aid){
        this.aid = aid;
    }

    public void setDate(String date){
        this.date = date;
    }

}

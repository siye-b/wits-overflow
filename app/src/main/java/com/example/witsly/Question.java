package com.example.witsly;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Question {
    int vote;
    public String question, uid, date, answer;


    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");


    Question() {

    }


    public Question(String question, String answer, String uid) {
        this.question = question;
        this.answer = answer;
        this.uid = uid;
        date = ISO_8601_FORMAT.format(new Date());
        vote = 0;

    }
}

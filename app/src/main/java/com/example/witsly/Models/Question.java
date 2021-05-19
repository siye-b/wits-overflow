package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

class Question {
  private int vote;
  private String question, uid, date, answer;

  @SuppressLint("SimpleDateFormat")
  private final SimpleDateFormat ISO_8601_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

  Question() {}

  Question(final String question, final String answer, final String uid) {
    this.question = question;
    this.answer = answer;
    this.uid = uid;
    date = ISO_8601_FORMAT.format(new Date());
    vote = 0;
  }
}

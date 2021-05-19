package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
  public String answer, uid, qid, date;

  @SuppressLint("SimpleDateFormat")
  private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

  Comment() {}

  public Comment(String answer, String uid, String qid) {
    this.answer = answer;
    this.uid = uid;
    this.qid = qid;
    date = ISO_8601_FORMAT.format(new Date());
  }

  public String getUID() {
    return uid;
  }

  public String getQID() {
    return qid;
  }

  public String getAnswer() {
    return answer;
  }

  public String getDate() {
    return date;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setQid(String qid) {
    this.qid = qid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }
}

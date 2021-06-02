package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer {
  private String answer, uid, qid, date, aid;
  private Boolean correct;

  @SuppressLint("SimpleDateFormat")
  private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

  Answer() {}

  public Answer(String answer, String uid, String qid) {
    this.answer = answer;
    this.uid = uid;
    this.qid = qid;
    date = ISO_8601_FORMAT.format(new Date());
    correct = false;
  }

  public Answer(String answer, String uid, String qid, String aid) {
    this.answer = answer;
    this.uid = uid;
    this.qid = qid;
    this.aid = aid;
    date = ISO_8601_FORMAT.format(new Date());
    correct = false;
  }

  public boolean isCorrect() {
    return correct;
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

  public String getAid(){return aid;}

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

  public void setAid(String aid) {this.aid = aid;}
}

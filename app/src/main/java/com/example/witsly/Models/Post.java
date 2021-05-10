package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Post {

  @SuppressLint("SimpleDateFormat")
  SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

  public String title, body, uid, date, postID;
  public int vote;

  Post() {}

  public static Comparator<Post> VoteComparator = (o1, o2) -> o2.getVote() - o1.getVote();

  public Post(final String title, final String body, final String uid) {

    this.title = title;
    this.body = body;
    this.uid = uid;
    date = ISO_8601_FORMAT.format(new Date());
    vote = 0;
  }

  public Post(final String title, final String body, final String uid, final String postID) {

    this.title = title;
    this.body = body;
    this.uid = uid;
    this.postID = postID;
    date = ISO_8601_FORMAT.format(new Date());
    vote = 0;
  }

  public String getDate() {
    return date;
  }

  public String getBody() {
    return body;
  }

  public String getTitle() {
    return title;
  }

  public String getUid() {
    return uid;
  }

  public String getPostID() {
    return postID;
  }

  public void setPostID(final String postID) {
    this.postID = postID;
  }

  public int getVote() {
    return vote;
  }
}

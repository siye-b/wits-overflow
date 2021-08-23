package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PostTest {
  String TITLE = "title";
  String BODY = "body";
  String UID = "uid";
  String TAG = "tag";
  String PID = "pid";
  String TOPIC = "topic";

  private Post post;
  private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

  @Before
  public void testConstructorWithAllParams() {
    post = new Post(TITLE, BODY, TAG, UID, PID, TOPIC);
  }

  @Test
  public void testConstructorWithParams() {
    post = new Post(TITLE, BODY, TAG, UID, TOPIC);
  }

  @Test
  public void testConstructorWithNOParams() {
    post = new Post();
  }

  @Test
  public void getTITLE() {
    assertEquals(TITLE, post.getTitle());
  }

  @Test
  public void getUID() {
    assertEquals(UID, post.getUID());
  }

  @Test
  public void getPID() {
    assertEquals(PID, post.getPID());
  }

  @Test
  public void getTOPIC() {
    assertEquals(TOPIC, post.getTopic());
  }

  @Test
  public void setTOPIC() {
    String NEW_TOPIC = "topic";
    post.setUID(NEW_TOPIC);
    assertEquals(NEW_TOPIC, post.getTopic());
  }

  @Test
  public void setUID() {
    String NEW_UID = "uid1";
    post.setUID(NEW_UID);
    assertEquals(NEW_UID, post.getUID());
  }

  @Test
  public void setDATE() {
    String NEW_DATE = ISO_8601_FORMAT.format(new Date()).substring(0, 10);
    post.setDate(NEW_DATE);
    assertEquals(NEW_DATE, post.getDate());
  }
}

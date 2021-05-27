package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnswerTest {

  private Answer comment;

  @Before
  public void buildObject() {
    comment = new Answer("answer", "uid", "qid");
  }

  @Test
  public void testConstructorWithParams() {
    new Answer("", "", "");
  }

  @Test
  public void getUID() {
    assertEquals("uid", comment.getUID());
  }

  @Test
  public void getQID() {
    assertEquals("qid", comment.getQID());
  }

  @Test
  public void getAnswer() {
    assertEquals("answer", comment.getAnswer());
  }

  @Test
  public void getDate() {
    assertNotNull(comment.getDate());
  }

  /*  @Test
  public void setAnswer() {
  }

  @Test
  public void setDate() {
  }

  @Test
  public void setQid() {
  }

  @Test
  public void setUid() {
  }*/
}

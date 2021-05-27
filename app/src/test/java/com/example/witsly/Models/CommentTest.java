package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    private Comment comment;

    @Before
    public void buildObject(){
        comment = new Comment("answer", "uid", "qid");
    }

    @Test
    public void testConstructorWithParams() {
        new Comment("", "", "");
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
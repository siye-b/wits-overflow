package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentTest {
    private Comment comment;

    @Before
    public void buildObject() {comment = new Comment("comment", "uid", "aid", "cid");}

    @Test
    public void testConstructorWithParams() {
        new Comment("", "", "");
    }

    @Test
    public void getComment(){assertEquals("comment", comment.getComment());}

    @Test
    public void getUID(){assertEquals("uid", comment.getUID());}

    @Test
    public void getAID(){assertEquals("aid", comment.getAID());}

    @Test
    public void getCID(){assertNotNull("cid", comment.getCID());}

    @Test
    public void getDate(){assertNotNull(comment.getDate());}


}

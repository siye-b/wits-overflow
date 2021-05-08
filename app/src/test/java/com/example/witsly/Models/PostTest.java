package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {

    private Post post;

    @Before
    public void buildObject(){
        post = new Post("title", "body", "uid");
    }

    @Test
    public void testConstructorWithParams(){
        new Post("", "", "");
    }

    @Test
    public void testConstructorWithNoParams(){
        new Post();
    }

    @Test
    public void getDate() {
        assertNotNull(post.getDate());
    }

    @Test
    public void getBody() {
        assertEquals("body", post.getBody());
    }

    @Test
    public void getTitle() {
        assertEquals("title", post.getTitle());
    }

    @Test
    public void getUid() {
        assertEquals("uid", post.getUid());
    }

    @Test
    public void getVote() {
        assertEquals(0, post.getVote());
    }
}
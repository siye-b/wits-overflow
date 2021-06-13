package com.example.witsly.Models;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagTest{
    String TAG = "tag";
    String TagID = "tagId";

    private Tag tag;

    @Before
    public void testConstructorWithAllParams() {
        tag = new Tag(TAG , TagID);

    }
    @Test
    public void testConstructorWithParams() {
        tag = new Tag(TAG);
    }

    @Test
    public void testConstructorWithNOParams() {
        tag = new Tag();
    }

    @Test
    public void getTAG() {
        assertEquals(TAG , tag.getTag());
    }

    @Test
    public void getTAGId() {
        assertEquals(TagID , tag.getTagID());
    }

    @Test
    public void setTAG() {
        String NEW_TAG = "tag1";
        tag.setTag(NEW_TAG);
        assertEquals(NEW_TAG, tag.getTag());
    }

    @Test
    public void setTagID() {
        String NEW_TAGId = "tagId1";
        tag.setTagID(NEW_TAGId);
        assertEquals(NEW_TAGId, tag.getTagID());
    }
}
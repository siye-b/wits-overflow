package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostTest {
	String TITLE = "title";
	String BODY = "body";
	String UID = "uid";
	String TAG = "tag";
	String PID = "pid";

	private Post post;

	@Before
	public void testConstructorWithAllParams() {
		post = new Post(TITLE, BODY, TAG, UID, PID);

	}

	@Test
	public void testConstructorWithParams() {
		post = new Post(TITLE, BODY, TAG, UID);
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
	public void setUID() {
		String NEW_UID = "uid1";
		post.setUID(NEW_UID);
		assertEquals(NEW_UID, post.getUID());
	}

}
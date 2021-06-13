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
	Boolean SOLVED = false;
	int VOTE = 0;

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
		assertEquals(UID, post.getUid());
	}

	@Test
	public void getPid() {
		assertEquals(PID, post.getPID());
	}

	@Test
	public void getTAG() {
		assertEquals(TAG, post.getTag());
	}

	@Test
	public void getBODY() {
		assertEquals(BODY, post.getBody());
	}

	@Test
	public void getVOTE() {
		assertEquals(VOTE, post.getVote());
	}

	@Test
	public void isSOLVED() {
		assertEquals(SOLVED, post.isSolved());
	}

	@Test
	public void setTITLE() {
		String NEW_TITLE = "title1";
		post.setTitle(NEW_TITLE);
		assertEquals(NEW_TITLE, post.getTitle());
	}

	@Test
	public void setUID() {
		String NEW_UID = "uid1";
		post.setUid(NEW_UID);
		assertEquals(NEW_UID, post.getUid());
	}

	@Test
	public void setPid() {
		String NEW_PID = "pid1";
		post.setPostID(NEW_PID);
		assertEquals(NEW_PID, post.getPID());
	}

	@Test
	public void setTAG() {
		String NEW_TAG = "tag1";
		post.setTag(NEW_TAG);
		assertEquals(NEW_TAG, post.getTag());
	}

	@Test
	public void setBODY() {
		String NEW_BODY = "body1";
		post.setBody(NEW_BODY);
		assertEquals(NEW_BODY, post.getBody());
	}

	@Test
	public void setVOTE() {
		int NEW_VOTE = 0;
		post.setVote(NEW_VOTE);
		assertEquals(NEW_VOTE, post.getVote());
	}

}
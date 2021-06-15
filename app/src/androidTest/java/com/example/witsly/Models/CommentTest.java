package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentTest {
	String COMMENT = "comment";
	String AID = "aid";
	String UID = "uid";
	String CID = "cid";

	private Comment comment;


	@Before
	public void testConstructorWithAllParams() {
		comment = new Comment(COMMENT, UID, AID, CID);

	}

	@Test
	public void testConstructorWithParams() {
		comment = new Comment(COMMENT, UID, AID);
	}

	@Test
	public void testConstructorWithNOParams() {
		comment = new Comment();
	}


	@Test
	public void getAID() {
		assertEquals(AID, comment.getAID());
	}


	@Test
	public void getUID() {
		assertEquals(UID, comment.getUID());
	}

	@Test
	public void getCID() {
		assertEquals(CID, comment.getCID());
	}


	@Test
	public void getComment() {
		assertEquals(COMMENT, comment.getComment());
	}

	@Test
	public void getDate() {
		assertNotNull(comment.getDate());
	}


	@Test
	public void setAID() {
		String NEW_AID = "aid1";
		comment.setAID(NEW_AID);
		assertEquals(NEW_AID, comment.getAID());
	}

	@Test
	public void setUID() {
		String NEW_UID = "uid1";
		comment.setUID(NEW_UID);
		assertEquals(NEW_UID, comment.getUID());
	}

	@Test
	public void setCID() {
		String NEW_CID = "cid1";
		comment.setCID(NEW_CID);
		assertEquals(NEW_CID, comment.getCID());
	}

	@Test
	public void setCOMMENT() {
		String NEW_COMMENT = "comment1";
		comment.setComment(NEW_COMMENT);
		assertEquals(NEW_COMMENT, comment.getComment());
	}


}
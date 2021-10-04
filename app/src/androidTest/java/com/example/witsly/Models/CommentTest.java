package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentTest {
	String COMMENT = "comment";
	String AID = "aid";
	String UID = "uid";
	String CID = "cid";

	private Comment comment;

	private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");


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

	@Test
	public void setDATE() {
		String NEW_DATE = ISO_8601_FORMAT.format(new Date()).substring(0, 10);
		comment.setDate(NEW_DATE);
		assertEquals(NEW_DATE, comment.getDate());
	}


}
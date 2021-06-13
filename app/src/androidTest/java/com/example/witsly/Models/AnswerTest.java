package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnswerTest {
	String ANSWER = "answer";
	String QID = "qid";
	String UID = "uid";
	String AID = "aid";
	Boolean correctANSWER = false;
	long voteCOUNT = 0;


	private Answer answer;

	@Before
	public void testConstructorWithAllParams() {
		answer = new Answer(ANSWER, UID, QID, AID);

	}

	@Test
	public void testConstructorWithParams() {
		answer = new Answer(ANSWER, UID, QID);
	}

	@Test
	public void testConstructorWithNOParams() {
		answer = new Answer();
	}


	@Test
	public void getAID() {
		assertEquals(AID, answer.getAID());
	}


	@Test
	public void getUID() {
		assertEquals(UID, answer.getUID());
	}

	@Test
	public void getQID() {
		assertEquals(QID, answer.getQID());
	}


	@Test
	public void getAnswer() {
		assertEquals(ANSWER, answer.getAnswer());
	}

	@Test
	public void getDate() {
		assertNotNull(answer.getDate());
	}

	@Test
	public void countVOTES() {
		assertEquals(voteCOUNT, answer.getVote());
	}

	@Test
	public void isCorrectANSWER() {
		assertEquals(correctANSWER, answer.isCorrect());
	}

	@Test
	public void setAID() {
		String NEW_AID = "aid1";
		answer.setAid(NEW_AID);
		assertEquals(NEW_AID, answer.getAID());
	}

	@Test
	public void setUID() {
		String NEW_UID = "uid1";
		answer.setUid(NEW_UID);
		assertEquals(NEW_UID, answer.getUID());
	}

	@Test
	public void setQID() {
		String NEW_QID = "qid1";
		answer.setQid(NEW_QID);
		assertEquals(NEW_QID, answer.getQID());
	}

	@Test
	public void setANSWER() {
		String NEW_ANSWER = "answer1";
		answer.setAnswer(NEW_ANSWER);
		assertEquals(NEW_ANSWER, answer.getAnswer());
	}

	@Test
	public void setDATE() {
		String NEW_DATE = "date1";
		answer.setDate(NEW_DATE);
		assertEquals(NEW_DATE, answer.getDate());
	}


}
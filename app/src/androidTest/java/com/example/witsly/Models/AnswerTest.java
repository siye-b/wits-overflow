package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnswerTest {
	String ANSWER = "answer";
	String PID = "pid";
	String UID = "uid";
	String AID = "aid";
	Boolean correctANSWER = false;
	long voteCOUNT = 0;


	private Answer answer;

	@Before
	public void testConstructorWithAllParams() {
		answer = new Answer(ANSWER, UID, PID, AID);

	}

	@Test
	public void testConstructorWithParams() {
		answer = new Answer(ANSWER, UID, PID);
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
		assertEquals(PID, answer.getPID());
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
		answer.setAID(NEW_AID);
		assertEquals(NEW_AID, answer.getAID());
	}

	@Test
	public void setUID() {
		String NEW_UID = "uid1";
		answer.setUID(NEW_UID);
		assertEquals(NEW_UID, answer.getUID());
	}

	@Test
	public void setPID() {
		String NEW_PID = "id1";
		answer.setPID(NEW_PID);
		assertEquals(NEW_PID, answer.getPID());
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
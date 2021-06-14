package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Answer {
	private String answer, uid, pid, date, aid;
	private Boolean correct;
	private long vote;

	@SuppressLint("SimpleDateFormat")
	private final SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

	Answer() {
	}

	public Answer(String answer, String uid, String pid) {
		this.answer = answer;
		this.uid = uid;
		this.pid = pid;
		vote = 0;
		date = ISO_8601_FORMAT.format(new Date());
		correct = false;
	}

	public static Comparator<Answer> VoteComparator = (o1, o2) -> (int) (o2.getVote() - o1.getVote());

	public Answer(String answer, String uid, String aid, String pid) {
		this.answer = answer;
		this.uid = uid;
		this.aid = aid;
		this.pid = pid;
		vote = 0;
		date = ISO_8601_FORMAT.format(new Date());
		correct = false;
	}

	public boolean isCorrect() {
		return correct;
	}

	public String getUID() {
		return uid;
	}

	public String getPID() {
		return pid;
	}

	public String getAnswer() {
		return answer;
	}

	public String getDate() {
		return date;
	}

	public String getAID() {
		return aid;
	}

	public long getVote() {
		return vote;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPID(String pid) {
		this.pid = pid;
	}

	public void setUID(String uid) {
		this.uid = uid;
	}

	public void setAID(String aid) {
		this.aid = aid;
	}
}

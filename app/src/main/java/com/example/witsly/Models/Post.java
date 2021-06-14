package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Post {

	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

	private String title, body, uid, date, pid, tag;
	private long vote;
	private Boolean solved;

	Post() {
	}

	public static Comparator<Post> VoteComparator = (o1, o2) -> (int) (o2.getVote() - o1.getVote());

	public Post(String title, String body, String tag, String uid) {

		this.title = title;
		this.body = body;
		this.uid = uid;
		this.tag = tag;
		date = ISO_8601_FORMAT.format(new Date());
		vote = 0;
		solved = false;
	}

	public Post(String title, String body, String tag, String uid, String pid) {

		this.title = title;
		this.body = body;
		this.uid = uid;
		this.tag = tag;
		this.pid = pid;
		date = ISO_8601_FORMAT.format(new Date());
		vote = 0;
		solved = false;
	}

	public String getDate() {
		return date.substring(0, 10);
	}


	public String getBody() {
		return body;
	}

	public String getTitle() {
		return title;
	}

	public String getTag() {
		return tag;
	}

	public String getUID() {
		return uid;
	}

	public String getPID() {
		return pid;
	}

	public void setPID(String pid) {
		this.pid = pid;
	}

	public long getVote() {
		return vote;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setUID(String uid) {
		this.uid = uid;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Boolean isSolved() {
		return solved;
	}

	public void setSolved(Boolean solved) {
		this.solved = solved;
	}
}

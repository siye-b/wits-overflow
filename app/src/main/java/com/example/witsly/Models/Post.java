package com.example.witsly.Models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Post {

	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

	private String title, body, uid, date, pid, tag, topic, reason;
	private long vote;
	private Boolean solved;

	Post() {
	}

	public static Comparator<Post> VoteComparator = (o1, o2) -> (int) (o2.getVote() - o1.getVote());

	public Post(String title, String body, String tag, String uid, String topic) {

		this.title = title;
		this.body = body;
		this.uid = uid;
		this.tag = tag;
		this.topic = topic;
		reason = "";
		date = ISO_8601_FORMAT.format(new Date());
		vote = 0;
		solved = false;
	}

	public Post(String title, String body, String tag, String uid, String pid, String topic) {

		this.title = title;
		this.body = body;
		this.uid = uid;
		this.tag = tag;
		reason = "";
		this.pid = pid;
		this.topic = topic;
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

	public String getTopic() {
		return topic;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

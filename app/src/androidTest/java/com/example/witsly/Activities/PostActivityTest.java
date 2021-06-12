package com.example.witsly.Activities;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class PostActivityTest {
	String TITLE = "What is Code-Based Testing?";
	String BODY = "Code-based testing corresponds to the testing that is carried out on code development, code inspection, unit testing in software development process";
	String CUSTOM_TAG = "New TAG for Testing";
	String EXISTING_TAG = "python";
	@Rule
	public ActivityScenarioRule<PostActivity> activityScenarioRule =
			new ActivityScenarioRule<>(PostActivity.class);


	@Test
	public void AddNewPostWithCustomTag() {
		activityScenarioRule
				.getScenario()
				.onActivity(
						activity -> {
							activity.title.getEditText().setText(TITLE);
							activity.body.getEditText().setText(BODY);
							activity.tagInput.getText().append(CUSTOM_TAG);
							// press the add post button

						});

	}

	@Test
	public void AddNewPostWithExitingTag() {
		activityScenarioRule
				.getScenario()
				.onActivity(
						activity -> {
							activity.title.getEditText().setText(TITLE);
							activity.body.getEditText().setText(BODY);
							activity.tagInput.getText().append(EXISTING_TAG);
							// press the add post button


						});

	}

}
package com.example.witsly.Activities;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsly.Activities.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

  private String EMAIL = "user@wits.ac.za";
  private String PASSWORD = "v-JU%wr75qTuTT@f";

  @Rule
  public ActivityScenarioRule<LoginActivity> activityScenarioRule =
      new ActivityScenarioRule<>(LoginActivity.class);

  @Test
  public void LoginUser() {
    activityScenarioRule
        .getScenario()
        .onActivity(
            activity -> {
              activity.loginEmail.getEditText().setText(EMAIL);
              activity.loginPassword.getEditText().setText(PASSWORD);
              activity.loginButton.performClick();
            });
  }
}

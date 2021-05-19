package com.example.witsly;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

  @Rule
  public ActivityScenarioRule<LoginActivity> activityScenarioRule =
      new ActivityScenarioRule<>(LoginActivity.class);

  @Test
  public void loginUser_correctCredentials_loginSuccess() {
    activityScenarioRule
        .getScenario()
        .onActivity(
            activity -> {
              activity.loginEmail.getEditText().setText("sfgdfgsd");
              activity.loginPassword.getEditText().setText("sfdfdf");
              activity.loginButton.performClick();
            });
  }
}

package com.example.witsly.Activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsly.R;

import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

  /*private String EMAIL = "user@wits.ac.za";
  private String PASSWORD = "v-JU%wr75qTuTT@f";*/
  private String EMAIL = "1871892@students.wits.ac.za";
  private String PASSWORD = "Umair123!";

  private String BAD_EMAIL = "user@gmail.com";
  private String BAD_PASSWORD = "imamirrorball";

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

  /* @Test
  public void bad_login() {
      activityScenarioRule
              .getScenario()
              .onActivity(
                      activity -> {
                          activity.loginEmail.getEditText().setText(BAD_EMAIL);
                          activity.loginPassword.getEditText().setText(BAD_PASSWORD);
                          activity.loginButton.performClick();
                      });
  }*/

  /*@Test
  public void create_account() {
    try {
      onView(withId(R.id.tv_password)).perform(click());
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }*/

  /*@Test
  public void forgot_password() {
    try {
      onView(withId(R.id.tv_register)).perform(click());
      onView(withId(R.id.register_act)).check(matches(isDisplayed()));
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }*/
}

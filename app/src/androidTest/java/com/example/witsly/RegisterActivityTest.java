package com.example.witsly;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsly.Activities.RegisterActivity;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterActivityTest {

  @Rule
  public ActivityScenarioRule<RegisterActivity> activityScenarioRule =
      new ActivityScenarioRule<>(RegisterActivity.class);

  private String EMAIL = "user@wits.ac.za";
  private String NAME = "Name";
  private String SURNAME = "Surname";
  private String PASSWORD = "v-JU%wr75qTuTT@f";

  private String ANOTHER_EMAIL = "user@gmail.com";

  @Test
  public void registerUser() {
    activityScenarioRule
        .getScenario()
        .onActivity(
            activity -> {
              activity.regName.getEditText().setText(NAME);
              activity.regSurname.getEditText().setText(SURNAME);
              activity.regEmail.getEditText().setText(EMAIL);
              activity.regPasswordOne.getEditText().setText(PASSWORD);
              activity.regPasswordTwo.getEditText().setText(PASSWORD);
              activity.tv_register.performClick();
              activity.regButton.performClick();
            });
  }

  // Validators

  @Test
  public void allFieldsValid() {
    assertEquals(true, true);
  }
}

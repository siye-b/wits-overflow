package com.example.witsly.Activities;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public class ViewProfileActivityTest {

  @Rule
  public ActivityScenarioRule<ViewProfileActivity> activityScenarioRule =
      new ActivityScenarioRule<>(ViewProfileActivity.class);

  /* @Test
  public void isvisible(){
      activityScenarioRule.getScenario().onActivity(
              activity -> {
                  Espresso.onView(withId(R.id.viewprofileactivity)).check(matches(isDisplayed()));
              }
      );
  }

  */

}

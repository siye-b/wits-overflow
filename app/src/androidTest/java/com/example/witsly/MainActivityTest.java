package com.example.witsly;

import android.view.MenuItem;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

  @Rule
  public ActivityScenarioRule<MainActivity> activityScenarioRule =
      new ActivityScenarioRule<>(MainActivity.class);

  @Test
  public void onNavigationItemSelected() {

    activityScenarioRule
        .getScenario()
        .onActivity(
            activity -> {
              final MenuItem homeItem = activity.navigationView.getMenu().getItem(0);
              activity.onNavigationItemSelected(homeItem);

              final MenuItem userItem = activity.navigationView.getMenu().getItem(1);
              activity.onNavigationItemSelected(userItem);

              final MenuItem logoutItem = activity.navigationView.getMenu().getItem(2);
              activity.onNavigationItemSelected(logoutItem);
            });
  }
}

package com.example.witsly.Activities;

import static org.junit.Assert.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;



import androidx.test.espresso.contrib.DrawerActions;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;

import com.android.dx.command.Main;
import com.example.witsly.Activities.LoginActivity;
import com.example.witsly.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class ViewProfileActivityTest {



    @Rule
    public ActivityScenarioRule<ViewProfileActivity> activityScenarioRule =
            new ActivityScenarioRule<>(ViewProfileActivity.class);

    @Test
    public void isvisible(){
        activityScenarioRule.getScenario().onActivity(
                activity -> {
                    Espresso.onView(withId(R.id.viewprofileactivity)).check(matches(isDisplayed()));
                }
        );
    }

}
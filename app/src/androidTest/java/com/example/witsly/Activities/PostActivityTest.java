package com.example.witsly.Activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsly.R;

import junit.framework.TestCase;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class PostActivityTest extends TestCase {


    public void test_isActivityInView() {
        ActivityScenario<PostActivity> activityScenario = ActivityScenario.launch(PostActivity.class);
        onView(withId(R.id.postA)).check(matches(isDisplayed()));
    }

    public void test_PostQuestionEdittext() {
        ActivityScenario<PostActivity> activityScenario = ActivityScenario.launch(PostActivity.class);
        onView(withId(R.id.textInputLayoutTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textInputLayoutBody)).check(matches(isDisplayed()));
        onView(withId(R.id.holder)).check(matches(isDisplayed()));
        onView(withId(R.id.topic_holder)).check(matches(isDisplayed()));

    }

}
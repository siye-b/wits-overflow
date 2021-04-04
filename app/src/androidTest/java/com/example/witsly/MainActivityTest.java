package com.example.witsly;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenario = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void clickRegister_currentActivityIsMainActivity_currentActivityIsRegister(){
        activityScenario.getScenario().onActivity(activity -> {
            activity.binding.tvRegister.performClick();
        });
    }

}
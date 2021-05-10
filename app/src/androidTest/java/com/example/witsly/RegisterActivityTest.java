package com.example.witsly;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterActivityTest {

    @Rule
    public ActivityScenarioRule<RegisterActivity> activityScenarioRule = new ActivityScenarioRule<>(RegisterActivity.class);

 /*   @Test
    public void registerUser_correctCredentials_loginSuccess(){
        activityScenarioRule.getScenario().onActivity(activity -> {
            activity.regName.getEditText().setText("sfgdfgsd");
            activity.regSurname.getEditText().setText("sfdfdf");
            activity.regEmail.getEditText().setText("sfdfdf");
            activity.regPasswordOne.getEditText().setText("sfdfdf");
            activity.regPasswordTwo.getEditText().setText("sfdfdf");
            activity.tv_register.performClick();
            activity.regButton.performClick();

        });
    }*/

}
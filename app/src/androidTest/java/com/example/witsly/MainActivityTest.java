package com.example.witsly;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void hello_noText_helloContainsHelloTxt(){
        scenarioRule.getScenario().onActivity(MainActivity::hello);
    }

}
package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AchievementTest {

    int IMG_RESOURCE = 1;
    String MTEXT1 = "mtext1";
    String MTEXT2 = "mtext2";
    boolean j = true;

    private Achievement achievement;

    @Before
    public void intialiseObject(){
        achievement = new Achievement(IMG_RESOURCE, MTEXT1, MTEXT2, j);
    }

    @Test
    public void getImgResource(){
        assertEquals(IMG_RESOURCE, achievement.getImageResource());
    }

    @Test
    public void getText1(){
        assertEquals(MTEXT1, achievement.getText1());
    }

    @Test
    public void getText2(){
        assertEquals(MTEXT2, achievement.getText2());
    }

    @Test
    public void getAchieved(){
        assertEquals(j, achievement.getAchieved());
    }

}
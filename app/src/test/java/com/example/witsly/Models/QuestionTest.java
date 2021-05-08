package com.example.witsly.Models;

import org.junit.Test;


public class QuestionTest {

    @Test
    public void testConstructorWithParams(){
        Question question = new Question("", "", "");
    }

    @Test
    public void testConstructorWithNoParams(){
        Question question = new Question();
    }
}
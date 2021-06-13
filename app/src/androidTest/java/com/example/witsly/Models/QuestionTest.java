package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuestionTest {
    String QUESTION = "question";
    String UID = "uid";
    String ANSWER = "answer";

    private Question question;

    @Before
    public void testConstructorWithAllParams() {
        question = new Question(QUESTION, UID, ANSWER);

    }

    @Test
    public void testConstructorWithNOParams() {
        question = new Question();
    }


}
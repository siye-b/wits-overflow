package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void buildObject(){
        user = new User("name","surname","email");
    }

    @Test
    public void getEmail() {
        assertEquals("email", user.getEmail());
    }

    @Test
    public void getSurname() {
        assertEquals("surname", user.getSurname());
    }

    @Test
    public void getName() {
        assertEquals("name",user.getName());
    }
}
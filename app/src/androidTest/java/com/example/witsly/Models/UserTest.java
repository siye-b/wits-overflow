package com.example.witsly.Models;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest{

    String NAME = "name";
    String SURNAME = "surname";
    String EMAIL = "email";
    String BIO = " bio";
    Boolean ADMIN = false;

    private User user;

    @Before
    public void testConstructorWithAllParams() {
        user = new User(NAME, SURNAME, EMAIL);

    }

    @Test
    public void getNAME() {
        assertEquals(NAME, user.getName());
    }

    @Test
    public void getSURNAME() {
        assertEquals(SURNAME, user.getSurname());
    }

    @Test
    public void getEMAIL() {
        assertEquals(EMAIL, user.getEmail());
    }

    @Test
    public void getBIO() { assertEquals(BIO, user.getBio()); }

    @Test
    public void setNAME() {
        String NEW_NAME = "name1";
        user.setName(NEW_NAME);
        assertEquals(NEW_NAME, user.getName());
    }

    @Test
    public void setSURNAME() {
        String NEW_SURNAME = "surname1";
        user.setSurname(NEW_SURNAME);
        assertEquals(NEW_SURNAME, user.getSurname());
    }

    @Test
    public void setEMAIL() {
        String NEW_EMAIL = "email1";
        user.setName(NEW_EMAIL);
        assertEquals(NEW_EMAIL, user.getName());
    }

    @Test
    public void isADMIN() {
        assertEquals(ADMIN, user.isAdmin());
    }

    @Test
    public void setADMIN() {
        Boolean NEW_ADMIN = false;
        user.setAdmin(NEW_ADMIN);
        assertEquals(NEW_ADMIN, user.isAdmin());
    }

    @Test
    public void setBIO() {
        String NEW_BIO = "new bio";
        user.setBio(NEW_BIO);
        assertEquals(NEW_BIO, user.getBio());
    }
}
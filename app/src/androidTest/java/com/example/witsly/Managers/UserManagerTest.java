package com.example.witsly.Managers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.witsly.Models.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserManagerTest {

  private static Context c = InstrumentationRegistry.getTargetContext();
  static User user = new User(UserManager.FIRST_NAME, UserManager.LAST_NAME, UserManager.EMAIL);

  @BeforeClass
  public static void setUp() {
    UserManager.userManager(c);
  }

  @Before
  public void setUser() {
    UserManager.setUser(user);
  }

  // Getters

  @Test
  public void getEmail() {
    assertEquals(user.getEmail(), UserManager.getEMAIL());
  }

  @Test
  public void getFirstName() {
    assertEquals(user.getName(), UserManager.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(user.getSurname(), UserManager.getLastName());
  }

  @Test
  public void getBIO() {
    assertEquals(user.getBio(), UserManager.getBIO());
  }

  /*@Test
  public void getReputation() {
    assertEquals(user.getReputation(), UserManager.getReputation());
  }*/

  @Test
  public void getProfileImage() {
    assertEquals(user.getImage(), UserManager.getProfileImage());
  }

  @Test
  public void isAdmin() {
    assertEquals(user.isAdmin(), UserManager.isAdmin());
  }

  @Test
  public void setProfileImage() {

    String str = anyString();
    UserManager.updateImage(str);
    user.setImage(str);
    assertEquals(user.getImage(), UserManager.getProfileImage());
  }

  @Test
  public void setFirstName() {
    String str = anyString();
    UserManager.setFirstName(str);
    user.setName(str);
    assertEquals(user.getName(), UserManager.getFirstName());
  }

  @Test
  public void setLastName() {
    String str = anyString();
    UserManager.setLastName(str);
    user.setSurname(str);
    assertEquals(user.getSurname(), UserManager.getLastName());
  }

  @Test
  public void setRep() {
    String str = anyString();
    UserManager.setReputation(str);
    user.setReputation(str);
    assertEquals(user.getReputation(), UserManager.getReputation());
  }

  @Test
  public void userLoggedIn() {
    assertEquals(UserManager.loggedIn(), true);
  }

  @Test
  public void userNotLoggedIn() {
    UserManager.logOut(c);
    assertEquals(UserManager.loggedIn(), false);
  }

  @Test
  public void LoggedOut() {
    UserManager.logOut(c);
    assertEquals("", UserManager.EMPTY_STRING);
  }
}

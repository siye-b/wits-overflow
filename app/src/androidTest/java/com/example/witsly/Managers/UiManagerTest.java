package com.example.witsly.Managers;

import android.content.Context;

import androidx.test.InstrumentationRegistry;

import org.junit.Test;

public class UiManagerTest {

  private static Context c = InstrumentationRegistry.getTargetContext();

  @Test
  public void logIn() {
    try {
      UiManager.logIn(c);

    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  @Test
  public void logOut() {}

  @Test
  public void uploadImage() {}

  @Test
  public void setImage() {}

  @Test
  public void setBio() {}

  @Test
  public void setProfile() {}

  @Test
  public void updateBio() {}
}

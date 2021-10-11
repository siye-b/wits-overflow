package com.example.witsly.Managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.witsly.Models.User;
import com.example.witsly.Utils.FirebaseUtils;
import com.example.witsly.Utils.UserUtils;

public class UserManager {

  static SharedPreferences SHARED_PREFERENCES = null;

  private static final String SHARED_PREFERENCES_NAME = "com.example.witsly.Managers";
  private static final String UID = "UserID";

  public static String LOGGED_IN = "Logged In";
  public static String IS_ADMIN = "Admin User";
  public static String EMPTY_STRING = "";

  public static String BIO = "Bio";
  public static String PROFILE_IMG_LINK = "Link";
  public static String FIRST_NAME = "First Name";
  public static String LAST_NAME = "Last Name";
  public static String REPUTATION = "Reputation";
  public static final String EMAIL = "holder@wits.ac.za";

  public static void userManager(Context context) {
    SHARED_PREFERENCES =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
  }

  public static void setUser(User user) {
    SHARED_PREFERENCES
        .edit()
        .putBoolean(LOGGED_IN, true)
        .putString(EMAIL, user.getEmail())
        .putString(FIRST_NAME, user.getName())
        .putString(LAST_NAME, user.getSurname())
        .putString(REPUTATION, user.getReputation())
        .putBoolean(IS_ADMIN, user.isAdmin())
        .putString(REPUTATION, user.getReputation())
        .putString(PROFILE_IMG_LINK, user.getImage())
        .putString(BIO, user.getBio())
        .apply();
  }

  public static boolean loggedIn() {
    return SHARED_PREFERENCES.getBoolean(LOGGED_IN, false);
  }

  public static void logOut(Context context) {
    if (SHARED_PREFERENCES == null) userManager(context);
    SHARED_PREFERENCES.edit().clear().apply();
  }

  public static boolean isAdmin() {
    return SHARED_PREFERENCES.getBoolean(IS_ADMIN, false);
  }

  public static void registerPref(
      Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
    SharedPreferences pref =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    pref.registerOnSharedPreferenceChangeListener(listener);
  }

  public static void UnRegisterPref(
      Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
    SharedPreferences pref =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    pref.unregisterOnSharedPreferenceChangeListener(listener);
  }

  // GETTERS

  public static String getReputation() {
    return SHARED_PREFERENCES.getString(REPUTATION, UserUtils.REPUTATION);
  }

  public static String getFirstName() {
    return SHARED_PREFERENCES.getString(FIRST_NAME, UserUtils.FIRST_NAME);
  }

  public static String getLastName() {
    return SHARED_PREFERENCES.getString(LAST_NAME, UserUtils.LAST_NAME);
  }

  public static String getEMAIL() {
    return SHARED_PREFERENCES.getString(EMAIL, FirebaseUtils.EMAIL);
  }

  public static String getBIO() {
    return SHARED_PREFERENCES.getString(BIO, FirebaseUtils.BIO);
  }

  public static String getProfileImage() {
    return SHARED_PREFERENCES.getString(PROFILE_IMG_LINK, UserUtils.IMG_LINK);
  }

  // SETTERS

  public static void updateImage(String link) {
    SHARED_PREFERENCES.edit().putString(PROFILE_IMG_LINK, link).apply();
  }

  public static void setBIO(String bio) {
    SHARED_PREFERENCES.edit().putString(BIO, bio).apply();
  }

  public static void setFirstName(String firstName) {
    SHARED_PREFERENCES.edit().putString(FIRST_NAME, firstName).apply();
  }

  public static void setLastName(String lastName) {
    SHARED_PREFERENCES.edit().putString(LAST_NAME, lastName).apply();
  }

  public static void setReputation(String reputation) {
    SHARED_PREFERENCES.edit().putString(REPUTATION, reputation).apply();
  }
}

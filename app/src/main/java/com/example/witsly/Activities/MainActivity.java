package com.example.witsly.Activities;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.witsly.Fragments.AchievementFragment;
import com.example.witsly.Fragments.HomeFragment;
import com.example.witsly.Fragments.MyFeedFragment;
import com.example.witsly.Fragments.ProfileFragment;
import com.example.witsly.Fragments.SettingsFragment;
import com.example.witsly.Fragments.SubscriptionFragment;
import com.example.witsly.Managers.UiManager;
import com.example.witsly.Managers.UserManager;
import com.example.witsly.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,
        SharedPreferences.OnSharedPreferenceChangeListener {

  private DrawerLayout drawerLayout;
  private TextView fullName, email, reputation, bio;
  private ImageView profileImage;
  private NavigationView navigationView;

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.tool_bar);
    UserManager.userManager(this);

    loadFragment(new HomeFragment());

    setSupportActionBar(toolbar);
    drawerLayout = findViewById(R.id.MainDrawer);

    ActionBarDrawerToggle actionDrawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
    drawerLayout.addDrawerListener(actionDrawerToggle);
    drawerLayout.setScrimColor(Color.WHITE);
    actionDrawerToggle.setDrawerIndicatorEnabled(true);
    actionDrawerToggle.syncState();

    navigationView = findViewById(R.id.navigationView);
    navigationView.setNavigationItemSelectedListener(this);
    View headerView = navigationView.getHeaderView(0);

    fullName = headerView.findViewById(R.id.headerFullName);
    email = headerView.findViewById(R.id.headerEmail);
    profileImage = headerView.findViewById(R.id.headerProfilePic);
    reputation = headerView.findViewById(R.id.headerReputation);
    bio = headerView.findViewById(R.id.headerBio);

    if (UserManager.loggedIn())
      UiManager.setProfile(this, fullName, email, reputation, bio, profileImage);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {

    drawerLayout.closeDrawer(GravityCompat.START);

    if (item.getItemId() == R.id.user_home) loadFragment(new HomeFragment());
    if (item.getItemId() == R.id.user_profile) loadFragment(new ProfileFragment());
    if (item.getItemId() == R.id.user_achievements) loadFragment(new AchievementFragment());
    if (item.getItemId() == R.id.user_feed) loadFragment(new MyFeedFragment());
    if (item.getItemId() == R.id.user_subscriptions) loadFragment(new SubscriptionFragment());
    if (item.getItemId() == R.id.user_settings) loadFragment(new SettingsFragment());
    if (item.getItemId() == R.id.user_logout) UiManager.logOut(this);
    return true;
  }

  private void loadFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction().replace(R.id.container_frag, fragment).commit();
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    if (key.equals(UserManager.PROFILE_IMG_LINK)) UiManager.setImage(this, profileImage);
    if (key.equals(UserManager.BIO)) UiManager.setBio(this, null, bio);
    if (key.equals(UserManager.FIRST_NAME) || key.equals(UserManager.LAST_NAME))
      UiManager.setFullName(this, fullName);
  }

  @Override
  protected void onStart() {
    super.onStart();
    UserManager.userManager(this);
    UserManager.registerPref(this, this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    UserManager.userManager(this);
    UserManager.UnRegisterPref(this, this);
  }
}

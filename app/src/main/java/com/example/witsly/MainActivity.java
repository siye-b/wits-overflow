package com.example.witsly;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.witsly.Fragments.HomeFragment;
import com.example.witsly.Fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private DrawerLayout drawerLayout;
  private FragmentManager fragmentManager;
  private FragmentTransaction fragmentTransaction;
  private TextView hFullName, hEmail;
  private ProDialog proDialog;
  public NavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    drawerLayout = findViewById(R.id.MainDrawer);

    Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);

    proDialog = new ProDialog(this);

    proDialog.start();

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();
    assert mUser != null;
    String user = mUser.getUid();

    navigationView = findViewById(R.id.navigationView);
    navigationView.setNavigationItemSelectedListener(this);
    View headerView = navigationView.getHeaderView(0);

    hFullName = headerView.findViewById(R.id.headerFullName);
    hEmail = headerView.findViewById(R.id.headerEmail);

    ActionBarDrawerToggle actionDrawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
    drawerLayout.addDrawerListener(actionDrawerToggle);
    drawerLayout.setScrimColor(Color.WHITE);
    actionDrawerToggle.setDrawerIndicatorEnabled(true);
    actionDrawerToggle.syncState();

    fragmentManager = getSupportFragmentManager();
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.container_frag, new HomeFragment()).commit();

    Log.d("TAG", mAuth.getCurrentUser().getUid());

    DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
    mDatabaseReference
        .child(user)
        .addListenerForSingleValueEvent(
            new ValueEventListener() {
              @SuppressLint("SetTextI18n")
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = Objects.requireNonNull(snapshot.child("name").getValue()).toString();
                String surname =
                    Objects.requireNonNull(snapshot.child("surname").getValue()).toString();
                String email =
                    Objects.requireNonNull(snapshot.child("email").getValue()).toString();
                hFullName.setText(name + " " + surname);
                hEmail.setText(email);
                proDialog.stop();
              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {}
            });
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {

    drawerLayout.closeDrawer(GravityCompat.START);

    if (item.getItemId() == R.id.user_home) {
      fragmentManager = getSupportFragmentManager();
      fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.container_frag, new HomeFragment()).commit();
    }
    if (item.getItemId() == R.id.user_profile) {
      fragmentManager = getSupportFragmentManager();
      fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.container_frag, new ProfileFragment());
      fragmentTransaction.commit();
    }
    if (item.getItemId() == R.id.user_logout) {
      FirebaseAuth.getInstance().signOut();
      startActivity(
          new Intent(this, LoginActivity.class)
              .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    return true;
  }
}

package com.example.witsly.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Firebase.FirebaseAuthentication;
import com.example.witsly.Fragments.HomeFragment;
import com.example.witsly.Fragments.ProfileFragment;
import com.example.witsly.ProDialog;
import com.example.witsly.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private DrawerLayout drawerLayout;
  private FragmentManager fragmentManager;
  private FragmentTransaction fragmentTransaction;
  private TextView hFullName, hEmail ,tvReputation;
  private ImageView hProfileImage;
  private ProDialog proDialog;
  NavigationView navigationView;
  private final FirebaseActions firebaseActions = new FirebaseActions();
  private final FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();
  private final String currentUser = firebaseActions.getUid();

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    drawerLayout = findViewById(R.id.MainDrawer);

    Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);

    proDialog = new ProDialog(this);

    navigationView = findViewById(R.id.navigationView);
    navigationView.setNavigationItemSelectedListener(this);
    View headerView = navigationView.getHeaderView(0);

    hFullName = headerView.findViewById(R.id.headerFullName);
    hEmail = headerView.findViewById(R.id.headerEmail);
    hProfileImage = headerView.findViewById(R.id.headerProfilePic);
    tvReputation = headerView.findViewById(R.id.headerReputation);

    ActionBarDrawerToggle actionDrawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
    drawerLayout.addDrawerListener(actionDrawerToggle);
    drawerLayout.setScrimColor(Color.WHITE);
    actionDrawerToggle.setDrawerIndicatorEnabled(true);
    actionDrawerToggle.syncState();

    fragmentManager = getSupportFragmentManager();
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.container_frag, new HomeFragment()).commit();

    proDialog.start();

    if (currentUser != null)
      firebaseActions.getUserDetails(
          currentUser,
          response -> {
            String name = response.getName();
            String surname = response.getSurname();
            String email = response.getEmail();
            String currentuserID = FirebaseAuth.getInstance().getCurrentUser().getUid();

            hFullName.setText(name + " " + surname);
            hEmail.setText(email);
            proDialog.stop();

            //reputation
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Answers");
            reference.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String userID = getIntent().getStringExtra("USER_ID");
                int points = 0;
                for(DataSnapshot answersnapshot : snapshot.getChildren()){
                  int vote = Integer.parseInt(String.valueOf(answersnapshot.child("vote").getValue()));
                  String uid = answersnapshot.child("uid").getValue(String.class);

                  if(uid.equals(currentuserID)){
                    points += vote;
                  }
                }
                tvReputation.setText(String.valueOf(points) + " points");
                //Log.d("TAG","userID is: " + currentuserID);
                //Log.d("TAG", "Reputation points is: " + points*15);

              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {

              }
            });


            if (!response.getImage().equals("")) {
              hProfileImage.setBackground(null);
              Picasso.get().load(response.getImage()).into(hProfileImage);
            }
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
      firebaseAuthentication.logout();
      startActivity(
          new Intent(this, LoginActivity.class)
              .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
    return true;
  }

  @Override
  protected void onDestroy() {
    proDialog.stop();
    super.onDestroy();
  }
}

package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
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


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private TextView hFullName, hEmail;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;
    private ProDialog proDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.MainDrawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        proDialog = new ProDialog(this);
        proDialog.startLoad();

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);

        hFullName = headerView.findViewById(R.id.headerFullName);
        hEmail = headerView.findViewById(R.id.headerEmail);


        ActionBarDrawerToggle actionDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionDrawerToggle);
        actionDrawerToggle.setDrawerIndicatorEnabled(true);
        actionDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_frag, new HomeFragment()).commit();


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        String user = mUser.getUid();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
        mDatabaseReference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();
                String surname = snapshot.child("surname").getValue().toString();
                String email = snapshot.child("email").getValue().toString();
                hFullName.setText(name + " " + surname);
                hEmail.setText(email);
                proDialog.endLoad();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
            FirebaseAuth.getInstance().signOut();

            startActivity(new Intent(this, LoginActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

        }
        
        return true;
    }
}
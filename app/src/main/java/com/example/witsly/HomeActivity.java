package com.example.witsly;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;

    private TextView tvName, tvSurname, tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        // Testing if user is logged in
        // can be removed once tested

        mUser = mAuth.getCurrentUser();
        String user = mUser.getUid();


        tvName = findViewById(R.id.tvName);
        tvSurname = findViewById(R.id.tvSurname);
        tvEmail = findViewById(R.id.tvEmail);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
        mDatabaseReference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();
                String surname = snapshot.child("surname").getValue().toString();
                String email = snapshot.child("email").getValue().toString();
                tvName.setText(name);
                tvEmail.setText(email);
                tvSurname.setText(surname);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
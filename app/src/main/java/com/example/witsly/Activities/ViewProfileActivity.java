package com.example.witsly.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;

public class ViewProfileActivity extends AppCompatActivity {

    public String profID;
    public AppCompatImageView profilePic;
    public TextView tvDetails, tvReputation, tvBio;
    public FirebaseActions firebaseActions = new FirebaseActions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        profilePic = findViewById(R.id.profile_image);
        tvDetails = findViewById(R.id.profile_name);
        tvReputation = findViewById(R.id.profile_reputation);
        tvBio = findViewById(R.id.profile_bio);

        /*Intent prevIntent = getIntent();
        profID = prevIntent.getStringExtra("profID");*/
    }
}
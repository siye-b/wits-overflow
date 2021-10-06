package com.example.witsly.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ViewProfileActivity extends AppCompatActivity {

  public AppCompatImageView profilePic;
  public TextView tvDetails,  tvBio, tvReputation;
  public FirebaseActions firebaseActions = new FirebaseActions();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_profile);
    profilePic = findViewById(R.id.profile_image_details);
    tvDetails = findViewById(R.id.profile_name);
    tvReputation = findViewById(R.id.profile_reputation);
    tvBio = findViewById(R.id.profile_bio);

    String userID = getIntent().getStringExtra("USER_ID");

    firebaseActions.getUserDetails(
        userID,
        user -> {
          tvDetails.setText(user.getName() + " " + user.getSurname());
          tvBio.setText(user.getBio());

          if (!user.getImage().equals("")) {
            Log.d("ImageLink", user.getImage());
            Picasso.get().load(Uri.parse(user.getImage())).into(profilePic);
          }
        });

      firebaseActions.getReputation( a->
      {
               tvReputation.setText(a.getReputation());

      });

  }
}

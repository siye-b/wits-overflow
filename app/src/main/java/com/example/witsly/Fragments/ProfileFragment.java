package com.example.witsly.Fragments;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {

  private AppCompatImageView profilePic;
  private FloatingActionButton btnImageUploader;
  private AppCompatButton btnSave;
  private TextInputEditText UserBio;
  private TextView tvBio;
  Uri imgUri;
  FirebaseActions firebaseActions = new FirebaseActions();
  DatabaseReference ref;

  public static int IMAGE_VERIFY = 1;
  private Activity headerView;
  //private NavigationView navigationView;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile, container, false);



    profilePic = view.findViewById(R.id.userProfilePicture);
    btnImageUploader = view.findViewById(R.id.uploadProfilePicture);

    btnImageUploader.setOnClickListener(img -> choosePicture());
    btnSave = view.findViewById(R.id.btnSave);
    UserBio = view.findViewById(R.id.bio);
    tvBio = view.findViewById(R.id.headerBio);
    //setContentView();
    //tvBio = headerView.findViewById(R.id.profile_bio);

    // Get the current user to return a model
    // since there is a built in function user.getBio
    // UserBio.setText(user.getBio);
      super.onCreate(savedInstanceState);
      //setContentView(R.layout.fragment_profile);

    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            saveChanges();
            UserBio.getText().toString();
            ref = FirebaseDatabase.getInstance().getReference().child("Users").child("bio");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String bi = snapshot.child("bio").getValue(String.class);
                    System.out.println(bi);
                    tvBio.setText(bi);

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    });
    firebaseActions.getBio(
        value -> {
          //UserBio.setHint(value.getBio());
          UserBio.setText(value.getBio());

        });

    firebaseActions.getProfilePic(img -> Picasso.get().load(img).into(profilePic));

    return view;

    //BioT
    /*DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Bio");
    reference.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot snapshot) {

        for(DataSnapshot answersnapshot : snapshot.getChildren()){
         // int vote = Integer.parseInt(String.valueOf(answersnapshot.child("vote").getValue()));
          String uid = answersnapshot.child("uid").getValue(String.class);

          //String currentuserID;
          String currentuserID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        }

      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }
    });

     */
  }


  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // after the view has been created we want to get all the profile image

  }

  private void choosePicture() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(intent, IMAGE_VERIFY);
  }

  // Do not remove the code below
  /*private void selectImage() {
    CropImage.activity()
        .setGuidelines(CropImageView.Guidelines.ON)
        .setFixAspectRatio(true)
        .setAspectRatio(1, 1)
        .setCropShape(CropImageView.CropShape.OVAL)
        .setActivityTitle("Select an Image")
        .start(getContext(), this);
  }*/

  private void saveChanges() {

    String bio = UserBio.getText().toString().trim();
    firebaseActions.AddBio(bio);

  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == IMAGE_VERIFY
        && resultCode == RESULT_OK
        && data != null
        && data.getData() != null) {
      imgUri = data.getData();
      profilePic.setBackground(null);
      Picasso.get().load(imgUri).into(profilePic);
      firebaseActions.uploadPicture(imgUri);
    }

    // The Code below still works for physical devices, do not remove the code
    /*if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
      CropImage.ActivityResult result = CropImage.getActivityResult(data);
      if (resultCode == RESULT_OK) {
        imgUri = result.getUri();
        profilePic.setImageURI(imgUri);
        firebaseActions.uploadPicture(imgUri);
      } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
        Exception error = result.getError();
        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
      }
    }*/

  }
}

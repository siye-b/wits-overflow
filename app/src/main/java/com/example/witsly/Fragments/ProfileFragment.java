package com.example.witsly.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {

  private AppCompatImageView profilePic;
  private FloatingActionButton btnImageUploader;
  private AppCompatButton btnSave;
  private EditText UserBio;
  FirebaseAuth user;
  Uri imgUri;
  FirebaseActions firebaseActions = new FirebaseActions();

  public static int IMAGE_VERIFY = 1;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile, container, false);
    profilePic = view.findViewById(R.id.userProfilePicture);
    btnImageUploader = view.findViewById(R.id.uploadProfilePicture);
    UserBio = view.findViewById(R.id.bio);

    btnImageUploader.setOnClickListener(img -> choosePicture());
    btnSave = view.findViewById(R.id.btnSave);

    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        saveChanges();
      }
    });

    return view;
  }

  private void choosePicture() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(intent, IMAGE_VERIFY);
  }

  //Do not remove the code below
  /*private void selectImage() {
    CropImage.activity()
        .setGuidelines(CropImageView.Guidelines.ON)
        .setFixAspectRatio(true)
        .setAspectRatio(1, 1)
        .setCropShape(CropImageView.CropShape.OVAL)
        .setActivityTitle("Select an Image")
        .start(getContext(), this);
  }*/

  private void saveChanges(){
    //Change Bio
    user = FirebaseAuth.getInstance();
    String CUid = user.getCurrentUser().getUid();

    String bio = UserBio.getText().toString().trim();
    firebaseActions.AddBio(bio, CUid );
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    //The Code below still works for physical devices, do not remove the code
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

    if (requestCode == IMAGE_VERIFY && resultCode == RESULT_OK && data != null
            && data.getData() != null){
      imgUri = data.getData();
      profilePic.setBackground(null);
      profilePic.setImageURI(imgUri);
    }


  }
}

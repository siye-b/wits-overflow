package com.example.witsly.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {


    private AppCompatImageView profilePic;
    Uri imgUri;
    FirebaseActions firebaseActions;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profilePic = view.findViewById(R.id.userProfilePicture);

        view.findViewById(R.id.uploadProfilePicture).setOnClickListener(
                v -> choosePicture()
        );


        return view;
    }

    private void choosePicture() {
        startActivityForResult(
                new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), 1
        );


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        firebaseActions = new FirebaseActions();

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            imgUri = data.getData();
            profilePic.setImageURI(imgUri);
            profilePic.setBackgroundDrawable(null);
            firebaseActions.uploadPicture(imgUri);


        }

    }
}

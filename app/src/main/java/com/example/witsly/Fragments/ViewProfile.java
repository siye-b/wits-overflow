package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;


public class ViewProfile extends Fragment {

    public String profID;
    public AppCompatImageView profilePic;
    public TextView tvDetails, tvReputation, tvBio;
    public FirebaseActions firebaseActions = new FirebaseActions();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_profile, container, false);

        profilePic = view.findViewById(R.id.profile_image);
        tvDetails = view.findViewById(R.id.profile_name);
        tvReputation = view.findViewById(R.id.profile_reputation);
        tvBio = view.findViewById(R.id.profile_bio);


        return view;

    }
}
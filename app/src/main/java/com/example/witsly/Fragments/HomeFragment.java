package com.example.witsly.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.witsly.PostActivity;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);

        mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));
        return view;
    }
}

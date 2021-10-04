package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SubscriptionFragment extends Fragment {

    public FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        mFab = view.findViewById(R.id.btn_add_sub);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_frag, new AddSubscriptionFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }
}
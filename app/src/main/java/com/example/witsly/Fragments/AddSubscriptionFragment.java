package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.witsly.Adapters.RecyclerAdapter;
import com.example.witsly.Adapters.TopicAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Topic;
import com.example.witsly.R;

import java.util.ArrayList;


public class AddSubscriptionFragment extends Fragment {
    private TopicAdapter adapterm;
    private final FirebaseActions firebaseActions = new FirebaseActions();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_subscription, container, false);

        //display topics

        RecyclerView mRecyclerView = view.findViewById(R.id.add_sub_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
        firebaseActions.getTopics(
                topics -> {
                    adapterm = new TopicAdapter(topics, getContext());
                    mRecyclerView.setLayoutManager(mRecyclerManager);
                    mRecyclerView.setAdapter(adapterm);
                });

        return view;
    }
}
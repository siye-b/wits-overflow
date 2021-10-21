package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.witsly.Adapters.RecyclerAdapter;
import com.example.witsly.Adapters.TopicAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;


public class MyFeedFragment extends Fragment {
    private RecyclerAdapter mAdapter;
    private final FirebaseActions firebaseActions = new FirebaseActions();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_feed, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.my_feed_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
        firebaseActions.getPostsSubscribedTo(
                posts -> {
                    mAdapter = new RecyclerAdapter(posts,getContext());
                    mRecyclerView.setLayoutManager(mRecyclerManager);
                    mRecyclerView.setAdapter(mAdapter);
                });

        return view;
    }
}
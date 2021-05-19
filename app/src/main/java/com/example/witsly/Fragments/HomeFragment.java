package com.example.witsly.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Adapters.RecyclerAdapter;
import com.example.witsly.FirebaseActions;
import com.example.witsly.PostActivity;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

  private final FirebaseActions firebaseActions = new FirebaseActions();

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);
    mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));

    RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
    mRecyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
    firebaseActions.getAllPost(
        (response) -> {
          RecyclerView.Adapter mRecyclerViewAdapter = new RecyclerAdapter(response, getContext());
          mRecyclerView.setAdapter(mRecyclerViewAdapter);
          mRecyclerView.setLayoutManager(mRecyclerManager);
        });

    return view;
  }
}

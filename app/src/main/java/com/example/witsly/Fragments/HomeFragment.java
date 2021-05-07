package com.example.witsly.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Models.Post;
import com.example.witsly.PostActivity;
import com.example.witsly.R;
import com.example.witsly.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment {

  private ArrayList<Post> postArrayList;
  private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

  private final DatabaseReference databaseReference = firebaseDatabase.getReference("Posts");

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);
    mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));
    postArrayList = new ArrayList<>();

    RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
    mRecyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
              Post post = postSnapshot.getValue(Post.class);
              postArrayList.add(post);
              Collections.sort(postArrayList, Post.VoteComparator);
            }
            RecyclerView.Adapter mRecyclerViewAdapter = new RecyclerAdapter(postArrayList);
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
            mRecyclerView.setLayoutManager(mRecyclerManager);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });

    return view;
  }
}

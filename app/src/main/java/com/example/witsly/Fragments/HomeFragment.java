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
      final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_home, container, false);

    final FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);
    mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));
    postArrayList = new ArrayList<>();

    final RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
    mRecyclerView.setHasFixedSize(true);
    final RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull final DataSnapshot snapshot) {

            for (final DataSnapshot postSnapshot : snapshot.getChildren()) {

              final Post post = postSnapshot.getValue(Post.class);
              assert post != null;
              post.setPostID(postSnapshot.getKey());
              postArrayList.add(post);

              // sorts the question according to votes

              Collections.sort(postArrayList, Post.VoteComparator);
            }
            final RecyclerView.Adapter mRecyclerViewAdapter =
                new RecyclerAdapter(postArrayList, getContext());
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
            mRecyclerView.setLayoutManager(mRecyclerManager);
          }

          @Override
          public void onCancelled(@NonNull final DatabaseError error) {}
        });

    return view;
  }
}

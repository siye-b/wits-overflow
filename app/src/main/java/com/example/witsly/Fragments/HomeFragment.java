package com.example.witsly.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.PostActivity;
import com.example.witsly.Adapters.RecyclerAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Post;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;

public class HomeFragment extends Fragment {

  private final FirebaseActions firebaseActions = new FirebaseActions();
  private RecyclerAdapter mRecyclerViewAdapter;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);
    mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));

    setHasOptionsMenu(true);

    RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
    mRecyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
    firebaseActions.getAllPost(
        (response) -> {
          Collections.sort(response, Post.VoteComparator);
          mRecyclerViewAdapter = new RecyclerAdapter(response, getActivity());
          mRecyclerView.setLayoutManager(mRecyclerManager);
          mRecyclerView.setAdapter(mRecyclerViewAdapter);
        });

    return view;
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    inflater.inflate(R.menu.search_menu, menu);

    MenuItem menuItem = menu.findItem(R.id.search);
    SearchView searchView = (SearchView) menuItem.getActionView();
    searchView.setOnQueryTextListener(
        new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
            return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
            mRecyclerViewAdapter.getFilter().filter(newText);
            return false;
          }
        });

    super.onCreateOptionsMenu(menu, inflater);
  }
}

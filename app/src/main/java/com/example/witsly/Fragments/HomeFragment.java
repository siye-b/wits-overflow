package com.example.witsly.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.CardItem;
import com.example.witsly.MainActivity;
import com.example.witsly.PostActivity;
import com.example.witsly.R;
import com.example.witsly.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mRecyclerManager;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);

        mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));

        ArrayList<CardItem> example = new ArrayList<>();
        example.add(new CardItem("test", "test", "test", "test", "test"));
        example.add(new CardItem("test", "test", "test", "test", "test"));
        example.add(new CardItem("test", "test", "test", "test", "test"));
        example.add(new CardItem("test", "test", "test", "test", "test"));
        example.add(new CardItem("test", "test", "test", "test", "test"));
        example.add(new CardItem("test", "test", "test", "test", "test"));

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerManager = new LinearLayoutManager(view.getContext());
        mRecyclerViewAdapter = new RecyclerAdapter(example);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(mRecyclerManager);

        return view;
    }
}

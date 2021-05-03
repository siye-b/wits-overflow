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
import com.example.witsly.PostActivity;
import com.example.witsly.R;
import com.example.witsly.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        FloatingActionButton mFAB = view.findViewById(R.id.btn_new_post);
        mFAB.setOnClickListener(v -> startActivity(new Intent(getActivity(), PostActivity.class)));
        ArrayList<CardItem> example = new ArrayList<>();

        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );


        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );

        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );


        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );

        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );
        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );
        example.add(
                new CardItem(
                        "Lorem Ipsum",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                        0,
                        "User posted on 21/21/2021"
                )
        );

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
        RecyclerView.Adapter mRecyclerViewAdapter = new RecyclerAdapter(example);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(mRecyclerManager);

        return view;
    }
}

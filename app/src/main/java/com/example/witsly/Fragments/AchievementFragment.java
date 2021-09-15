package com.example.witsly.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Adapters.AchievementAdapter;
import com.example.witsly.Models.Achievement;
import com.example.witsly.R;

import java.util.ArrayList;


public class AchievementFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_achievement, container, false);

        ArrayList<Achievement> achievementList = new ArrayList<>();
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Verified Account", "verify your acccount's email", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", false));




        mRecyclerView = view.findViewById(R.id.achievement_rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new AchievementAdapter(achievementList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}



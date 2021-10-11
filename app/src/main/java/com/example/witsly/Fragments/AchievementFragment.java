package com.example.witsly.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Adapters.AchievementAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Achievement;
import com.example.witsly.R;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class AchievementFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FirebaseActions firebaseActions = new FirebaseActions();
    ArrayList<Achievement> achievementList;
    ArrayList<Integer> p;
    ArrayList<Integer> pp;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String cuID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        View view = inflater.inflate(R.layout.fragment_achievement, container, false);

        mRecyclerView = view.findViewById(R.id.achievement_rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());

        achievementList = new ArrayList<>();
        p = new ArrayList<>();
        pp = new ArrayList<>();

        DatabaseReference reference =
                FirebaseDatabase.getInstance().getReference().child(FirebaseUtils.POSTS);
        reference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        p.clear();
                        achievementList.clear();

                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                            int vote =
                                    Integer.parseInt(
                                            String.valueOf(postSnapshot.child(FirebaseUtils.VOTE).getValue()));
                            String uid = postSnapshot.child("uid").getValue(String.class);

                            if (uid.equals(cuID)) {

                                p.add(vote);
                            }
                        }
                        achievementList = check(Collections.max(p));
                        Toast.makeText(getActivity(), Collections.max(p) + "", Toast.LENGTH_LONG).show();
                        mAdapter = new AchievementAdapter(achievementList);

                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}
                });

    /*DatabaseReference reference2 =
        FirebaseDatabase.getInstance().getReference().child(FirebaseUtils.ANSWERS);
    reference2.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            pp.clear();
            achievementList.clear();
            for (DataSnapshot answerSnapshot : snapshot.getChildren()) {

              int vote =
                  Integer.parseInt(
                      String.valueOf(answerSnapshot.child(FirebaseUtils.VOTE).getValue()));
              String uid = answerSnapshot.child("uid").getValue(String.class);

              if (uid.equals(cuID)) {
                pp.add(vote);

               }
            }
             achievementList = check2(Collections.max(pp));
             Toast.makeText(getActivity(), Collections.max(pp) + "", Toast.LENGTH_LONG).show();
             mAdapter = new AchievementAdapter(achievementList);

             mRecyclerView.setLayoutManager(mLayoutManager);
             mRecyclerView.setAdapter(mAdapter);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });*/

    /*achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Verified Account", "verify your acccount's email",  true));
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", true));
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", true));
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", false));
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", false));
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", false));*/

        return view;
    }

    /**
     * st NOW WORKING FINE
     */
    ArrayList<Achievement> check(int points) {
        ArrayList<Achievement> achievementList = new ArrayList<>();

        if (points >= 1) {
            achievementList.add(
                    new Achievement(
                            R.drawable.ic_asker, "Asker", "Post a question and get an upvote", true));

            if (points >= 5 && points < 10) {
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_goodquestion,
                                "Good Question",
                                "Get 5 upvotes on your question",
                                true));

            }if (points >= 10 && points < 50) {
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_greatquestion,
                                "Great Question",
                                "Get 10 upvote on your question",
                                true));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_goodquestion,
                                "Good Question",
                                "Get 5 upvotes on your question",
                                true));

            }if (points >= 50) {
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_topquestion,
                                "Top Question",
                                "Get 50 upvotes on your question",
                                true));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_goodquestion,
                                "Good Question",
                                "Get 5 upvotes on your question",
                                true));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_greatquestion,
                                "Great Question",
                                "Get 10 upvote on your question",
                                true));

            } else {

                if (points < 5 ) {

                    achievementList.add(
                            new Achievement(
                                    R.drawable.ic_grey_goodquestion,
                                    "Good Question",
                                    "Get 5 upvotes on your question",
                                    false));

                }
                if (points < 10) {
                    achievementList.add(
                            new Achievement(
                                    R.drawable.ic_grey_greatquestion,
                                    "Great Question",
                                    "Get 10 upvote on your question",
                                    false));
                }
                if(points < 50) {
                    achievementList.add(
                            new Achievement(
                                    R.drawable.ic_grey_topquestion,
                                    "Top Question",
                                    "Get 50 upvotes on your question",
                                    false));
                }
            }
        } else {
            if (points < 1) {
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_grey_asker,
                                "Asker",
                                "Post a question and get an upvote",
                                false));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_grey_goodquestion,
                                "Good Question",
                                "Get 5 upvotes on your question",
                                false));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_grey_greatquestion,
                                "Great Question",
                                "Get 10 upvote on your question",
                                false));
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_grey_topquestion,
                                "Top Question",
                                "Get 50 upvotes on your question",
                                false));
            }
        }
        return achievementList;
    }

    ArrayList<Achievement> check2(int commentPoints) {
        ArrayList<Achievement> achievementList = new ArrayList<>();
        if (commentPoints >= 1) {
            achievementList.add(
                    new Achievement(
                            R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", true));
        } else {
            if (commentPoints < 1) {
                achievementList.add(
                        new Achievement(
                                R.drawable.ic_verifiedaccount,
                                "Contributor",
                                "Leave a comment in a question",
                                false));
            }
        }

        return achievementList;
    }
}

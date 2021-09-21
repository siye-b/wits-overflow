package com.example.witsly.Fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.example.witsly.Models.Post;
import com.example.witsly.R;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AchievementFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    int pointss;
    FirebaseActions firebaseActions = new FirebaseActions();
    ArrayList<Achievement> achievementList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String cuID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        View view = inflater.inflate(R.layout.fragment_achievement, container, false);

        /*firebaseActions.getTotalPostsVotes(cuID, v->{
            points = v.getTotVotes();
        });*/

        /*firebaseActions.getTotCommentVotes(cuID, v->{
            commentPoints = v.getTotCVotes();
        });*/


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(FirebaseUtils.POSTS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                pointss = 0;
                for(DataSnapshot postSnapshot : snapshot.getChildren()) {

                    int vote = Integer.parseInt(String.valueOf(postSnapshot.child(FirebaseUtils.VOTE).getValue()));
                    String uid = postSnapshot.child("uid").getValue(String.class);

                    if (uid.equals(cuID)) {

                        pointss += vote;

                        achievementList = check(pointss);
                        Log.d("achievement list", achievementList.size()+"");
                        Toast.makeText(getActivity(),"User points "+vote ,Toast.LENGTH_SHORT).show();

                    }
              }
          }


          @Override
          public void onCancelled(@NonNull DatabaseError error) { }
      });


        /*achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Verified Account", "verify your acccount's email",  true));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", true));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", true));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", false));
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", false));*/


        mRecyclerView = view.findViewById(R.id.achievement_rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new AchievementAdapter(achievementList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

ArrayList<Achievement> check( int points){
    ArrayList<Achievement> achievementList = new ArrayList<>();
    achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", true));


    /*if(points >= 1){
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", true));

        if(points >=5 && points < 10) {
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", true));

        }
        else if(points>=10 && points<50) {
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", true));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", true));

        }
        else if(points>=50) {
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", true));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", true));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", true));

        }
        else {
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", false));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", false));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", false));
        }
    }
    /*if(commentPoints >= 1 ){
        achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", true));
    }
    else{
        if(points <1) {
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Asker", "Post a question and get an upvote", false));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Good Question", "Get 5 upvotes on your question", false));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Great Question", "Get 10 upvote on your question", false));
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Top Question", "Get 50 upvotes on your question", false));
        }
        if(commentPoints <1){
            achievementList.add(new Achievement(R.drawable.ic_verifiedaccount, "Contributor", "Leave a comment in a question", false));

        }
    }*/
    return achievementList;
}
}



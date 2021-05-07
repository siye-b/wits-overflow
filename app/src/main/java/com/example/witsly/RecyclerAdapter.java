package com.example.witsly;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.loader.ResourcesLoader;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.collection.LLRBNode;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

  private final ArrayList<Post> mPostList;
  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
  User value;

  public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mPosterDetails;
    public TextView mPostTitle;
    public TextView mPostBody;
    public TextView mVoteCount;

    public RadioButton mUpvoteButton;
    public RadioButton mDownvoteButton;
    public RadioGroup mRadioGroup;

    public RecyclerViewHolder(@NonNull View itemView) {
      super(itemView);
      mPosterDetails = itemView.findViewById(R.id.tv_poster2);
      mPostTitle = itemView.findViewById(R.id.tv_card_title2);
      mPostBody = itemView.findViewById(R.id.tv_card_body2);
      mVoteCount = itemView.findViewById(R.id.tv_vote_count2);

      mUpvoteButton = itemView.findViewById(R.id.btn_upvote2);
      mDownvoteButton = itemView.findViewById(R.id.btn_downvote2);
      mRadioGroup = itemView.findViewById(R.id.radioGroup);

      mDownvoteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //Insert Logic for Votes
            if(mDownvoteButton.isChecked()){
              mVoteCount.setTextColor(ResourcesCompat.getColor(v.getResources(), R.color.Red, null));
            }else if(mUpvoteButton.isChecked()){
              //Do Stuff
            }else{
              //Do Stuff
            }
        }
      });

      mUpvoteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //Insert Logic for Votes
          if(mDownvoteButton.isChecked()){
            //Do Stuff
          }else if(mUpvoteButton.isChecked()){
            //Do Stuff
            mVoteCount.setTextColor(ResourcesCompat.getColor(v.getResources(), R.color.Green, null));
          }else{
            //Do Stuff
          }
        }
      });
    }
  }

  public RecyclerAdapter(ArrayList<Post> postList) {
    mPostList = postList;
  }

  @NonNull
  @Override
  public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, parent, false);

    return new RecyclerViewHolder(v);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    Post cItem = mPostList.get(position);

    if (cItem.getTitle().length() > 15) {
      holder.mPostTitle.setText((cItem.getTitle()).substring(0, 15));

    } else {
      holder.mPostTitle.setText(cItem.getTitle());
    }

    if (cItem.getBody().length() > 30) {
      holder.mPostBody.setText((cItem.getBody()).substring(0, 30));
    } else {
      holder.mPostBody.setText(cItem.getTitle());
    }

    firebaseDatabase
        .getReference("Users/" + cItem.getUid())
        .addValueEventListener(
            new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                value = snapshot.getValue(User.class);
                assert value != null;
                holder.mPosterDetails.setText(
                    "Posted by "
                        + value.getName()
                        + " "
                        + value.getSurname()
                        + " on: "
                        + (cItem.getDate()).substring(0, 10));
              }

              @Override
              public void onCancelled(@NonNull @NotNull DatabaseError error) {}
            });

    holder.mVoteCount.setText(cItem.getVote() + "");
  }

  @Override
  public int getItemCount() {
    return mPostList.size();
  }
}

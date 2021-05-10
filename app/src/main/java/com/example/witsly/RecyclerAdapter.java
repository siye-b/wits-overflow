package com.example.witsly;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Fragments.ViewQuestion;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

  private final ArrayList<Post> mPostList;
  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
  User value;
  Context context;
  private OnItemClickListener mListener;

  public interface OnItemClickListener{
      void onItemClick(int pos);
      //Please modify to add necessary information from dB i.e. Title, Body etc.
      //Alternatively, pass the ID of the post at current position and we can get the necessary info
      //Use method in HomeFragment to navigate to ViewQuestion activity
  }

  public void setOnItemClickListener(OnItemClickListener listener){
      mListener = listener;
  }

  public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mPosterDetails;
    public TextView mPostTitle;
    public TextView mPostBody;
    public TextView mVoteCount;
    CardView card;

    private final RadioButton mUpVoteButton;
    private final RadioButton mDownVoteButton;

    public RecyclerViewHolder(@NonNull View itemView, OnItemClickListener listener) {
      super(itemView);
      mPosterDetails = itemView.findViewById(R.id.tv_poster2);
      mPostTitle = itemView.findViewById(R.id.tv_card_title2);
      mPostBody = itemView.findViewById(R.id.tv_card_body2);
      mVoteCount = itemView.findViewById(R.id.tv_vote_count2);
      mUpVoteButton = itemView.findViewById(R.id.btn_upvote2);
      mDownVoteButton = itemView.findViewById(R.id.btn_downvote2);
      RadioGroup mRadioGroup = itemView.findViewById(R.id.radioGroup);
      card = itemView.findViewById(R.id.cardView);

      itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if(listener != null){
                int pos = getAdapterPosition();
                if(pos != RecyclerView.NO_POSITION){
                    listener.onItemClick(pos);
                }
            }
          }
      });

      mDownVoteButton.setOnClickListener(
          v -> {
            // Insert Logic for Votes
            // Do Stuff
            if (mDownVoteButton.isChecked())
              mVoteCount.setTextColor(
                  ResourcesCompat.getColor(v.getResources(), R.color.Red, null));
            else if (mUpVoteButton.isChecked()) {
              // Do Stuff
            } else {
              // Do Stuff
            }
          });

      mUpVoteButton.setOnClickListener(
          v -> {
            // Insert Logic for Votes
            if (mDownVoteButton.isChecked()) {
              // Do Stuff
            } else // Do Stuff
            if (mUpVoteButton.isChecked())
              mVoteCount.setTextColor(
                  ResourcesCompat.getColor(v.getResources(), R.color.Green, null));
            else {
              // Do Stuff
            }
          });
    }
  }

  public RecyclerAdapter(ArrayList<Post> postList, Context context) {
    this.mPostList = postList;
    this.context = context;
  }

  @NonNull
  @Override
  public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, parent, false);

    return new RecyclerViewHolder(v, mListener);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    Post cItem = mPostList.get(position);

    if (cItem.getTitle().length() > 15)
      holder.mPostTitle.setText((cItem.getTitle()).substring(0, 15));
    else holder.mPostTitle.setText(cItem.getTitle());

    if (cItem.getBody().length() > 30) holder.mPostBody.setText((cItem.getBody()).substring(0, 30));
    else holder.mPostBody.setText(cItem.getTitle());

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
    holder.card.setOnClickListener(
        v -> {
          Bundle bundle = new Bundle();
          bundle.putString("title", cItem.getTitle());
          bundle.putString("body", cItem.getBody());
          bundle.putString(
              "details",
              "Posted by "
                  + value.getName()
                  + " "
                  + value.getSurname()
                  + " on: "
                  + (cItem.getDate()).substring(0, 10));

          AppCompatActivity activity = (AppCompatActivity) context;

          Fragment viewQuestion = new ViewQuestion();
          viewQuestion.setArguments(bundle);
          FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
          transaction.replace(R.id.container_frag, viewQuestion);
          transaction.addToBackStack(null);
          transaction.commit();
        });

  }

  @Override
  public int getItemCount() {
    return mPostList.size();
  }
}

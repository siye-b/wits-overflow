package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.FirebaseActions;
import com.example.witsly.Fragments.ViewQuestion;
import com.example.witsly.Models.Post;
import com.example.witsly.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> implements Filterable {

  private final ArrayList<Post> mPostList;
  private final Context context;
  private OnItemClickListener mListener;
  private final FirebaseActions firebaseActions = new FirebaseActions();

    @Override
    public Filter getFilter() {
        return recyclerFilter;
    }


    public interface OnItemClickListener {
    void onItemClick(int pos);
    // Please modify to add necessary information from dB i.e. Title, Body etc.
    // Alternatively, pass the ID of the post at current position and we can get the necessary info
    // Use method in HomeFragment to navigate to ViewQuestion activity
  }

  public void setOnItemClickListener(final OnItemClickListener listener) {
    mListener = listener;
  }

  static class RecyclerViewHolder extends RecyclerView.ViewHolder {

    Chip mChip;
    TextView mPosterDetails;
    TextView mPostTitle;
    TextView mPostBody;
    TextView mVoteCount;
    CardView card;
    private final RadioButton mUpVoteButton;
    private final RadioButton mDownVoteButton;

    RecyclerViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
      super(itemView);

      mChip = itemView.findViewById(R.id.tag);
      mPosterDetails = itemView.findViewById(R.id.tv_poster2);
      mPostTitle = itemView.findViewById(R.id.tv_card_title2);
      mPostBody = itemView.findViewById(R.id.tv_card_body2);
      mVoteCount = itemView.findViewById(R.id.tv_vote_count2);
      mUpVoteButton = itemView.findViewById(R.id.btn_upvote2);
      mDownVoteButton = itemView.findViewById(R.id.btn_downvote2);
      final RadioGroup mRadioGroup = itemView.findViewById(R.id.radioGroup);
      card = itemView.findViewById(R.id.cardView);

      itemView.setOnClickListener(
          v -> {
            if (listener != null) {
              final int pos = getAdapterPosition();
              if (pos != RecyclerView.NO_POSITION) listener.onItemClick(pos);
            }
          });

      mDownVoteButton.setOnClickListener(
          v -> {
            if (mUpVoteButton.isChecked()) {
              mDownVoteButton.setChecked(false);
            }
          });

      mUpVoteButton.setOnClickListener(
          v -> {
            if (mDownVoteButton.isChecked()) {
              mUpVoteButton.setChecked(false);
            }
          });
    }
  }

  public RecyclerAdapter(final ArrayList<Post> postList, final Context context) {
    mPostList = postList;
    this.context = context;
  }

  @NonNull
  @Override
  public RecyclerViewHolder onCreateViewHolder(
      @NonNull final ViewGroup parent, final int viewType) {
    final View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, parent, false);

    return new RecyclerViewHolder(v, mListener);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {

    final Post cItem = mPostList.get(position);

    if (cItem.getTitle().length() > 15)
      holder.mPostTitle.setText((cItem.getTitle()).substring(0, 15));
    else holder.mPostTitle.setText(cItem.getTitle());

    holder.mChip.setText(cItem.getTag());

    if (cItem.getBody().length() > 30) holder.mPostBody.setText((cItem.getBody()).substring(0, 30));
    else holder.mPostBody.setText(cItem.getTitle());

    holder.mUpVoteButton.setOnClickListener(
        up -> firebaseActions.upVote(cItem.getPostID(), cItem.getUid()));
    holder.mDownVoteButton.setOnClickListener(
        down -> firebaseActions.downVote(cItem.getPostID(), cItem.getUid()));

    firebaseActions.getPostVoteState(
        cItem.getPostID(),
        cItem.getUid(),
        g -> {
          if (g == 0) {

            // up
            holder.mUpVoteButton.setChecked(true);
          }
          if (g == 1) {
            // nothing
            holder.mDownVoteButton.setChecked(false);
            holder.mUpVoteButton.setChecked(false);
          }

          if (g == 2) {
            // down
            holder.mDownVoteButton.setChecked(true);
          }
        });

    firebaseActions.getUserDetails(
        cItem.getUid(),
        value -> {
          // value.getTag()

          // pass the tag we get
          holder.mPosterDetails.setText(
              "Posted by "
                  + value.getName()
                  + " "
                  + value.getSurname()
                  + " on: "
                  + (cItem.getDate()).substring(0, 10));
        });

    holder.mVoteCount.setText(cItem.getVote() + "");
    holder.card.setOnClickListener(
        v -> {
          final Bundle bundle = new Bundle();
          bundle.putString("postID", cItem.getPostID());

          final AppCompatActivity activity = (AppCompatActivity) context;

          final Fragment viewQuestion = new ViewQuestion();
          viewQuestion.setArguments(bundle);
          final FragmentTransaction transaction =
              activity.getSupportFragmentManager().beginTransaction();
          transaction.replace(R.id.container_frag, viewQuestion);

          transaction.addToBackStack(null);
          transaction.commit();
        });
  }

  @Override
  public int getItemCount() {
    return mPostList.size();
  }

    private Filter recyclerFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Post> filterList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filterList.addAll(mPostList);
            }else{
                String query = constraint.toString().toLowerCase().trim();
                for(Post card:mPostList){
                    if(card.getTag().toLowerCase().trim().matches(query)){
                        filterList.add(card);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mPostList.clear();
            mPostList.addAll((Collection<? extends Post>) results.values);
            notifyDataSetChanged();
        }
    };
}

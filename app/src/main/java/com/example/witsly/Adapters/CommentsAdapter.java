package com.example.witsly.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

  private ArrayList<String> mCommentsList;

  static class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView mCommentDetails;
    private final TextView mCommentBody;

    ViewHolder(@NonNull @NotNull final View itemView) {
      super(itemView);

      mCommentDetails = itemView.findViewById(R.id.tv_commenter_name);
      mCommentBody = itemView.findViewById(R.id.tv_commenter_body);
    }
  }

  public CommentsAdapter(final ArrayList<String> commentsList) {
    mCommentsList = commentsList;
  }

  @NonNull
  @NotNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull @NotNull final ViewGroup parent, final int viewType) {
    final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
    return new CommentsAdapter.ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull final CommentsAdapter.ViewHolder holder, final int position) {
    final String curr = mCommentsList.get(position);

    // Do stuff
  }

  @Override
  public int getItemCount() {
    return mCommentsList.size();
  }
}

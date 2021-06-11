package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Comment;
import com.example.witsly.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

  private final ArrayList<Comment> mCommentsList;
  private final FirebaseActions firebaseActions = new FirebaseActions();
  private final Context mContext;
  FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

  static class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView mCommentDetails;
    private final TextView mCommentBody;
    private final TextView deleteBtn;
    CardView cardView;

    ViewHolder(@NonNull @NotNull final View itemView) {
      super(itemView);

      mCommentDetails = itemView.findViewById(R.id.tv_commenter_name);
      mCommentBody = itemView.findViewById(R.id.tv_commenter_body);
      deleteBtn = itemView.findViewById(R.id.delete_comment);
      cardView = itemView.findViewById(R.id.ccard);
    }
  }

  public CommentsAdapter(final ArrayList<Comment> commentsList, Context context) {
    mCommentsList = commentsList;
    mContext = context;
  }

  @NonNull
  @NotNull
  @Override
  public ViewHolder onCreateViewHolder(
      @NonNull @NotNull final ViewGroup parent, final int viewType) {
    final View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
    return new CommentsAdapter.ViewHolder(v);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(
      @NonNull @NotNull final CommentsAdapter.ViewHolder holder, final int position) {
    final Comment comment = mCommentsList.get(position);
    holder.mCommentBody.setText(comment.getComment());
    firebaseActions.getUserDetails(
        comment.getUID(),
        user ->
            holder.mCommentDetails.setText(
                user.getName() + " " + user.getSurname() + " on " + comment.getDate()));

    firebaseActions.isCurrentUserAdmin(
        (isAdmin, resp) -> {
          if (isAdmin || comment.getUID().equals(mUser.getUid())) {
            holder.deleteBtn.setVisibility(View.VISIBLE);
            holder.deleteBtn.setOnClickListener(
                h ->
                    firebaseActions.deleteComment(
                        comment.getCID(),
                        d -> {
                          if (d) {
                            Toast.makeText(mContext, "Comment deleted", Toast.LENGTH_LONG).show();
                            holder.cardView.setVisibility(View.GONE);
                          }
                        }));
          }
        });
  }

  @Override
  public int getItemCount() {
    return mCommentsList.size();
  }
}

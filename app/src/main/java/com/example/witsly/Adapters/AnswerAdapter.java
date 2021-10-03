package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.ViewProfileActivity;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Answer;
import com.example.witsly.Models.Comment;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

  private final ArrayList<Answer> mAnswerList;
  private final FirebaseActions firebaseActions = new FirebaseActions();
  private final String currentUser = firebaseActions.getUid();

  private final Context mContext;
  private FloatingActionButton mFab;

  static class ViewHolder extends RecyclerView.ViewHolder {

    // For Posts
    private final TextView mAnswerDetails;
    private final TextView mAnswerBody;
    private final TextView mAnswerDate;
    private final TextView mReply;
    private final EditText mComment;
    private final TextView mDelete;
    private final LinearLayout replyLayout;
    private final RecyclerView mAnswerRV;
    private final Button like;
    private final TextView vote;
    AppCompatButton closeButton;

    // For Comments

    private final TextView mAddComment;
    private final TextView mClose;

    ViewHolder(@NonNull View itemView) {
      super(itemView);

      mAnswerDetails = itemView.findViewById(R.id.tv_answer_name);
      mAnswerBody = itemView.findViewById(R.id.tv_answer_body);
      mAnswerRV = itemView.findViewById(R.id.rv_comments);
      mAnswerDate = itemView.findViewById(R.id.tv_answer_date);
      mReply = itemView.findViewById(R.id.tvReply);
      mDelete = itemView.findViewById(R.id.tvDelete);
      replyLayout = itemView.findViewById(R.id.RG_answer_body2);
      mComment = itemView.findViewById(R.id.edit_comment_rv);
      mAddComment = itemView.findViewById(R.id.add_comment_post);
      mClose = itemView.findViewById(R.id.close_add_comment);
      like = itemView.findViewById(R.id.answer_like);
      vote = itemView.findViewById(R.id.tv_answer_vote);
      closeButton = itemView.findViewById(R.id.btn_close_1);
    }
  }

  public AnswerAdapter(ArrayList<Answer> answerList, Context context, Object e) {
    mAnswerList = answerList;
    mContext = context;
    mFab = ((FloatingActionButton) e);
  }

  @NonNull
  @NotNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_card, parent, false);

    return new AnswerAdapter.ViewHolder(view);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(@NonNull @NotNull AnswerAdapter.ViewHolder holder, int position) {
    Answer answer = mAnswerList.get(position);
    holder.mAnswerBody.setText(answer.getAnswer());
    holder.mAnswerDate.setText(answer.getDate());
    holder.vote.setText(String.valueOf(answer.getVote()));
    holder.mClose.setOnClickListener(
        close -> {
          holder.replyLayout.setVisibility(View.GONE);
          holder.mReply.setVisibility(View.VISIBLE);
          holder.mDelete.setVisibility(View.VISIBLE);
          // mFab.setVisibility(View.INVISIBLE);
          // This works
        });

    firebaseActions.getUserDetails(
        answer.getUID(),
        user -> holder.mAnswerDetails.setText(user.getName() + " " + user.getSurname()));

    String aid = answer.getAID();
    String uid = answer.getUID();

    firebaseActions.getComments(
        aid,
        c -> {
          if (c.size() >= 1) {
            ArrayList<Comment> commentArrayList = new ArrayList<>();
            for (Object d : c) {
              Comment k = (Comment) d;
              commentArrayList.add(k);
            }
            CommentsAdapter commentsAdapter = new CommentsAdapter(commentArrayList, mContext);
            LinearLayoutManager commentLayoutManager =
                new LinearLayoutManager(
                    holder.mAnswerRV.getContext(), LinearLayoutManager.VERTICAL, false);
            holder.mAnswerRV.setLayoutManager(commentLayoutManager);
            holder.mAnswerRV.setAdapter(commentsAdapter);
          }
        });

    firebaseActions.getPost(
        answer.getPID(),
        (post, user) -> {
          if (post.getUID().equals(currentUser)) holder.closeButton.setVisibility(View.VISIBLE);
        });

    holder.closeButton.setOnClickListener(
        b -> firebaseActions.markAnswer(answer.getPID(), answer.getAID()));

    holder.like.setOnClickListener(
        l -> {
          firebaseActions.upVoteAnswer(answer.getAID());
          Toast.makeText(mContext, "Like", Toast.LENGTH_SHORT).show();
        });

    holder.mReply.setOnClickListener(
        reply -> {
          holder.replyLayout.setVisibility(View.VISIBLE);
          holder.mReply.setVisibility(View.INVISIBLE);
          holder.mDelete.setVisibility(View.INVISIBLE);

          holder.mAddComment.setOnClickListener(
              add -> {
                String commentText = holder.mComment.getText().toString().trim();
                if (!commentText.equals(""))
                  firebaseActions.addComment(
                      new Comment(commentText, currentUser, answer.getAID()),
                      ac -> {
                        if (ac) {
                          holder.replyLayout.setVisibility(View.GONE);
                          holder.mReply.setVisibility(View.VISIBLE);
                          holder.mDelete.setVisibility(View.GONE);
                          holder.mComment.setText("");
                          firebaseActions.isCurrentUserAdmin(
                              (isAdmin, str) -> {
                                if (isAdmin || answer.getUID().equals(currentUser))
                                  holder.mDelete.setVisibility(View.VISIBLE);
                              });
                        }
                      });
                else
                  Toast.makeText(mContext, "Fill in the Comment section", Toast.LENGTH_SHORT)
                      .show();
              });
        });

    firebaseActions.isCurrentUserAdmin(
        (isAdmin, str) -> {
          if (isAdmin || answer.getUID().equals(currentUser)) {
            holder.mDelete.setVisibility(View.VISIBLE);
            holder.mDelete.setOnClickListener(
                c ->
                    firebaseActions.deleteAnswer(
                        answer.getAID(),
                        r -> Toast.makeText(mContext, "Answer Deleted", Toast.LENGTH_LONG).show()));
          }
        });

    holder.mAnswerDetails.setOnClickListener(
        v -> {
          Intent intent = new Intent(mContext, ViewProfileActivity.class);
          intent.putExtra("USER_ID", answer.getUID());

          mContext.startActivity(intent);
        });
  }

  @Override
  public int getItemCount() {
    return mAnswerList.size();
  }
}

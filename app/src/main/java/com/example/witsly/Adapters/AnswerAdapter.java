package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.FirebaseActions;
import com.example.witsly.Models.Comment;
import com.example.witsly.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

  private ArrayList<Comment> mAnswerList;
  private Context mContext;
  FirebaseActions firebaseActions = new FirebaseActions();

  static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mAnswerDetails;
    private TextView mAnswerBody;
    private TextView mAnswerDate;
    private RecyclerView mAnswerRV;

    ViewHolder(@NonNull View itemView) {
      super(itemView);

      mAnswerDetails = itemView.findViewById(R.id.tv_answer_name);
      mAnswerBody = itemView.findViewById(R.id.tv_answer_body);
      mAnswerRV = itemView.findViewById(R.id.rv_answers);
      mAnswerDate = itemView.findViewById(R.id.tv_answer_date);
    }
  }

  public AnswerAdapter(ArrayList<Comment> answerList, Context context) {
    mAnswerList = answerList;
    mContext = context;
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
    Comment comment = mAnswerList.get(position);
    holder.mAnswerBody.setText(comment.getAnswer());
    holder.mAnswerDate.setText(comment.getDate());
    firebaseActions.getUserDetails(
        comment.getUID(),
        user -> {
          holder.mAnswerDetails.setText(user.getName() + " " + user.getSurname());
        });
  }

  @Override
  public int getItemCount() {
    return mAnswerList.size();
  }
}

package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.FirebaseActions;
import com.example.witsly.Models.Answer;
import com.example.witsly.Models.Comment;
import com.example.witsly.PostAnswer;
import com.example.witsly.R;
import com.google.firebase.database.annotations.NotNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

  private final ArrayList<Answer> mAnswerList;
  private final FirebaseActions firebaseActions = new FirebaseActions();
  private Context mContext;

  static class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView mAnswerDetails;
    private final TextView mAnswerBody;
    private final TextView mAnswerDate;
    private final TextView mReply;
    private RecyclerView mAnswerRV;
    private TextView mKebab;

    ViewHolder(@NonNull View itemView) {
      super(itemView);

      mAnswerDetails = itemView.findViewById(R.id.tv_answer_name);
      mAnswerBody = itemView.findViewById(R.id.tv_answer_body);
      mAnswerRV = itemView.findViewById(R.id.rv_comments);
      mAnswerDate = itemView.findViewById(R.id.tv_answer_date);
      mReply = itemView.findViewById(R.id.tvReply);
      mKebab = itemView.findViewById(R.id.kebab);

    }
  }



  public AnswerAdapter(ArrayList<Answer> answerList, Context context) {
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
    Answer answer = mAnswerList.get(position);
    holder.mAnswerBody.setText(answer.getAnswer());
    holder.mAnswerDate.setText(answer.getDate());
    firebaseActions.getUserDetails(
        answer.getUID(),
        user -> holder.mAnswerDetails.setText(user.getName() + " " + user.getSurname()));

    String aid = answer.getAid();
    firebaseActions.getComments(aid,
            c -> {
              Log.d("Size", "Comment Array Size: "  + c.size() + " Answer ID" + aid);
              if (c.size() >= 1){
                ArrayList<Comment> commentArrayList = new ArrayList<Comment>();
                for (Object d : c){
                  Comment k = (Comment)d;
                  commentArrayList.add(k);
                }
                CommentsAdapter commentsAdapter = new CommentsAdapter(commentArrayList, mContext);
                LinearLayoutManager commentLayoutManager = new LinearLayoutManager(holder.mAnswerRV.getContext(), LinearLayoutManager.VERTICAL, false);
                holder.mAnswerRV.setLayoutManager(commentLayoutManager);
                holder.mAnswerRV.setAdapter(commentsAdapter);
              }


            });

    holder.mReply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), PostAnswer.class));
      }
    });

    holder.mKebab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(mContext, holder.mKebab);
        popupMenu.inflate(R.menu.context_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
              case R.id.btn_edit:
                return true;
              case R.id.btn_delete:
                return true;
            }
            return false;
          }
        });
      }
    });

  }

  @Override
  public int getItemCount() {
    return mAnswerList.size();
  }
}

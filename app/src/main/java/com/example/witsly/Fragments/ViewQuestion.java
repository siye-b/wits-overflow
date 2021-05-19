package com.example.witsly.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Adapters.AnswerAdapter;
import com.example.witsly.FirebaseActions;
import com.example.witsly.Models.Comment;
import com.example.witsly.ProDialog;
import com.example.witsly.R;

import java.util.ArrayList;

public class ViewQuestion extends Fragment {
  private TextView title;
  private TextView body;
  private TextView details;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayout;
  private ArrayList<String> mAnswerList; // Change to model for answer
  private Button add_btn;
  private EditText add_comment;
  FirebaseActions firebaseActions;
  private String questionID, userID;

  @SuppressLint("SetTextI18n")
  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_view_question, container, false);

    ProDialog proDialog = new ProDialog(getActivity());

    Bundle bundle = getArguments();
    firebaseActions = new FirebaseActions();

    body = view.findViewById(R.id.tv_view_details);
    title = view.findViewById(R.id.tv_view_title);
    details = view.findViewById(R.id.tv_view_body);

    mRecyclerView = view.findViewById(R.id.rv_answers);
    add_btn = view.findViewById(R.id.add_comment_btn);
    add_comment = view.findViewById(R.id.add_comment_et);

    RecyclerView recyclerView = view.findViewById(R.id.rv_answers);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

    proDialog.start();

    if (bundle != null) {
      String postID = bundle.getString("postID");

      firebaseActions.getPost(
          postID,
          (post, user) -> {
            userID = post.getUid();
            body.setText(
                "Post by: "
                    + user.getName()
                    + " "
                    + user.getSurname()
                    + " on: "
                    + (post.getDate()).substring(0, 10));
            title.setText(post.getTitle());
            details.setText(post.getBody());
          });

      add_btn.setOnClickListener(
          v -> {
            firebaseActions.addComment(
                new Comment(add_comment.getText().toString().trim(), userID, postID),
                r -> {
                  if (r) {
                    add_comment.setText("");
                    Toast.makeText(getActivity(), "added", Toast.LENGTH_LONG).show();
                  } else {
                    Toast.makeText(getActivity(), "not added", Toast.LENGTH_LONG).show();
                  }
                });
          });

      firebaseActions.getComments(
          postID,
          comments -> {
            AnswerAdapter ans = new AnswerAdapter(comments, getActivity());
            mRecyclerView.setAdapter(ans);
            mRecyclerView.setLayoutManager(mRecyclerManager);
          });
    }

    proDialog.stop();

    return view;
  }
}

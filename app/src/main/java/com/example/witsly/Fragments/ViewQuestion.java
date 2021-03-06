package com.example.witsly.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.LoginActivity;
import com.example.witsly.Adapters.AnswerAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Answer;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;
import com.example.witsly.R;
import com.example.witsly.databinding.ForgotDialogBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;

public class ViewQuestion extends Fragment {

  private TextView title;
  private TextView body;
  private TextView details;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayout;
  private ArrayList<String> mAnswerList; // Change to model for answer
  private AppCompatButton add_btn, btn_question_closed ;
  private AppCompatEditText add_comment;

  private FirebaseActions firebaseActions;
  private String questionID, userID;
  private TextView vote;
  private AppCompatButton like, delete, mClose;
  private Boolean isAuthor;
  private FloatingActionButton fab;
  private RelativeLayout mHolder;
  private NestedScrollView nScrollView;
  private String reason;

  @SuppressLint("SetTextI18n")
  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_view_question, container, false);

    Bundle bundle = getArguments();
    firebaseActions = new FirebaseActions();
    FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

    body = view.findViewById(R.id.tv_view_details);
    title = view.findViewById(R.id.tv_view_title);
    details = view.findViewById(R.id.tv_view_body);

    vote = view.findViewById(R.id.txt_vote);
    like = view.findViewById(R.id.btn_like);
    delete = view.findViewById(R.id.btn_delete);
    btn_question_closed = view.findViewById(R.id.btn_question_closed);

    mRecyclerView = view.findViewById(R.id.rv_answers);
    add_btn = view.findViewById(R.id.add_comment_btn);
    add_comment = view.findViewById(R.id.add_comment_et);
    nScrollView = view.findViewById(R.id.scrollView2);

    fab = view.findViewById(R.id.btn_hide_show);
    mHolder = view.findViewById(R.id.txt);
    mClose = view.findViewById(R.id.btn_no);

    fab.setOnClickListener(
        v -> {
          mHolder.setVisibility(View.VISIBLE);
          add_comment.setFocusableInTouchMode(true);
          add_comment.requestFocus();
        });

    mClose.setOnClickListener(
        v -> {
          fab.setVisibility(View.VISIBLE);
          mHolder.setVisibility(View.GONE);
          add_comment.setText("");
        });



    add_comment.setOnFocusChangeListener(
        (v, hasFocus) -> {
          if (hasFocus) fab.setVisibility(View.INVISIBLE);
          else {
            fab.setVisibility(View.VISIBLE);
            mHolder.setVisibility(View.GONE);
            add_comment.setText("");
          }
        });
      if (bundle != null) {
          String postID = bundle.getString("postID");

          firebaseActions.getPost(
                  postID,
                  (post, user) -> {

                      firebaseActions.isCurrentUserAdmin(
                              (isAdmin, resp) -> {
                                  if (isAdmin) {
                                      btn_question_closed.setVisibility(View.VISIBLE);
                                      btn_question_closed.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              closeQuestion(postID, post);

                                          }
                                      }
                                      );
                                  }
                              });
                  });
      }
      if (bundle != null) {
          String postID = bundle.getString("postID");

          firebaseActions.getPost(
                  postID,
                  (post, user) -> {

                      if(!post.getReason().equals("")) {
                          Toast.makeText(getActivity(), "The Post Was Closed Reason Being : " + post.getReason(), Toast.LENGTH_LONG).show();
                          fab.setVisibility(View.INVISIBLE);
                      }
                  }
          );
      }
    assert mUser != null;

    @SuppressLint("CutPasteId")
    RecyclerView recyclerView = view.findViewById(R.id.rv_answers);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

    if (bundle != null) {
      String postID = bundle.getString("postID");

      firebaseActions.getPost(
          postID,
          (post, user) -> {
            userID = post.getUID();
            body.setText(
                "Post by: "
                    + user.getName()
                    + " "
                    + user.getSurname()
                    + " on: "
                    + (post.getDate()).substring(0, 10));
            title.setText(post.isSolved() ? post.getTitle() + " [SOLVED]" : post.getTitle());
            details.setText(post.getBody());
            vote.setText(String.valueOf(post.getVote()));


              // only the owner of the post can mark the question as solved

            if (mUser.getUid().equals(userID)) {}

            firebaseActions.isCurrentUserAdmin(
                (isAdmin, resp) -> {
                  if (isAdmin || mUser.getUid().equals(userID)) {
                    delete.setVisibility(View.VISIBLE);
                    delete.setOnClickListener(
                        dm -> {
                          ((FragmentActivity) view.getContext())
                              .getSupportFragmentManager()
                              .beginTransaction()
                              .replace(R.id.container_frag, new HomeFragment())
                              .commit();
                          firebaseActions.deletePost(
                              postID,
                              r ->
                                  Toast.makeText(getActivity(), "Post Deleted", Toast.LENGTH_LONG)
                                      .show());
                        });
                  }
                });
          });

      like.setOnClickListener(
          v -> {
            firebaseActions.upVotePost(postID, mUser.getUid());
          });

      add_btn.setOnClickListener(
          v -> {
            String comment = add_comment.getText().toString().trim();

            if (!comment.isEmpty()) {
                firebaseActions.addAnswer(
                        new Answer(comment, mUser.getUid(), postID),
                        r -> {
                            if (r) {
                                add_comment.setText("");
                                Toast.makeText(getActivity(), "added", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(getActivity(), "not added", Toast.LENGTH_SHORT).show();
                        });
            }
            else {

                Toast.makeText(getActivity(), "the comment section is empty YES", Toast.LENGTH_SHORT)
                        .show();
            }
          });

      firebaseActions.getAnswers(
          postID,
          answers -> {
            Collections.sort(answers, Answer.VoteComparator);
            AnswerAdapter ans = new AnswerAdapter(answers, getActivity(), fab);
            mRecyclerView.setAdapter(ans);
            mRecyclerView.setLayoutManager(mRecyclerManager);
          });

      details.setOnClickListener(
          new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Intent intent = new Intent(getContext(), ViewProfileActivity.class);
              // Add extra that goes to ViewProfileActivity
              // intent.putExtra("profID", userID);
              // startActivity(intent);
              Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
            }
          });
    }

    return view;
  }


  void closeQuestion(String piD, Post post){
      AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());

      ForgotDialogBinding binding =
              ForgotDialogBinding.inflate(LayoutInflater.from(getView().getContext()));
      builder.setView(binding.getRoot());
      binding.tvTitle.setText("Reason for closing:");
      binding.etForgotPW.setHint("Please provide a reason for closing the post.");
      builder.setPositiveButton(
              "Next",
              (dialog, which) -> {
                  reason = binding.etForgotPW.getText().toString().trim();
                  firebaseActions.ADDReason(reason,piD );
                  post.setReason(reason);
                  Toast.makeText(getActivity(), "Question closed Successfully ", Toast.LENGTH_SHORT).show();
                  dialog.dismiss();

              });

      builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

      builder.create();
      builder.show();
  }

}

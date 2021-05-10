package com.example.witsly.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;
import com.example.witsly.ProDialog;
import com.example.witsly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class ViewQuestion extends Fragment {
  private TextView title;
  private TextView body;
  private TextView details;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayout;
  private ArrayList<String> mAnswerList; // Change to model for answer
  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

  private Post post;
  private User user;

  @Override
  public View onCreateView(
      final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.activity_view_question, container, false);

    final ProDialog proDialog = new ProDialog(getActivity());

    final Bundle bundle = getArguments();

    body = view.findViewById(R.id.tv_view_details);
    title = view.findViewById(R.id.tv_view_title);
    details = view.findViewById(R.id.tv_view_body);

    proDialog.start();

    if (bundle != null) {
      final String postID = bundle.getString("postID");

      firebaseDatabase
          .getReference("Posts/" + postID)
          .addValueEventListener(
              new ValueEventListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull @NotNull final DataSnapshot snapshot) {
                  post = snapshot.getValue(Post.class);
                  assert post != null;
                  title.setText(post.getTitle());
                  details.setText(post.getBody());

                  firebaseDatabase
                      .getReference("Users/" + post.getUid())
                      .addValueEventListener(
                          new ValueEventListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDataChange(
                                @NonNull @NotNull final DataSnapshot snapshot) {
                              user = snapshot.getValue(User.class);
                              assert user != null;

                              body.setText(
                                  "Post by: "
                                      + user.getName()
                                      + " "
                                      + user.getSurname()
                                      + " on: "
                                      + (post.getDate()).substring(0, 10));
                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull final DatabaseError error) {}
                          });
                }

                @Override
                public void onCancelled(@NonNull @NotNull final DatabaseError error) {}
              });
    }
    proDialog.stop();
    mRecyclerView = view.findViewById(R.id.rv_answers);

    // Initialise everything similar to what has been done in HomeFragment

    return view;
  }
}

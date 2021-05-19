package com.example.witsly;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import com.example.witsly.Interfaces.AddComment;
import com.example.witsly.Interfaces.AddPost;
import com.example.witsly.Interfaces.GetAllPosts;
import com.example.witsly.Interfaces.GetComments;
import com.example.witsly.Interfaces.GetPost;
import com.example.witsly.Interfaces.UserDetails;
import com.example.witsly.Models.Comment;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseActions {
  private FirebaseDatabase firebaseDatabase;
  private ArrayList<Post> postArrayList;
  private ArrayList<Comment> commentsArrayList;

  public FirebaseActions() {
    firebaseDatabase = FirebaseDatabase.getInstance();
  }

  void addPost(Post post, AddPost a) {

    DatabaseReference rel = firebaseDatabase.getReference("Posts").push();

    rel.setValue(post)
        .addOnCompleteListener(
            c -> {
              if (c.isSuccessful()) a.processResponse(true, rel.getKey());
            })
        .addOnFailureListener(e -> a.processResponse(false, ""));
  }

  public void getPost(String postID, GetPost g) {

    firebaseDatabase
        .getReference("Posts/" + postID)
        .addValueEventListener(
            new ValueEventListener() {
              @SuppressLint("SetTextI18n")
              @Override
              public void onDataChange(@NotNull DataSnapshot snapshot) {
                Post post = snapshot.getValue(Post.class);
                assert post != null;
                getUserDetails(post.getUid(), user -> g.processResponse(post, user));
              }

              @Override
              public void onCancelled(@NotNull DatabaseError error) {}
            });
  }

  public void getAllPost(GetAllPosts g) {

    postArrayList = new ArrayList<>();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Posts");
    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            postArrayList.clear();
            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

              Post post = postSnapshot.getValue(Post.class);
              assert post != null;
              post.setPostID(postSnapshot.getKey());
              postArrayList.add(post);
            }
            Collections.sort(postArrayList, Post.VoteComparator);
            g.processResponse(postArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void getComments(String postID, GetComments c) {

    commentsArrayList = new ArrayList<>();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Comments");
    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            commentsArrayList.clear();

            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

              Comment comment = postSnapshot.getValue(Comment.class);

              if (comment != null && comment.getQID().equals(postID)) {
                commentsArrayList.add(comment);
              }
            }
            c.processResponse(commentsArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void addComment(Comment comment, AddComment a) {
    firebaseDatabase
        .getReference("Comments")
        .push()
        .setValue(comment)
        .addOnCompleteListener(
            c -> {
              if (c.isSuccessful()) a.processResponse(true);
            })
        .addOnFailureListener(e -> a.processResponse(false));
  }

  public void getUserDetails(String user, UserDetails f) {
    DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
    mDatabaseReference
        .child(user)
        .addListenerForSingleValueEvent(
            new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                User value = snapshot.getValue(User.class);
                f.processResponse(value);
              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {}
            });
  }
}

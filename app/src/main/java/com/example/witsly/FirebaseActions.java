package com.example.witsly;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.witsly.Interfaces.AddAnswer;
import com.example.witsly.Interfaces.AddComment;
import com.example.witsly.Interfaces.AddPost;
import com.example.witsly.Interfaces.AddTag;
import com.example.witsly.Interfaces.GetAllPosts;
import com.example.witsly.Interfaces.GetAnswers;
import com.example.witsly.Interfaces.GetComments;
import com.example.witsly.Interfaces.GetPost;
import com.example.witsly.Interfaces.GetTags;
import com.example.witsly.Interfaces.UpdateVote;
import com.example.witsly.Interfaces.UserDetails;
import com.example.witsly.Interfaces.VoteCount;
import com.example.witsly.Interfaces.Voted;
import com.example.witsly.Interfaces.getTag;
import com.example.witsly.Interfaces.getVoteStatus;
import com.example.witsly.Models.Answer;
import com.example.witsly.Models.Comment;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.Tag;
import com.example.witsly.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class FirebaseActions {
  private static final String TAG = "LOG";
  private FirebaseDatabase firebaseDatabase;
  private ArrayList<Post> postArrayList;
  private ArrayList<Answer> answersArrayList;
  private ArrayList<Comment> commentsArrayList;
  private ArrayList<Tag> tagArrayList;
  private int likescount, dislikecount;
  private DatabaseReference dbRefLikes, dbRefDislikes;

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

              getTag(
                  post.getTag(),
                  p -> {
                    post.setTag("");
                    post.setTag(p);
                  });

              post.setPostID(postSnapshot.getKey());

              postArrayList.add(post);
            }
            g.processResponse(postArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void getComments(String AnswerID, GetComments c) {
    commentsArrayList = new ArrayList<>();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Comments");
    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            commentsArrayList.clear();

            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

              Comment comment = postSnapshot.getValue(Comment.class);
              comment.setCID(postSnapshot.getKey());

              if (comment != null && comment.getAID().equals(AnswerID))
                commentsArrayList.add(comment);
            }
            c.processResponse(commentsArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void getAnswers(String postID, GetAnswers a) {

    answersArrayList = new ArrayList<>();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Answers");
    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            answersArrayList.clear();

            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

              Answer answer = postSnapshot.getValue(Answer.class);
              String aid = postSnapshot.getKey();
              answer.setAid(aid);

              if (answer != null && answer.getQID().equals(postID)) answersArrayList.add(answer);
            }
            a.processResponse(answersArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void addAnswer(Answer answer, AddAnswer a) {
    firebaseDatabase
        .getReference("Answers")
        .push()
        .setValue(answer)
        .addOnCompleteListener(
            c -> {
              if (c.isSuccessful()) a.processResponse(true);
            })
        .addOnFailureListener(
            e -> {
              a.processResponse(false);
              Log.d(TAG, e.getMessage());
            });
  }

    public void addComment(Comment comment, AddComment a){
        firebaseDatabase
                .getReference("Comments")
                .push()
                .setValue(comment)
                .addOnCompleteListener(
                        c -> {
                            if (c.isSuccessful()) a.processResponse(true);
                        })
                .addOnFailureListener(
                        e -> {
                            a.processResponse(false);
                            Log.d(TAG, e.getMessage());
                        }
                );
    }

  public void upVote(String pid, String uid) {

    DatabaseReference likes, dislikes;
    likes = firebaseDatabase.getReference("Likes").child(pid).child(uid);
    dislikes = firebaseDatabase.getReference("Dislikes").child(pid).child(uid);

    dislikes.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

            if (snapshot.exists()) dislikes.removeValue();
            else likes.setValue(true);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void downVote(String pid, String uid) {

    DatabaseReference likes, dislikes;
    likes = firebaseDatabase.getReference("Likes").child(pid).child(uid);
    dislikes = firebaseDatabase.getReference("Dislikes").child(pid).child(uid);

    likes.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

            if (snapshot.exists()) likes.removeValue();
            else dislikes.setValue(true);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  private void Liked(String pid, String uid, Voted vs) {
    DatabaseReference likes = firebaseDatabase.getReference("Likes").child(pid).child(uid);

    likes.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            vs.processResponse(snapshot.exists());
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  private void Disliked(String pid, String uid, Voted vs) {
    DatabaseReference dislikes = firebaseDatabase.getReference("Dislikes").child(pid).child(uid);

    dislikes.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

            vs.processResponse(snapshot.exists());
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void getPostVoteState(String pid, String uid, getVoteStatus g) {

    Liked(
        pid,
        uid,
        v -> {
          if (v) g.processResponse(0);
        });

    Disliked(
        pid,
        uid,
        v -> {
          if (v) g.processResponse(2);
        });

    g.processResponse(1);
  }

  public void addTag(Tag tag, AddTag t) {

    DatabaseReference rel = firebaseDatabase.getReference("Tags").push();

    rel.setValue(tag)
        .addOnCompleteListener(
            c -> {
              if (c.isSuccessful()) t.processResponse(rel.getKey());
            })
        .addOnFailureListener(e -> t.processResponse(null));
  }

  public void getTag(String tid, getTag sTag) {
    firebaseDatabase
        .getReference("Tags/" + tid)
        .addValueEventListener(
            new ValueEventListener() {
              @SuppressLint("SetTextI18n")
              @Override
              public void onDataChange(@NotNull DataSnapshot snapshot) {
                Tag tag = snapshot.getValue(Tag.class);
                assert tag != null;
                sTag.processResponse(tag.getTag());
              }

              @Override
              public void onCancelled(@NotNull DatabaseError error) {}
            });
  }

  public void getTags(GetTags t) {
    tagArrayList = new ArrayList<>();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Tags");
    databaseReference.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            tagArrayList.clear();
            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

              Tag tag = postSnapshot.getValue(Tag.class);
              assert tag != null;
              tag.setTagID(postSnapshot.getKey());
              tagArrayList.add(tag);
            }
            t.processResponse(tagArrayList);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  private void CountVotes(String pid, VoteCount cv) {

    dbRefLikes = FirebaseDatabase.getInstance().getReference("Likes");

    dbRefDislikes = FirebaseDatabase.getInstance().getReference("Dislikes");

    dbRefLikes.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

            if (snapshot.exists()) {

              likescount = (int) snapshot.child(pid).getChildrenCount();

              dbRefDislikes.addValueEventListener(
                  new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                      if (snapshot.exists()) {

                        dislikecount = (int) snapshot.child(pid).getChildrenCount();
                        cv.processResponse(likescount - dislikecount);
                      }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}
                  });
            }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  private void updateVotes(String pid, int vote_value, UpdateVote updateVote) {
    DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("Posts").child(pid);
    updateData
        .child("vote")
        .setValue(vote_value)
        .addOnCompleteListener(
            task -> {
              updateVote.processResponse(true);
            })
        .addOnFailureListener(e -> updateVote.processResponse(false));
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

  public void deletePost(String postKey, String databaseUid, String currentUid) {
    DatabaseReference clickPost = firebaseDatabase.getReference().child("Posts").child(postKey);
    clickPost.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            // must iterate over comments to delete them all
            // deleteComment();
            if (currentUid.equals(databaseUid)) clickPost.removeValue();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void deleteComment(
      String cid, String postKey, String rid, String currentUid, String databaseUid) {
    DatabaseReference commentRef = firebaseDatabase.getReference().child("Posts").child(postKey);

    commentRef.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (currentUid.equals(databaseUid)) {

              // must iterate over replies to delete them all
              deleteReply(rid, postKey, cid, currentUid, databaseUid);
              commentRef.child("Comments").child(cid).removeValue();
            }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }

  public void deleteReply(
      String cid, String postKey, String rid, String currentUid, String databaseUid) {
    DatabaseReference replyRef = firebaseDatabase.getReference().child("Posts").child(postKey);
    replyRef.child("Comments").child(cid);

    replyRef.addValueEventListener(
        new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (currentUid.equals(databaseUid)) replyRef.child("Answers").child(rid).removeValue();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {}
        });
  }
}

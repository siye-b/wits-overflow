package com.example.witsly.Firebase;

import com.example.witsly.Interfaces.FirebaseAuthHandler;
import com.example.witsly.Models.User;
import com.example.witsly.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseAuthentication {

  private final FirebaseAuth mAuth;
  FirebaseUser user;



    public FirebaseAuthentication() {
    mAuth = FirebaseAuth.getInstance();
  }

  public void logout(FirebaseAuthHandler r) {
    FirebaseAuth.getInstance().signOut();
    r.processAuth(true, "");
  }

  public void login(String email, String password, FirebaseAuthHandler f) {

    mAuth
        .signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(
            task -> {
              if (task.isSuccessful())
                if (mAuth.getCurrentUser().isEmailVerified()) f.processAuth(true, "Login ");
                else {

                  f.processAuth(false, "Pleas verify account in the link sent to email");
                  FirebaseAuth.getInstance().signOut();
                }
            })
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }

  public void resetPassword(String email, FirebaseAuthHandler f) {
    mAuth
        .sendPasswordResetEmail(email)
        .addOnSuccessListener(aVoid -> f.processAuth(true, null))
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }

  public void register(
      String email, String name, String surname, String password, FirebaseAuthHandler f) {

    mAuth
        .createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(
            task -> {
              if (task.isSuccessful())
                addUser(
                    email,
                    name,
                    surname,
                    (response, msg) -> {
                      if (response) {
                        user = mAuth.getCurrentUser();
                        assert user != null;
                        user.sendEmailVerification()
                            .addOnCompleteListener(
                                s -> {
                                  f.processAuth(true, msg);
                                });
                        FirebaseAuth.getInstance().signOut();

                      } else f.processAuth(false, msg);
                    });
            })
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }

  private void addUser(String email, String name, String surname, FirebaseAuthHandler f) {
    User user = new User(name, surname, email);
    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();

    mFirebaseDatabase
        .getReference("Users")
        .child(mAuth.getCurrentUser().getUid())
        .setValue(user)
        .addOnCompleteListener(
            task1 -> {
              f.processAuth(true, "User registered");
            })
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }
}

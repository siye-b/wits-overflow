package com.example.witsly.Firebase;

import com.example.witsly.Interfaces.FirebaseAuthHandler;
import com.example.witsly.Interfaces.LoginHandler;
import com.example.witsly.Models.User;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class FirebaseAuthentication {

  private final FirebaseAuth mAuth;

  public FirebaseAuthentication() {
    mAuth = FirebaseAuth.getInstance();
  }

  public String getUID() {

    return mAuth.getCurrentUser().getUid();
  }

  public void sendVerificationEmail() {
    Objects.requireNonNull(mAuth.getCurrentUser()).sendEmailVerification();
  }

  public void logout() {
    FirebaseAuth.getInstance().signOut();
  }

  private Boolean isVerified() {
    return mAuth.getCurrentUser().isEmailVerified();
  }

  public void login(String email, String password, LoginHandler f) {
    mAuth
        .signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(
            task -> {
              if (task.isSuccessful()) if (isVerified()) f.processAuth(0, "Logging in");
              else
                f.processAuth(1, "Account not verified");
            })
        .addOnFailureListener(e -> f.processAuth(2, e.getMessage()));
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
              if (task.isSuccessful()) addUser(
                      email,
                      name,
                      surname,
                      (response, msg) -> {
                        if (response) {
                          sendVerificationEmail();
                          logout();
                          f.processAuth(true, msg);

                        } else f.processAuth(false, msg);
                      });
            })
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }

  private void addUser(String email, String name, String surname, FirebaseAuthHandler f) {
    User user = new User(name, surname, email);
    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();

    mFirebaseDatabase
        .getReference(FirebaseUtils.USERS)
        .child(mAuth.getCurrentUser().getUid())
        .setValue(user)
        .addOnCompleteListener(
            task1 -> {
              f.processAuth(true, FirebaseUtils.USER_REGISTERED);
            })
        .addOnFailureListener(e -> f.processAuth(false, e.getMessage()));
  }
}

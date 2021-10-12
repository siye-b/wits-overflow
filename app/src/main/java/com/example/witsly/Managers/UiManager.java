package com.example.witsly.Managers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.witsly.Activities.LoginActivity;
import com.example.witsly.Activities.MainActivity;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Firebase.FirebaseAuthentication;
import com.example.witsly.Utils.FirebaseUtils;
import com.example.witsly.Utils.UserUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

public class UiManager {
  private static final FirebaseActions firebaseActions = new FirebaseActions();
  private static final FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();

  public static void logIn(Context context) {
    UserManager.userManager(context);
    firebaseActions.getUser(
        (user, bool) -> {
          if (bool) {
            UserManager.setUser(user);
            Toast.makeText(context, UserUtils.LOGIN_SUCCESSFUL, Toast.LENGTH_LONG).show();
            context.startActivity(
                new Intent(context, MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
          } else Toast.makeText(context, UserUtils.LOGIN_FAILED, Toast.LENGTH_LONG).show();
        });
  }

  public static void logOut(Context context) {
    UserManager.userManager(context);

    firebaseAuthentication.logout();
    UserManager.logOut(context);
    context.startActivity(
        new Intent(context, LoginActivity.class)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
  }

  public static void uploadImage(Context context, Uri uri, ImageView view) {
    UserManager.userManager(context);
    firebaseActions.uploadPicture(
        uri,
        link -> {
          UserManager.updateImage(link);
          Picasso.get().load(link).into(view);
          Toast.makeText(context, FirebaseUtils.IMG_UPLOADED, Toast.LENGTH_LONG).show();
        });
  }

  public static void setUserProfile(
      Context context,
      TextInputEditText name,
      TextInputEditText surname,
      TextInputEditText bio,
      ImageView imageView) {
    UserManager.userManager(context);
    bio.setText(UserManager.getBIO());
    name.setText(UserManager.getFirstName());
    surname.setText(UserManager.getLastName());

    if (!UserManager.getProfileImage().equals("")) {
      imageView.setBackground(null);
      Picasso.get().load(UserManager.getProfileImage()).into(imageView);
    }
  }

  public static void setImage(Context context, ImageView view) {
    UserManager.userManager(context);
    Picasso.get().load(UserManager.getProfileImage()).into(view);
  }

  public static void setFullName(Context context, TextView fullName) {
    UserManager.userManager(context);
    fullName.setText(String.format("%s %s", UserManager.getFirstName(), UserManager.getLastName()));
  }

  public static void setBio(Context context, TextInputEditText textEditText, TextView textView) {
    UserManager.userManager(context);

    if (textEditText != null) textEditText.setText(UserManager.getBIO());
    if (textView != null) textView.setText(UserManager.getBIO());
  }

  public static void setProfile(
      Context context,
      TextView fullName,
      TextView email,
      TextView reputation,
      TextView bio,
      ImageView imageView) {
    UserManager.userManager(context);
    fullName.setText(String.format("%s %s", UserManager.getFirstName(), UserManager.getLastName()));
    email.setText(UserManager.getEMAIL());
    reputation.setText(UserManager.getReputation());
    bio.setText(UserManager.getBIO());

    if (!UserManager.getProfileImage().equals("")) {
      imageView.setBackground(null);
      Picasso.get().load(UserManager.getProfileImage()).into(imageView);
    }
  }

  public static void updateBio(Context context, TextInputEditText view, String bio) {
    UserManager.userManager(context);
    firebaseActions.UpdateBIO(
        bio,
        bool -> {
          if (bool) {
            UserManager.setBIO(bio);
            view.setText(bio);
            Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show();
          } else Toast.makeText(context, "Not updated", Toast.LENGTH_LONG).show();
        });
  }

  public static void updateUsername(
      Context context, TextInputEditText firstName, TextInputEditText lastName) {
    UserManager.userManager(context);
    if (!firstName.equals(UserManager.getFirstName())) {
      UserManager.setFirstName(firstName.getText().toString().trim());
      firebaseActions.SetName(firstName.getText().toString().trim());
    }
    if (!lastName.equals(UserManager.getFirstName())) {
      firebaseActions.SetSurname(firstName.getText().toString().trim());
      UserManager.setLastName(lastName.getText().toString().trim());
    }
  }
}

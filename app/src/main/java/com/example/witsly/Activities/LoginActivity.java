package com.example.witsly.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.witsly.Firebase.FirebaseAuthentication;
import com.example.witsly.Managers.UiManager;
import com.example.witsly.Managers.UserManager;
import com.example.witsly.ProDialog;
import com.example.witsly.R;
import com.example.witsly.Utils.UserUtils;
import com.example.witsly.Verifier;
import com.example.witsly.databinding.ForgotDialogBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

  public TextInputLayout loginEmail, loginPassword;
  private FirebaseAuth mAuth;
  public Button loginButton;
  public TextView tv_register, tv_forgotPW;
  private final FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();
  private final Verifier verifier = new Verifier();
  private final ProDialog proDialog = new ProDialog(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Intent intent1 = getIntent();

    mAuth = FirebaseAuth.getInstance();
    loginEmail = findViewById(R.id.til_email);
    loginPassword = findViewById(R.id.til_password);
    tv_register = findViewById(R.id.tv_register);
    tv_forgotPW = findViewById(R.id.tv_password);
    loginButton = findViewById(R.id.btn_singin);

    UserManager.userManager(this);

    if (UserManager.loggedIn()) {
      startActivity(
          new Intent(this, MainActivity.class)
              .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    if (intent1 != null) {
      String str = intent1.getStringExtra("email");
      loginEmail.getEditText().setText(str);
    }

    loginButton.setOnClickListener(
        login -> {
          String email = loginEmail.getEditText().getText().toString().trim();
          String password = loginPassword.getEditText().getText().toString().trim();
          if (validateFields(email, password)) {
            login(email, password);
          }
        });
    tv_register.setOnClickListener(
        tv__register -> {
          startActivity(new Intent(this, RegisterActivity.class));
        });
    tv_forgotPW.setOnClickListener(v -> resetPassword());
  }

  private boolean validateFields(String email, String password) {
    if (!verifier.verifyEmail(email) || !verifier.verifyPassword(password)) {
      Toast.makeText(
              this, "Please enter a valid email and password combination!", Toast.LENGTH_LONG)
          .show();
      return false;
    } else {
      return true;
    }
  }

  private void login(String email, String password) {

    proDialog.start();

    firebaseAuthentication.login(
        email,
        password,
        (response, msg) -> {
          if (response.equals(0)) {
            UiManager.logIn(this);
            proDialog.stop();
          } else if (response.equals(1)) {
            new AlertDialog.Builder(LoginActivity.this)
                .setTitle("Email verification")
                .setMessage(msg)
                .setPositiveButton(
                    "Resend link",
                    (dialogInterface, i) -> {
                      mAuth = FirebaseAuth.getInstance();
                      mAuth
                          .getCurrentUser()
                          .sendEmailVerification()
                          .addOnSuccessListener(
                              sent -> {
                                Toast.makeText(LoginActivity.this, "Link Sent", Toast.LENGTH_LONG)
                                    .show();
                              })
                          .addOnFailureListener(
                              failure ->
                                  Toast.makeText(
                                          LoginActivity.this, "Link not sent", Toast.LENGTH_LONG)
                                      .show());

                      loginPassword.getEditText().getText().clear();
                      firebaseAuthentication.logout();
                      Toast.makeText(LoginActivity.this, "Link Sent", Toast.LENGTH_LONG).show();
                    })
                .setNegativeButton(
                    UserUtils.DISMISS, (dialogInterface, i) -> dialogInterface.dismiss())
                .create()
                .show();
          }
        });
  }

  private void resetPassword() {
    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

    ForgotDialogBinding binding =
        ForgotDialogBinding.inflate(LayoutInflater.from(LoginActivity.this));
    builder.setView(binding.getRoot());

    builder.setPositiveButton(
        "Next",
        (dialog, which) -> {
          String email = binding.etForgotPW.getText().toString().trim();

          firebaseAuthentication.resetPassword(
              email,
              (response, msg) -> {
                if (response) {
                  Toast.makeText(
                          LoginActivity.this, UserUtils.RESET_LINK_SENT + email, Toast.LENGTH_LONG)
                      .show();
                } else {
                  Toast.makeText(
                          LoginActivity.this, UserUtils.RESET_LINK_NOT_SENT, Toast.LENGTH_LONG)
                      .show();
                }
              });

          dialog.dismiss();
        });

    builder.setNegativeButton(UserUtils.CANCEL, (dialog, which) -> dialog.dismiss());

    builder.create();
    builder.show();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}

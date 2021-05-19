package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.witsly.databinding.ForgotDialogBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

  TextInputLayout loginEmail, loginPassword;
  private FirebaseAuth mAuth;
  private TextView tv_register, tv_forgotPW;
  Button loginButton;
  private FirebaseUser mUser;
  private FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Intent intent1 = getIntent();

    mAuth = FirebaseAuth.getInstance();
    mUser = mAuth.getCurrentUser();
    loginEmail = findViewById(R.id.til_email);
    loginPassword = findViewById(R.id.til_password);
    tv_register = findViewById(R.id.tv_register);
    tv_forgotPW = findViewById(R.id.tv_password);
    loginButton = findViewById(R.id.btn_singin);

    if (mUser != null)
      startActivity(
          new Intent(this, MainActivity.class)
              .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    if (intent1 != null) {
      String str = intent1.getStringExtra("email");
      loginEmail.getEditText().setText(str);
    }
    loginButton.setOnClickListener(
        login -> {
          String email = loginEmail.getEditText().getText().toString().trim();
          String password = loginPassword.getEditText().getText().toString().trim();
          login(email, password);
        });
    tv_register.setOnClickListener(
        tv__register -> {
          startActivity(new Intent(this, RegisterActivity.class));
        });
    tv_forgotPW.setOnClickListener(v -> resetPassword());
  }

  private void login(String email, String password) {

    firebaseAuthentication.login(
        email,
        password,
        (response, msg) -> {
          if (response) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            startActivity(
                new Intent(this, MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
          } else Toast.makeText(this, "" + "Login failed", Toast.LENGTH_SHORT).show();
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
                if (response)
                  Toast.makeText(
                          LoginActivity.this,
                          "Reset link is sent to your email: " + email,
                          Toast.LENGTH_LONG)
                      .show();
                else
                  Toast.makeText(
                          LoginActivity.this, "ERROR ! Reset link is not sent ,", Toast.LENGTH_LONG)
                      .show();
              });

          dialog.dismiss();
        });

    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

    builder.create();
    builder.show();
  }
}

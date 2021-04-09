package com.example.witsly;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

    private TextInputLayout loginEmail, loginPassword;
    private FirebaseAuth mAuth;
    private TextView tv_register, tv_forgotPW;
    FirebaseUser mUser;


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
        Button loginButton = findViewById(R.id.btn_singin);

        if (mUser != null) {
            startActivity(new Intent(this,MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
        if (intent1 != null) {
            String str = intent1.getStringExtra("email");
            loginEmail.getEditText().setText(str);
        }
        loginButton.setOnClickListener(login -> {
            String email = loginEmail.getEditText().getText().toString().trim();
            String password = loginPassword.getEditText().getText().toString().trim();
            login(email, password);
        });
        tv_register.setOnClickListener(tv__register -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
        tv_forgotPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void login(String email, String password1) {
        mAuth.signInWithEmailAndPassword(email, password1)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, MainActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private void resetPassword(){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

        ForgotDialogBinding binding = ForgotDialogBinding.inflate(LayoutInflater.from(LoginActivity.this));
        builder.setView(binding.getRoot());

        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Enter code for firebase here
                String email = binding.etForgotPW.getText().toString().trim();
                Toast.makeText(LoginActivity.this, "Email is " + email, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create();
        builder.show();
    }
}
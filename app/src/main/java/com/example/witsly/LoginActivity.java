package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout loginEmail, loginPassword;
    private FirebaseAuth mAuth;
    private TextView tv_register;
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
        Button loginButton = findViewById(R.id.btn_singin);

        if (mUser != null) {
            startActivity(new Intent(this,MainActivity.class));
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
    }

    private void login(String email, String password1) {
        mAuth.signInWithEmailAndPassword(email, password1)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, MainActivity.class));
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
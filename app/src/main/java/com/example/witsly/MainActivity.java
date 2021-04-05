package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.witsly.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    private TextInputLayout loginEmail, loginPassword;
    private FirebaseAuth mAuth;


    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent1 = getIntent();


        mAuth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.til_email);
        loginPassword = findViewById(R.id.til_password);
        Button loginButton = findViewById(R.id.btn_singin);


        if (intent1 != null) {
            String str = intent1.getStringExtra("email");
            loginEmail.getEditText().setText(str);
        }


        loginButton.setOnClickListener(login -> {
            String email = loginEmail.getEditText().getText().toString().trim();
            String password = loginPassword.getEditText().getText().toString().trim();

            if(validateFields(email, password, loginEmail, loginPassword)){
                login(email, password);
            }
        });

        binding.tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void login(String email, String password1) {
        mAuth.signInWithEmailAndPassword(email, password1)
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, HomeActivity.class));
                    }
                }).addOnFailureListener(e -> Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());

    }

    private boolean validateFields(String email, String password, TextInputLayout emailField, TextInputLayout passwordField){
        if (TextUtils.isEmpty(email)) {
            loginEmail.setError("Email address is required!");
            loginPassword.setError(null);
            return false;
        } else if (TextUtils.isEmpty(password)) {
            loginEmail.setError(null);
            loginPassword.setError("Password is required!");
            return false;
        } else {
            loginEmail.setError(null);
            loginPassword.setError(null);
            return true;
        }
    }

}
package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.witsly.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText regEmail, regPasswordOne, regPasswordTwo;
    private FirebaseAuth mAuth;


    private static final Pattern EMAIL_ADDRESS =
            Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + //between 1 and 256 characters which contain alphanumeric characters and certain acceptable symbols
                            "\\@" + //@ sign
                            "(students.wits.ac.za|wits.ac.za)" //two Wits associated domains
            );


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any upper or lower case letter
                    "(?=.*[@#$%^&+=!])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$"
            );

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
        regEmail = findViewById(R.id.et_email);
        regPasswordOne = findViewById(R.id.et_password);
        regPasswordTwo = findViewById(R.id.et_verify_password);
        Button regButton = findViewById(R.id.btn_signup);


        regButton.setOnClickListener(reg_btn -> {
            String email = regEmail.getText().toString().trim();
            String password1 = regPasswordOne.getText().toString().trim();
            String password2 = regPasswordTwo.getText().toString().trim();
            if (password1.equals(password2)) {
                registerUser(email, password1);
            } else {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show();
            }

        });


    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("email", regEmail.getText().toString());
                        startActivity(intent);
                    }
                }).addOnFailureListener(e -> Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show());

    }
}

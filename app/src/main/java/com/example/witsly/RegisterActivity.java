package com.example.witsly;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.witsly.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout regEmail, regPasswordOne, regPasswordTwo;
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
        regEmail = findViewById(R.id.til_email);
        regPasswordOne = findViewById(R.id.til_password);
        regPasswordTwo = findViewById(R.id.til_verify_pass);
        Button regButton = findViewById(R.id.btn_signup);


        regButton.setOnClickListener(reg_btn -> {
            String email = regEmail.getEditText().getText().toString().trim();
            String password1 = regPasswordOne.getEditText().getText().toString().trim();
            String password2 = regPasswordTwo.getEditText().getText().toString().trim();
            if (validateFields(email, password1, password2, regEmail, regPasswordOne, regPasswordTwo)){
                registerUser(email, password1);
            }

        });


    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("email", regEmail.getEditText().getText().toString());
                        startActivity(intent);
                    }
                }).addOnFailureListener(e -> Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show());
    }

    private boolean validateFields(String email, String password1, String password2, TextInputLayout emailField, TextInputLayout passwordField1, TextInputLayout passwordField2){
        if(!EMAIL_ADDRESS.matcher(email).matches()){
            emailField.setError("Please use a valid Wits email address!");
            passwordField1.setError(null);
            passwordField2.setError(null);
            return false;
        }else if(!PASSWORD_PATTERN.matcher(password1).matches()){
            passwordField1.setError("Please choose a stronger password!");
            emailField.setError(null);
            passwordField2.setError(null);
            return false;
        }else if(!password2.equals(password1)){
            emailField.setError(null);
            passwordField1.setError(null);
            passwordField2.setError("Passwords do not match!");
            return false;
        }else{
            emailField.setError(null);
            passwordField1.setError(null);
            passwordField2.setError(null);
            return true;
        }
    }

}

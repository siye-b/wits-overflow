package com.example.witsly.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.witsly.Firebase.FirebaseAuthentication;
import com.example.witsly.R;
import com.example.witsly.Verifier;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

	public TextInputLayout regName, regSurname, regEmail, regPasswordOne, regPasswordTwo;
	public TextView tv_register;
	public AppCompatButton regButton;
	public Verifier verifier = new Verifier();

	private final FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		regName = findViewById(R.id.til_name);
		regSurname = findViewById(R.id.til_surname);
		regEmail = findViewById(R.id.til_email);
		regPasswordOne = findViewById(R.id.til_password);
		regPasswordTwo = findViewById(R.id.til_verify_pass);
		tv_register = findViewById(R.id.tv_register);
		regButton = findViewById(R.id.btn_signup);

		regButton.setOnClickListener(
				reg_btn -> {
					String name = regName.getEditText().getText().toString().trim();
					String surname = regSurname.getEditText().getText().toString().trim();
					String email = regEmail.getEditText().getText().toString().trim();
					String password1 = regPasswordOne.getEditText().getText().toString().trim();
					String password2 = regPasswordTwo.getEditText().getText().toString().trim();
					if (validateFields(email, password1, password2, name, surname, regEmail, regPasswordOne, regPasswordTwo))
						registerUser(name, surname, email, password1);
				});

		tv_register.setOnClickListener(
				v -> {
					Intent intent = new Intent(this, LoginActivity.class);
					startActivity(intent);
				});
	}

	// Register user
	private void registerUser(String name, String surname, String email, String password) {

		firebaseAuthentication.register(
				email,
				name,
				surname,
				password,
				(response, msg) -> {
					if (response) {

						Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(this, LoginActivity.class);
						intent.putExtra("email", regEmail.getEditText().getText().toString());
						startActivity(intent);
					} else {
						Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
						startActivity(new Intent(this, LoginActivity.class));
					}
				});
	}

	public boolean validateFields(
			String email,
			String password1,
			String password2,
			String name,
			String surname,
			TextInputLayout emailField,
			TextInputLayout passwordField1,
			TextInputLayout passwordField2) {

		if(name.length() < 1 || surname.length() < 1){
			Toast.makeText(this, "Please enter a Name and/or Surname", Toast.LENGTH_SHORT).show();
			return false;
		}

		if (!verifier.verifyEmail(email)) {
			emailField.setError("Please use a valid Wits email address!");
			passwordField1.setError(null);
			passwordField2.setError(null);
			return false;
		} else if (!verifier.verifyPassword(password1)) {
			passwordField1.setError("Password must be at least be 8 characters long and contain at least " +
					"1 Uppercase letter, 1 Lowercase letter, 1 Special character, and 1 Digit!");
			emailField.setError(null);
			passwordField2.setError(null);
			return false;
		} else if (!password2.equals(password1)) {
			emailField.setError(null);
			passwordField1.setError(null);
			passwordField2.setError("Passwords do not match!");
			return false;
		} else {
			emailField.setError(null);
			passwordField1.setError(null);
			passwordField2.setError(null);
			return true;
		}

	}
}

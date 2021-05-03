package com.example.witsly;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class PostActivity extends AppCompatActivity {

    private TextInputLayout title, body;
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase mFirebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("New Post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.textInputLayoutTitle);
        body = findViewById(R.id.textInputLayoutBody);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.post_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.btn_post:
                String postTitle = Objects.requireNonNull(title.getEditText()).getText().toString().trim();
                String postBody = Objects.requireNonNull(body.getEditText()).getText().toString().trim();

                if (!TextUtils.isEmpty(postBody) || !TextUtils.isEmpty(postTitle))
                    addPost(postTitle, postBody);
                else
                    Toast.makeText(this, "fill in all the fields", Toast.LENGTH_LONG).show();


        }
        return super.onOptionsItemSelected(item);
    }


    private void addPost(String title, String body) {
        mFirebaseDatabase = FirebaseDatabase.getInstance();


        Post post = new Post(title, body, mAuth.getCurrentUser().getUid());

        mFirebaseDatabase.getReference("Posts").push().setValue(post)
                .addOnCompleteListener(c -> {
                    if (c.isSuccessful()) {
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();

                        /**
                         * After adding a question a user should be taken somewhere
                         * please implement this
                         */

                    } else {
                        Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(e -> Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());


    }
}

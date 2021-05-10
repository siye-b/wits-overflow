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
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.witsly.Fragments.ViewQuestion;
import com.example.witsly.Models.Post;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PostActivity extends AppCompatActivity {

  private TextInputLayout title, body;
  private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private ChipGroup cGroup;
  private List<String> mTagList;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);
    final Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);
    Objects.requireNonNull(getSupportActionBar()).setTitle("New Post");
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    cGroup = findViewById(R.id.chip_group);
    mTagList = Arrays.asList(getResources().getStringArray(R.array.tags));

    for (int i = 0; i < mTagList.size(); ++i) {
      final Chip chip = new Chip(this);
      chip.setText(mTagList.get(i).trim());
      chip.setCheckable(true);
      chip.setCheckedIconVisible(true);
      chip.setId(ViewCompat.generateViewId());
      cGroup.addView(chip);
    }

    title = findViewById(R.id.textInputLayoutTitle);
    body = findViewById(R.id.textInputLayoutBody);
  }

  @Override
  public boolean onCreateOptionsMenu(final Menu menu) {
    final MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.post_menu, menu);
    return true;
  }

  @SuppressLint("NonConstantResourceId")
  @Override
  public boolean onOptionsItemSelected(final MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;

      case R.id.btn_post:
        final String postTitle =
            Objects.requireNonNull(title.getEditText()).getText().toString().trim();
        final String postBody =
            Objects.requireNonNull(body.getEditText()).getText().toString().trim();

        if (!TextUtils.isEmpty(postBody) || !TextUtils.isEmpty(postTitle))
          addPost(postTitle, postBody);
        else Toast.makeText(this, "fill in all the fields", Toast.LENGTH_LONG).show();
    }
    return super.onOptionsItemSelected(item);
  }

  private void addPost(final String title, final String body) {
    final FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();

    final Post post =
        new Post(title, body, Objects.requireNonNull(mAuth.getCurrentUser()).getUid());

    final DatabaseReference rel = mFirebaseDatabase.getReference("Posts").push();

    rel.setValue(post)
        .addOnCompleteListener(
            c -> {
              if (c.isSuccessful()) {

                final Bundle bundle = new Bundle();
                bundle.putString("title", rel.getKey());

                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                final Fragment viewQuestion = new ViewQuestion();
                viewQuestion.setArguments(bundle);
                final FragmentTransaction transaction =
                    getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container_frag, viewQuestion);
                transaction.addToBackStack(null);
                transaction.commit();

              } else {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT)
                    .show();
              }
            })
        .addOnFailureListener(
            e -> Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());
  }
}

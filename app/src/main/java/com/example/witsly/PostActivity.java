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

import com.example.witsly.Models.Post;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class PostActivity extends AppCompatActivity {

  private TextInputLayout title, body;
  private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private ChipGroup cGroup;
  private List<String> mTagList;
  private final FirebaseActions firebaseActions = new FirebaseActions();

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);
    final Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);
    (getSupportActionBar()).setTitle("New Post");
    (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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
        final String postTitle = (title.getEditText()).getText().toString().trim();
        final String postBody = (body.getEditText()).getText().toString().trim();
        //final String tag = cGroup.getTag().toString().trim();

        int i = cGroup.getCheckedChipId();
        Chip chip = (Chip)cGroup.getChildAt(i - 1);
        final String tag = chip.getText().toString().trim();




        if (!TextUtils.isEmpty(postBody) || !TextUtils.isEmpty(postTitle) || !TextUtils.isEmpty(tag)) {
          addPost(postTitle, postBody, tag);
        }else Toast.makeText(this, "fill in all the fields", Toast.LENGTH_LONG).show();
    }
    return super.onOptionsItemSelected(item);
  }

  private void addPost(final String title, final String body, final String tag) {

    final Post post = new Post(title, body, tag, mAuth.getCurrentUser().getUid());

    firebaseActions.addPost(
        post,
        (added, key) -> {
          if (added) {

          } else
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT)
                .show();
        });
  }
}

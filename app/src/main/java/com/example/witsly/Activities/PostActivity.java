package com.example.witsly.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.Tag;
import com.example.witsly.R;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

  public TextInputLayout title, body;
  private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private final FirebaseActions firebaseActions = new FirebaseActions();
  public MaterialAutoCompleteTextView tagInput;
  private ArrayList<Tag> mTags;
  Tag tag;
  String topic;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);
    Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);
    (getSupportActionBar()).setTitle("New Post");
    (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    Intent i = getIntent();
    topic = i.getStringExtra("topic");

    tagInput = findViewById(R.id.tagInput);
    title = findViewById(R.id.textInputLayoutTitle);
    body = findViewById(R.id.textInputLayoutBody);

    firebaseActions.getTags(
        tags -> {
          ArrayAdapter<Tag> arrayAdapter =
              new ArrayAdapter<Tag>(this, android.R.layout.simple_list_item_1, tags);
          tagInput.setAdapter(arrayAdapter);
          mTags = tags;
          tagInput.setOnItemClickListener(
              (parent, view, position, id) -> {
                tag = ((Tag) tags.get(position));
              });
        });
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
        String postTitle = (title.getEditText()).getText().toString().trim();
        String postBody = (body.getEditText()).getText().toString().trim();
        String tag = tagInput.getText().toString().toLowerCase().trim();

        String tagID = null;

        if (validateFields(postTitle, tag, postBody)){
          if (!TextUtils.isEmpty(postBody)
                  || !TextUtils.isEmpty(postTitle)
                  || !TextUtils.isEmpty(tag)) {

            for (Tag t : mTags) if (t.getTag().equals(tag)) tagID = t.getTagID();

            if (tagID == null)
              firebaseActions.addTag(
                      new Tag(tag),
                      tagID1 -> {
                        if (tagID1 != null) addPost(postTitle, postBody, tag, topic);
                      });
            else addPost(postTitle, postBody, tag, topic);

          } else Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_LONG).show();
        }
    }
    return super.onOptionsItemSelected(item);
  }

  private void addPost(String title, String body, String tag, String topic) {

    Post post = new Post(title, body, tag, mAuth.getCurrentUser().getUid(), topic);

    firebaseActions.addPost(
        post,
        (added, key) -> {
          if (added)
            Toast.makeText(getApplicationContext(), FirebaseUtils.POST_ADDED, Toast.LENGTH_SHORT)
                .show();
          else
            Toast.makeText(
                    getApplicationContext(), FirebaseUtils.POST_NOT_ADDED, Toast.LENGTH_SHORT)
                .show();
        });
  }

  private boolean validateFields(String title, String tag, String body){
    if(title.length() < 1 || tag.length() < 1 || body.length() < 1){
      Toast.makeText(this, "Please ensure all fields ae filled!", Toast.LENGTH_SHORT).show();
      return false;
    }else return true;
  }
}

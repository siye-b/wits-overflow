package com.example.witsly;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.witsly.Fragments.HomeFragment;
import com.example.witsly.Interfaces.GetTags;
import com.example.witsly.Models.Post;
import com.example.witsly.Models.Tag;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostActivity extends AppCompatActivity {

  private TextInputLayout title, body;
  private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
  private final FirebaseActions firebaseActions = new FirebaseActions();
  private AppCompatAutoCompleteTextView tagInput;
  private ArrayList mTags;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);
    final Toolbar toolbar = findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);
    (getSupportActionBar()).setTitle("New Post");
    (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    tagInput = findViewById(R.id.tagInput);

    firebaseActions.getTags(tags -> {
        ArrayAdapter<Tag> arrayAdapter = new ArrayAdapter<Tag>(this, android.R.layout.simple_list_item_1, tags);
        tagInput.setAdapter(arrayAdapter);
        tagInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              Tag tag = ((Tag) tags.get(position));
              String tagID = tag.getTagID();
              //This should return the tag ID of whatever tag from the list the user selects
              //I'm guessing the string you'd be passing for the addPost would now be the tag ID
              //I'm not sure how you'd keep track of the tag ID outside of this scope (again, my lack of knowledge is showing here)
          }
        });
    });


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

        final String tag = tagInput.getText().toString().toLowerCase().trim();

        if (!TextUtils.isEmpty(postBody) || !TextUtils.isEmpty(postTitle) || !TextUtils.isEmpty(tag)) {
          addPost(postTitle, postBody, tag);
          FragmentTransaction fraTransaction = getSupportFragmentManager().beginTransaction();
          fraTransaction.replace(R.id.postA, new HomeFragment()).commit();

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

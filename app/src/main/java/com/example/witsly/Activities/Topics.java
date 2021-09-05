package com.example.witsly.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.witsly.Adapters.TopicsAdapter;
import com.example.witsly.Adapters.TopicsAdapter;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Topics extends AppCompatActivity {
    CardView cms ,cam, maths;
   // private  final TextView question;

    private FloatingActionButton mTopic;
    //private final ArrayList<Topics> mTopicList;
    private TextView mTopicAdd;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        cam = findViewById(R.id.topic1);
        cms = findViewById(R.id.topic2);
        maths = findViewById(R.id.topic3);
        mTopic = findViewById(R.id.mTop);



        cam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                click(v);
            }
        });

        cms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });

        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });

        mTopic.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                click(v);

                Intent intent = new Intent(Topics.this,TopicsAdapter.class);
                startActivity(intent);
            }
        });


    }
    public void click(View v){
        switch (v.getId()){
            case R.id.topic1:
            case R.id.topic2:
            case R.id.topic3:
                startActivity(new Intent(this, PostActivity.class));
                break;
        }


    }



}
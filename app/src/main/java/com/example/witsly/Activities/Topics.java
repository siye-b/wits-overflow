package com.example.witsly.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.witsly.Adapters.TopicsAdapter;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Topics extends AppCompatActivity {
    CardView cms ,cam, maths;
   // private  final TextView question;

    private FloatingActionButton mTop;
    //private final ArrayList<Topics> mTopicList;
    private TextView mTopicAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        cam = findViewById(R.id.topic1);
        cms = findViewById(R.id.topic2);
        maths = findViewById(R.id.topic3);

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

    }
    public void click(View v){
        switch (v.getId()){
            case R.id.topic1:
                Intent intent = new Intent(this, PostActivity.class);
                intent.putExtra("topic","cam");
                startActivity(intent);

            case R.id.topic2:
                Intent intent2 = new Intent(this, PostActivity.class);
                intent2.putExtra("topic","coms");
                startActivity(intent2);

            case R.id.topic3:
                Intent intent3 = new Intent(this, PostActivity.class);
                intent3.putExtra("topic","maths");
                startActivity(intent3);
        }

    }


    /*public  Topics(ArrayList<Topics> TopicList, Context context, Object e, TextView mTopicAdd) {
        //mTopicList = TopicList;
        mTop = ((FloatingActionButton) e);
        //this.mTopicAdd = mTopicAdd;
        startActivity(new Intent(this, TopicsAdapter.class));
    }*/
}
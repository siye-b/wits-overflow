package com.example.witsly.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.witsly.R;

public class Topics extends AppCompatActivity {
    CardView cms ,cam, maths;

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
            case R.id.topic2:
            case R.id.topic3:
                startActivity(new Intent(this, PostActivity.class));
                break;
        }

    }
}
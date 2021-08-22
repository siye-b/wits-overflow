package com.example.witsly.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.PostActivity;
import com.example.witsly.Activities.Topics;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class TopicsAdapter  extends RecyclerView.Adapter<TopicsAdapter.ViewHolder>{

    private final ArrayList<Topics> mTopicList;

    private FloatingActionButton mTop;

    private TextView mTopicAdd;

    private Button buttontopic;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_card, parent, false);

        return new TopicsAdapter.ViewHolder(view);
    }

    public TopicsAdapter(ArrayList<Topics> TopicList, Context context, Object e, TextView mTopicAdd) {
        mTopicList = TopicList;
        mTop = ((FloatingActionButton) e);
        this.mTopicAdd = mTopicAdd;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View itemView){
            super(itemView);

            mTopicAdd = itemView.findViewById(R.id.tv_topic_name);
            buttontopic = itemView.findViewById(R.id.buttontopic);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mTopicList.size();

    }

  //  public void TopicsAdapter(View v){
      //  switch (v.getId()){
            //buttontopic = itemView.findViewById(R.id.buttontopic);
        //        startActivity(new Intent(this, Topics.class));
       // }

    }





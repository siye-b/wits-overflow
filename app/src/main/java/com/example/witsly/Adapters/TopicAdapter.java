package com.example.witsly.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.PostActivity;
import com.example.witsly.Models.Topic;
import com.example.witsly.R;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder>{

    private ArrayList<Topic> mTopicList;
    private final Context mContext;

    public static class TopicViewHolder extends RecyclerView.ViewHolder{
        TextView mTVTopics;
        CardView card;

        public TopicViewHolder(View itemView){
            super(itemView);
            mTVTopics = itemView.findViewById(R.id.txt_topic);
            card = itemView.findViewById(R.id.topic_card);
        }
    }

    public TopicAdapter(ArrayList<Topic> TopicList, Context mContext) {
        mTopicList = TopicList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item, parent, false);
        TopicViewHolder tvh = new TopicViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = mTopicList.get(position);

        holder.mTVTopics.setText(topic.getTopic());


        //TODO: Add necessary information and/or functions
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostActivity.class);
                //Use below if needed.
                //intent.putExtra("Topic", "");
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTopicList.size();
    }


}

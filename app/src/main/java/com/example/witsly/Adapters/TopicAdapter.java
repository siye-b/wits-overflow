package com.example.witsly.Adapters;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Activities.PostActivity;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Topic;
import com.example.witsly.R;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder>{

    private ArrayList<Topic> mTopicList;
    private ArrayList<Topic> subscribed_Topic;
    private final Context mContext;
    private static ArrayList<Topic> topic_subs;
    private  FirebaseDatabase firebaseDatabase;
    private FirebaseUser currentUser;


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
                //topic_subs = new ArrayList<>();
                //subscribe to topic
                FirebaseActions.subscribe(topic,mContext);

                }

            });




    }

    @Override
    public int getItemCount() {
        return mTopicList.size();
    }


}

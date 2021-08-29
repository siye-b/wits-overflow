package com.example.witsly.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.R;
//import com.google.android.gms.ads.mediation.Adapter;
import com.google.firebase.database.annotations.NotNull;

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.ViewHolder> {


    private final Button AddTopic;
    CardView newcard;

    public TopicsAdapter(Button addTopic) {
        AddTopic = addTopic;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private final Button AddTopic;
        private final CardView newcard;
        private final TextView mAddTopicT;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            AddTopic = itemView.findViewById(R.id.buttontopic);
            newcard  = itemView.findViewById(R.id.cardV);
            mAddTopicT = itemView.findViewById(R.id.tv_topic_name);
            
            newcard.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    click(v);
                }
            });

        }

        private void click(View v) {
        }

    }

    @NonNull
    @NotNull
    @Override
    public TopicsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_card, parent, false);

        return new TopicsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

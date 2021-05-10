package com.example.witsly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder>{

    private ArrayList<String> mAnswerList;
    Context mContext;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mAnswerDetails;
        private TextView mAnswerBody;
        private RecyclerView mAnswerRV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mAnswerDetails = itemView.findViewById(R.id.tv_answer_name);
            mAnswerBody = itemView.findViewById(R.id.tv_answer_body);
            mAnswerRV = itemView.findViewById(R.id.rv_answers);


        }
    }

    public AnswerAdapter(ArrayList<String> answerList, Context context){
        mAnswerList = answerList;
        mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_card, parent, false);

        return new AnswerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AnswerAdapter.ViewHolder holder, int position) {
        String s = mAnswerList.get(position);

        //Do stuff

        //Initialize ArrayList with answers model (Different from Comments Model)
        //Add items

        //Initialize Adapter
        //CommentsAdapter cAdapter = new CommentsAdapter(ArrayList<CommentsModel>);

        //Initialise LayoutManager similar to Fragment
        //RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(context)

        //Set LayoutManager

        //Set Adapter



    }

    @Override
    public int getItemCount() {
        return mAnswerList.size();
    }
}



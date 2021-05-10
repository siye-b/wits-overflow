package com.example.witsly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    ArrayList<String> mCommentsList;



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mCommentDetails;
        private TextView mCommentBody;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mCommentDetails = itemView.findViewById(R.id.tv_commenter_name);
            mCommentBody =  itemView.findViewById(R.id.tv_commenter_body);
        }
    }

    public CommentsAdapter(ArrayList<String> commentsList){
        mCommentsList = commentsList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_card, parent, false);
        return new CommentsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentsAdapter.ViewHolder holder, int position) {
        String curr = mCommentsList.get(position);

        //Do stuff
    }

    @Override
    public int getItemCount() {
        return mCommentsList.size();
    }


}

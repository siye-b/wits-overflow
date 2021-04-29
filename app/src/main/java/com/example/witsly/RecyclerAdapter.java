package com.example.witsly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<CardItem> mPostList;

    public static class RecyclerViewHolder extends  RecyclerView.ViewHolder{

        public TextView mPosterDetails;
        public TextView mPostTitle;
        public TextView mPostBody;
        public TextView mVoteCount;
        public TextView mCommentCount;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mPosterDetails = itemView.findViewById(R.id.tv_poster);
            mPostTitle = itemView.findViewById(R.id.tv_card_title);
            mPostBody = itemView.findViewById(R.id.tv_card_body);
            mVoteCount = itemView.findViewById(R.id.tv_vote_count);
            mCommentCount = itemView.findViewById(R.id.tv_comment_count);
        }
    }

    public RecyclerAdapter(ArrayList<CardItem> postList){
        mPostList = postList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        RecyclerViewHolder RVH = new RecyclerViewHolder(v);
        return RVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        CardItem cItem = mPostList.get(position);

        holder.mPosterDetails.setText(cItem.getPosterDetails());
        holder.mPostTitle.setText(cItem.getPostTitle());
        holder.mPostBody.setText(cItem.getPostBody());
        holder.mVoteCount.setText(cItem.getVoteCount());
        holder.mCommentCount.setText(cItem.getCommentCount());
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}

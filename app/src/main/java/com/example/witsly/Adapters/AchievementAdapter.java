package com.example.witsly.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Models.Achievement;
import com.example.witsly.R;

import java.util.ArrayList;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.AchievementHolder> {
    private ArrayList<Achievement> mAchievementList;
    public static class  AchievementHolder extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public AchievementHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public AchievementAdapter(ArrayList<Achievement> achievementList){
        mAchievementList = achievementList;
    }

    @NonNull
    @Override
    public AchievementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_item, parent, false);
        AchievementHolder ah = new AchievementHolder(v);
        return ah;
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementHolder holder, int position) {
        Achievement currentItem = mAchievementList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

        if (currentItem.getAchieved() == true){
            holder.mTextView2.setTextColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return mAchievementList.size();
    }
}

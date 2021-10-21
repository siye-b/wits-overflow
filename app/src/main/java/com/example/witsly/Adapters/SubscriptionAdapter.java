package com.example.witsly.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Topic;
import com.example.witsly.R;

import java.util.ArrayList;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder>{

    private ArrayList<String> mSubscriptionList;
    private ArrayList<String> mListFilter;
    private final Context mContext;

    public static class SubscriptionViewHolder extends RecyclerView.ViewHolder{
        TextView mTVSubs;
        CardView card;
        AppCompatButton mDelete;

        public SubscriptionViewHolder(View itemView){
            super(itemView);
            mTVSubs = itemView.findViewById(R.id.txt_subscription);
            card = itemView.findViewById(R.id.sub_card);
            mDelete = itemView.findViewById(R.id.delete_sub);


        }
    }

    public SubscriptionAdapter(ArrayList<String> SubList, Context mContext) {
        mSubscriptionList = SubList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_item, parent, false);
        SubscriptionViewHolder tvh = new SubscriptionViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        String topic = mSubscriptionList.get(position);
        holder.mTVSubs.setText(topic);

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Remove the subscription from firebase at current pos i.e. add firebase actions here
                FirebaseActions.unsubscribe(topic,mContext);

                //mSubscriptionList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSubscriptionList.size();
    }

}

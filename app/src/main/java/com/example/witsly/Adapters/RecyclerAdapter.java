package com.example.witsly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Fragments.ViewQuestion;
import com.example.witsly.Models.Post;
import com.example.witsly.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>
		implements Filterable {

	private final ArrayList<Post> mPostList;
	private final ArrayList<Post> mListFilter;
	private final Context context;
	private OnItemClickListener mListener;
	private final FirebaseActions firebaseActions = new FirebaseActions();

	@Override
	public Filter getFilter() {
		return recyclerFilter;
	}

	public interface OnItemClickListener {
		void onItemClick(int pos);
		// Please modify to add necessary information from dB i.e. Title, Body etc.
		// Alternatively, pass the ID of the post at current position and we can get the necessary info
		// Use method in HomeFragment to navigate to ViewQuestion activity
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mListener = listener;
	}

	static class RecyclerViewHolder extends RecyclerView.ViewHolder {

		Chip mChip;
		TextView mPosterDetails;
		TextView mPostTitle;
		TextView mPostBody;
		TextView mVoteCount;
		CardView card;

		RecyclerViewHolder(@NonNull View itemView, OnItemClickListener listener) {
			super(itemView);

			mChip = itemView.findViewById(R.id.tag);
			mPosterDetails = itemView.findViewById(R.id.tv_poster2);
			mPostTitle = itemView.findViewById(R.id.tv_card_title2);
			mPostBody = itemView.findViewById(R.id.tv_card_body2);
			mVoteCount = itemView.findViewById(R.id.tv_vote_count2);
			card = itemView.findViewById(R.id.cardView);

			itemView.setOnClickListener(
					v -> {
						if (listener != null) {
							int pos = getAdapterPosition();
							if (pos != RecyclerView.NO_POSITION) listener.onItemClick(pos);
						}
					});
		}
	}

	public RecyclerAdapter(ArrayList<Post> postList, Context context) {
		mPostList = postList;
		mListFilter = new ArrayList<>(mPostList);
		this.context = context;
	}

	@NonNull
	@Override
	public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v =
				LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, parent, false);

		return new RecyclerViewHolder(v, mListener);
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

		Post post = mPostList.get(position);
		if (post.getTitle().length() > 15)
			holder.mPostTitle.setText(
					post.isSolved()
							? post.getTitle().substring(0, 15) + " [SOLVED]"
							: post.getTitle().substring(0, 15));
		else
			holder.mPostTitle.setText(post.isSolved() ? post.getTitle() + " [SOLVED]" : post.getTitle());

		holder.mChip.setText(post.getTag());

		if (post.getBody().length() > 30)
			holder.mPostBody.setText((post.getBody()).substring(0, 30));
		else holder.mPostBody.setText(post.getBody());

    /*holder.mUpVoteButton.setOnClickListener(
        up -> firebaseActions.upVote(post.getPostID(), post.getUid()));

    holder.mDownVoteButton.setOnClickListener(
        down -> firebaseActions.downVote(post.getPostID(), post.getUid()));

    firebaseActions.getPostVoteState(
        post.getPostID(),
        post.getUid(),
        g -> {
          if (g == 0) {
            // up
            holder.mUpVoteButton.setChecked(true);

          }
          if (g == 1) {
            // nothing
            holder.mDownVoteButton.setChecked(false);
            holder.mUpVoteButton.setChecked(false);
          }

          if (g == 2) {
            // down
            holder.mDownVoteButton.setChecked(true);

          }
        });*/

		firebaseActions.getUserDetails(
				post.getUID(),
				value -> {
					// value.getTag()

					// pass the tag we get
					holder.mPosterDetails.setText(
							"Posted by "
									+ value.getName()
									+ " "
									+ value.getSurname()
									+ " on: "
									+ (post.getDate()).substring(0, 10));
				});

		holder.mVoteCount.setText(post.getVote() + "");
		holder.card.setOnClickListener(
				v -> {
					Bundle bundle = new Bundle();
					bundle.putString("postID", post.getPID());
					//bundle.putString("profID", post.getUID());

					AppCompatActivity activity = (AppCompatActivity) context;

					Fragment viewQuestion = new ViewQuestion();
					viewQuestion.setArguments(bundle);
					FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
					transaction.replace(R.id.container_frag, viewQuestion);

					transaction.addToBackStack(null);
					transaction.commit();
				});
	}

	@Override
	public int getItemCount() {
		return mPostList.size();
	}

	private final Filter recyclerFilter =
			new Filter() {
				@Override
				protected FilterResults performFiltering(CharSequence constraint) {
					ArrayList<Post> filterList = new ArrayList<>();
					if (constraint == null || constraint.length() == 0)
						filterList.addAll(mListFilter);
					else {
						String query = constraint.toString().toLowerCase().trim();
						String tQuery = constraint.toString();
						for (Post card : mListFilter)
							if (card.getTag().trim().startsWith(query) || card.getTitle().contains(tQuery))
								filterList.add(card);
					}
					FilterResults filterResults = new FilterResults();
					filterResults.values = filterList;
					return filterResults;
				}

				@Override
				protected void publishResults(CharSequence constraint, FilterResults results) {
					mPostList.clear();
					mPostList.addAll((Collection<? extends Post>) results.values);
					notifyDataSetChanged();
				}
			};
}

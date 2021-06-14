package com.example.witsly.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.Adapters.AnswerAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Models.Answer;
import com.example.witsly.R;
import com.example.witsly.Utils.FirebaseUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;

public class ViewQuestion extends Fragment {
<<<<<<< Updated upstream
	private TextView title;
	private TextView body;
	private TextView details;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayout;
	private ArrayList<String> mAnswerList; // Change to model for answer
	private Button add_btn;
	private EditText add_comment;
	private FirebaseActions firebaseActions;
	private String questionID, userID;
	private TextView vote;
	private ToggleButton like, dislike;
	private Button solvedMark, deleteMark;
	private Boolean isAuthor;

	@SuppressLint("SetTextI18n")
	@Override
	public View onCreateView(
			LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_view_question, container, false);

		Bundle bundle = getArguments();
		firebaseActions = new FirebaseActions();
		FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

		body = view.findViewById(R.id.tv_view_details);
		title = view.findViewById(R.id.tv_view_title);
		details = view.findViewById(R.id.tv_view_body);

		vote = view.findViewById(R.id.txt_vote);
		like = view.findViewById(R.id.btn_like);
		dislike = view.findViewById(R.id.btn_dislike);
		solvedMark = view.findViewById(R.id.tick);
		deleteMark = view.findViewById(R.id.cross);

		assert mUser != null;

		like.setOnCheckedChangeListener(onCheckedListener);
		dislike.setOnCheckedChangeListener(onCheckedListener);

		mRecyclerView = view.findViewById(R.id.rv_answers);
		add_btn = view.findViewById(R.id.add_comment_btn);
		add_comment = view.findViewById(R.id.add_comment_et);

		RecyclerView recyclerView = view.findViewById(R.id.rv_answers);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

		if (bundle != null) {
			String postID = bundle.getString("postID");

			firebaseActions.getPost(
					postID,
					(post, user) -> {
						userID = post.getUID();
						body.setText(
								"Post by: "
										+ user.getName()
										+ " "
										+ user.getSurname()
										+ " on: "
										+ (post.getDate()).substring(0, 10));
						title.setText(post.isSolved() ? post.getTitle() + " [SOLVED]" : post.getTitle());
						details.setText(post.getBody());
						vote.setText(post.getVote() + "");

						// only the owner of the post can mark the question as solved

						if (mUser.getUid().equals(userID)) {
							solvedMark.setVisibility(View.VISIBLE);
							solvedMark.setOnClickListener(
									sm ->
											firebaseActions.markPost(
													postID,
													m -> {
														if (m)
															Toast.makeText(getActivity(), "Solved", Toast.LENGTH_SHORT).show();
														else
															Toast.makeText(getActivity(), "Not Solved", Toast.LENGTH_SHORT)
																	.show();
													}));
						}

						firebaseActions.isCurrentUserAdmin(
								(isAdmin, resp) -> {
									if (isAdmin || mUser.getUid().equals(userID)) {
										deleteMark.setVisibility(View.VISIBLE);
										deleteMark.setOnClickListener(
												dm -> {
													((FragmentActivity) view.getContext())
															.getSupportFragmentManager()
															.beginTransaction()
															.replace(R.id.container_frag, new HomeFragment())
															.commit();
													firebaseActions.deletePost(
															postID,
															r ->
																	Toast.makeText(getActivity(), "Post Deleted", Toast.LENGTH_LONG)
																			.show());
												});
									}
								});
					});

			like.setOnClickListener(
					v -> {
						firebaseActions.upVote(FirebaseUtils.POSTS, postID, mUser.getUid());
					});

			dislike.setOnClickListener(
					v -> {
						firebaseActions.downVote(FirebaseUtils.POSTS, postID, mUser.getUid());
					});

			add_btn.setOnClickListener(
					v -> {
						String comment = add_comment.getText().toString().trim();

						if (!comment.isEmpty()) firebaseActions.addAnswer(
								new Answer(comment, mUser.getUid(), postID),
								r -> {
									if (r) {
										add_comment.setText("");
										Toast.makeText(getActivity(), "added", Toast.LENGTH_SHORT).show();
									} else
										Toast.makeText(getActivity(), "not added", Toast.LENGTH_SHORT).show();
								});
						else
							Toast.makeText(getActivity(), "the comment section is empty", Toast.LENGTH_SHORT)
									.show();
					});

			firebaseActions.getAnswers(
					postID,
					answers -> {
						Collections.sort(answers, Answer.VoteComparator);
						AnswerAdapter ans = new AnswerAdapter(answers, getActivity());
						mRecyclerView.setAdapter(ans);
						mRecyclerView.setLayoutManager(mRecyclerManager);
					});
		}

		return view;
	}

	CompoundButton.OnCheckedChangeListener onCheckedListener =
			new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {
						if (buttonView != like) like.setChecked(false);
						if (buttonView != dislike) dislike.setChecked(false);
					}
				}
			};
  /*
   CompoundButton.OnCheckedChangeListener onCheckedListenerAnswer =
       new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           if (isChecked) {
             if (buttonView != ansLike) {
               ansLike.setChecked(false);
             }
             if (buttonView != ansDislike) {
               ansDislike.setChecked(false);
             }
           }
         }
       };

  */
=======
  private TextView title;
  private TextView body;
  private TextView details;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayout;
  private ArrayList<String> mAnswerList; // Change to model for answer
  private Button add_btn;
  private EditText add_comment;
  private FirebaseActions firebaseActions;
  private String questionID, userID;
  private TextView vote;
  private ToggleButton like, dislike;
  private Button solvedMark, deleteMark;
  private Boolean isAuthor;

  @SuppressLint("SetTextI18n")
  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_view_question, container, false);

    Bundle bundle = getArguments();
    firebaseActions = new FirebaseActions();
    FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

    body = view.findViewById(R.id.tv_view_details);
    title = view.findViewById(R.id.tv_view_title);
    details = view.findViewById(R.id.tv_view_body);

    vote = view.findViewById(R.id.txt_vote);
    like = view.findViewById(R.id.btn_like);

    assert mUser != null;



    mRecyclerView = view.findViewById(R.id.rv_answers);
    add_btn = view.findViewById(R.id.add_comment_btn);
    add_comment = view.findViewById(R.id.add_comment_et);

    RecyclerView recyclerView = view.findViewById(R.id.rv_answers);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());

    if (bundle != null) {
      String postID = bundle.getString("postID");

      firebaseActions.getPost(
          postID,
          (post, user) -> {
            userID = post.getUid();
            body.setText(
                "Post by: "
                    + user.getName()
                    + " "
                    + user.getSurname()
                    + " on: "
                    + (post.getDate()).substring(0, 10));
            title.setText(post.isSolved() ? post.getTitle() + " [SOLVED]" : post.getTitle());
            details.setText(post.getBody());
            vote.setText(post.getVote() + "");

            // only the owner of the post can mark the question as solved

            if (mUser.getUid().equals(userID)) {
              solvedMark.setVisibility(View.VISIBLE);
              solvedMark.setOnClickListener(
                  sm ->
                      firebaseActions.markPost(
                          postID,
                          m -> {
                            if (m)
                              Toast.makeText(getActivity(), "Solved", Toast.LENGTH_SHORT).show();
                            else
                              Toast.makeText(getActivity(), "Not Solved", Toast.LENGTH_SHORT)
                                  .show();
                          }));
            }

            firebaseActions.isCurrentUserAdmin(
                (isAdmin, resp) -> {
                  if (isAdmin || mUser.getUid().equals(userID)) {
                    deleteMark.setVisibility(View.VISIBLE);
                    deleteMark.setOnClickListener(
                        dm -> {
                          ((FragmentActivity) view.getContext())
                              .getSupportFragmentManager()
                              .beginTransaction()
                              .replace(R.id.container_frag, new HomeFragment())
                              .commit();
                          firebaseActions.deletePost(
                              postID,
                              r ->
                                  Toast.makeText(getActivity(), "Post Deleted", Toast.LENGTH_LONG)
                                      .show());
                        });
                  }
                });
          });

      like.setOnClickListener(
          v -> {
            Toast.makeText(getActivity(), "like", Toast.LENGTH_SHORT).show();
            firebaseActions.upVote("Posts", postID, mUser.getUid());
          });

      dislike.setOnClickListener(
          v -> {
            firebaseActions.downVote("Posts", postID, mUser.getUid());
            Toast.makeText(getActivity(), "dislike", Toast.LENGTH_SHORT).show();
          });

      add_btn.setOnClickListener(
          v -> {
            String comment = add_comment.getText().toString().trim();

            if (!comment.equals("")) {
              firebaseActions.addAnswer(
                  new Answer(comment, mUser.getUid(), postID),
                  r -> {
                    if (r) {
                      add_comment.setText("");
                      Toast.makeText(getActivity(), "added", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(getActivity(), "not added", Toast.LENGTH_SHORT).show();
                  });
            } else
              Toast.makeText(getActivity(), "the comment section is empty", Toast.LENGTH_SHORT)
                  .show();
          });

      firebaseActions.getAnswers(
          postID,
          answers -> {
            Collections.sort(answers, Answer.VoteComparator);
            AnswerAdapter ans = new AnswerAdapter(answers, getActivity());
            mRecyclerView.setAdapter(ans);
            mRecyclerView.setLayoutManager(mRecyclerManager);
          });
    }

    return view;
  }



>>>>>>> Stashed changes
}

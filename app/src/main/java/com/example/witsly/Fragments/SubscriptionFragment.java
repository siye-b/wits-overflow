package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.witsly.Adapters.RecyclerAdapter;
import com.example.witsly.Adapters.SubscriptionAdapter;
import com.example.witsly.Adapters.TopicAdapter;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SubscriptionFragment extends Fragment {
    private TopicAdapter mmAdapter;
    private SubscriptionAdapter adapterm;
    private final FirebaseActions firebaseActions = new FirebaseActions();
    public FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.subscription_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mRecyclerManager = new LinearLayoutManager(view.getContext());
        firebaseActions.getSubscriptions(
                t -> {
                    adapterm = new SubscriptionAdapter(t, getContext());
                    mRecyclerView.setLayoutManager(mRecyclerManager);
                    mRecyclerView.setAdapter(adapterm);

                });


                    mFab = view.findViewById(R.id.btn_add_sub);

                    mFab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container_frag, new AddSubscriptionFragment())
                                    .addToBackStack(null)
                                    .commit();
                        }


                });

                return view;
    }
}
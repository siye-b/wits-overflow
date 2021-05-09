package com.example.witsly.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witsly.R;

import java.util.ArrayList;

public class ViewQuestion extends Fragment {
  private TextView title;
  private TextView body;
  private TextView details;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayout;
  private ArrayList<String> mAnswerList; //Change to model for answer

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_view_question, container, false);

    Bundle bundle = getArguments();

    body = view.findViewById(R.id.tv_view_details);
    title = view.findViewById(R.id.tv_view_title);
    details = view.findViewById(R.id.tv_view_body);

    if (bundle != null) {
      title.setText(bundle.getString("title"));
      details.setText(bundle.getString("body"));
      body.setText(bundle.getString("details"));
    }

    mRecyclerView = view.findViewById(R.id.rv_answers);

    //Initialise everything similar to what has been done in HomeFragment

    return view;
  }
}

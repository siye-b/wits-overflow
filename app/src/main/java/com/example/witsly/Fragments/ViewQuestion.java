package com.example.witsly.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.witsly.R;

public class ViewQuestion extends Fragment {
  private TextView title;
  private TextView body;
  private TextView details;

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

    return view;
  }
}

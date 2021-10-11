package com.example.witsly.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.witsly.Activities.LoginActivity;
import com.example.witsly.Firebase.FirebaseActions;
import com.example.witsly.Firebase.FirebaseAuthentication;
import com.example.witsly.R;
import com.example.witsly.databinding.ForgotDialogBinding;

public class SettingsFragment extends Fragment {

    public TextView tv_reset;
    AlertDialog.Builder builder;
    FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        tv_reset = view.findViewById(R.id.tv_reset);

        tv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

        return view;
    }

    private void resetPassword() {
        builder = new AlertDialog.Builder(getView().getContext());

        ForgotDialogBinding binding =
                ForgotDialogBinding.inflate(LayoutInflater.from(getView().getContext()));
        builder.setView(binding.getRoot());

        builder.setPositiveButton(
                "Next",
                (dialog, which) -> {
                    String email = binding.etForgotPW.getText().toString().trim();

                    firebaseAuthentication.resetPassword(
                            email,
                            (response, msg) -> {
                                if (response)
                                    Toast.makeText(
                                            getView().getContext(),
                                            "Reset link is sent to your email: " + email,
                                            Toast.LENGTH_LONG)
                                            .show();
                                else
                                    Toast.makeText(
                                            getView().getContext(), "ERROR ! Reset link is not sent ,", Toast.LENGTH_LONG)
                                            .show();
                            });

                    dialog.dismiss();
                });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.create();
        builder.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
package com.example.witsly;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.witsly.databinding.ProDialogBinding;

public class ProDialog {

  private final Context context;
  private AlertDialog myAlert;

  public ProDialog(final Context myContext) {
    context = myContext;
  }

  public void start() {

    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    ProDialogBinding binding = ProDialogBinding.inflate(LayoutInflater.from(context));
    builder.setView(binding.getRoot());
    builder.setCancelable(false);

    myAlert = builder.create();
    myAlert.show();
  }

  public void stop() {

    myAlert.dismiss();
  }



}

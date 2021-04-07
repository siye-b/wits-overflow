package com.example.witsly;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.witsly.databinding.ProDialogBinding;

public class proDialog {

    private Context context;
    private AlertDialog myAlert;

    proDialog(final Context myContext){
        context = myContext;
    }

    void startLoad(){


        /*Dialog dialog = new Dialog(context);
        ProDialogBinding binding = ProDialogBinding.inflate(LayoutInflater.from(context));
        dialog.setContentView(binding.getRoot());
        dialog.setCancelable(false);
        maindialog = dialog;
        maindialog.show();*/

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ProDialogBinding binding = ProDialogBinding.inflate(LayoutInflater.from(context));
        builder.setView(binding.getRoot());
        builder.setCancelable(false);

        myAlert = builder.create();
        myAlert.show();

    }

    void endLoad(){

       /* Dialog dialog = new Dialog(context);
        ProDialogBinding binding = ProDialogBinding.inflate(LayoutInflater.from(context));
        dialog.setContentView(binding.getRoot());
        dialog.setCancelable(false);*/
        //maindialog.dismiss();

        myAlert.dismiss();
    }
}

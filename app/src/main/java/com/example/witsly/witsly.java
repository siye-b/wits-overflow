package com.example.witsly;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.witsly.Utils.FirebaseUtils;

public class witsly extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createNotification();
    }

    public void createNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel_main = new NotificationChannel(
                    FirebaseUtils.CHANNEL_ID,
                    "MainChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            //Description will appear in settings
            channel_main.setDescription("All app notifications on this channel for now.");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel_main);
        }
    }

    //USAGE
    //DECLARE BELOW FIRST
    //private NotificationManagerCompat notificationManagerCompat;

    //CALL FUNCTION BELOW WHERE NECESSARY
    /*public void sendMessage(){
        Notification notification = new NotificationCompat.Builder(this, FirebaseUtils.CHANNEL_ID)
                .setContentTitle("Title will go here.")
                .setContentText("Other info will go here.")
                .setAutoCancel(true)
                .build();

        notificationManagerCompat.notify(1, notification);
    }*/
}

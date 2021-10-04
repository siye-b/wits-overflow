package com.example.witsly;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.example.witsly.Utils.FirebaseUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

//This is to be used if triggers are being used.
//I believe the plan might have to be upgraded but there might be a workaround.
//We'll speak about it on Wednesday

public class NotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel_main = new NotificationChannel(
                    FirebaseUtils.CHANNEL_ID,
                    "MainChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            //Description will appear in settings
            channel_main.setDescription("All app notifications on this channel for now.");

            getSystemService(NotificationManager.class).createNotificationChannel(channel_main);
            Notification.Builder notification = new Notification.Builder(this, FirebaseUtils.CHANNEL_ID);
            notification.setContentTitle("Title will go here.")
                    .setContentText("Other info will go here.")
                    .setAutoCancel(true);

            NotificationManagerCompat.from(this).notify(1, notification.build());
        }

    }
}

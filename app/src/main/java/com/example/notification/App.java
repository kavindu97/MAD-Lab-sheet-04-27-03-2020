package com.example.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App  extends Application {
    public static final String chanel_id =  "C1";
    @Override
    public void onCreate() {
        super.onCreate();
        CreateNotificatioChannels();
    }
    private void CreateNotificatioChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel Chanel = new NotificationChannel(chanel_id,
                    "chan",
                    NotificationManager.IMPORTANCE_DEFAULT);
            Chanel.setDescription("This is channel");
            NotificationManager manager = getSystemService(NotificationManager.class);
        }
    }
}

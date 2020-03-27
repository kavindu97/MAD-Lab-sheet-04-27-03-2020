package com.example.notification;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    EditText name_box;
    private String CHANNEL_ID = "my_channel_01";
    int NOTIFICATION_ID = 12345;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name_box = findViewById(R.id.editText);

        button_click(name_box);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void button_click(View view) {
        String name =  name_box.getText().toString();

        Intent intent = new Intent(this, RegisterForm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("name", name);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentText("“Hello "+ name +" welcome to the MAD team")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .build();
        notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder);
    }
}
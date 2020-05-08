package com.example.alertnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;

    private EditText editTextTitle;
    private EditText editTextMessage;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editTextTitle = (EditText) this.findViewById(R.id.editText_title);
        this.editTextMessage = (EditText) this.findViewById(R.id.editText_message);

        this.button1 = (Button) this.findViewById(R.id.button);
        this.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendOnChannel1(  );
            }
        });
        this.notificationManagerCompat = NotificationManagerCompat.from(this);
        
    }


    private void sendOnChannel1()  {
        String title = this.editTextTitle.getText().toString();
        String message = this.editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.icon_notify)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        int notificationId = 1;
        this.notificationManagerCompat.notify(notificationId, notification);
    }
}


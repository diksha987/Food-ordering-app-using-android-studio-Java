package com.example.notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Order_now extends AppCompatActivity {

    public int counter;
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);
        final TextView counttime=findViewById(R.id.textView10);
        new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                counter++;
            }
            @Override
            public void onFinish() {
                counttime.setText("FOOD DELIVERED...");
            }
        }.start();
    }
}



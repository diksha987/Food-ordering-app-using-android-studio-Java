package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Food_cart extends AppCompatActivity {
    Button btn;
    NotificationManager nm;
    int total = 0;
    public final String NOTIFICATION_ID = "1";
    public final String NOTIFICATION_NAME = "DIKSHA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cart);
        //TextView txt = findViewById(R.id.textView6);
        //txt.setText(String.valueOf(MainActivity.itewms));
        ListView ls = findViewById(R.id.list);
        ArrayAdapter<String> item = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.items);
        ls.setAdapter(item);
        TextView cs = findViewById(R.id.cost);
        for(int i = 0 ; i < MainActivity.cost.size() ; i++)
        {
            total += MainActivity.cost.get(i);
        }
        cs.setText(String.valueOf(total));
        //notification
        btn = findViewById(R.id.button3);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NotificationCompat.Builder n = new NotificationCompat.Builder(getApplicationContext(),NOTIFICATION_ID);
                n.setContentTitle("ORDER WILL GET IN 30 MIN");
                n.setContentText("CHECKED IT OUT");
                n.setSmallIcon(R.drawable.bell);
                n.setAutoCancel(true);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                n.setSound(uri);
                nm.notify(1,n.build());
                Intent in = new Intent(getApplicationContext(),Order_now.class);
                startActivity(in);
            }

        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotificationChannel() {
        NotificationChannel nc = new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_HIGH);
        nc.enableVibration(true);
        nc.enableLights(true);
        nm.createNotificationChannel(nc);
    }
}
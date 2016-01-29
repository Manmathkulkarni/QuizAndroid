package com.example.manmkulk.quizandroid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

//import android.support.v4.app.NotificationCompat;


public class Main2Activity extends AppCompatActivity {
    String title;
    String text;
    TextView txtTitle;
    TextView txtText;
    private PendingIntent pendingIntent;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    public static DownloadCancelReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // showNotification();
        receiver = new DownloadCancelReceiver();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showNotification() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, Main2Activity.class), 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("Notification")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("Notifications")
                .setContentText("Text")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .addAction(android.R.drawable.ic_menu_report_image, "Action 1", pi)
                .addAction(android.R.drawable.ic_delete, "Action 2", pi)

                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    public void onReceive(Context context, Intent intent) {

        System.out.println("Received Cancelled Event");
    }
    
    public static class DownloadCancelReceiver extends BroadcastReceiver {

       @Override
        public void onReceive(Context context, Intent intent) {

           Log.d("TAG", "test");
       }
    }
}

package com.example.socialparceldistribution_bcreceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class parcelReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("YBandSHU.A_CUSTOM_INTENT")){
            initChannels(context);


            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(android.R.drawable.picture_frame)
                    .setContentTitle("Parcel Notification")
                    .setContentText("Choose how to handle the parcel...");
            Notification notification = builder.build();
            notification.defaults = notification.DEFAULT_ALL;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, notification);
        }
        else if (intent.getAction().matches("android.intent.action.TIME_TICK"))
            Toast.makeText(context, "TIME_TICK", Toast.LENGTH_LONG).show();
        else if(intent.getAction().matches("android.intent.action.BOOT_COMPLETED"))
            Toast.makeText(context, "BOOT_COMPLETED", Toast.LENGTH_LONG).show();
        else if (intent.getAction().matches("android.intent.action.TIME_SET"))
            Toast.makeText(context, "TIME_SET", Toast.LENGTH_LONG).show();
        else if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
            Toast.makeText(context, "SMS_RECEIVED", Toast.LENGTH_LONG).show();
    }
    public  void initChannels(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default", "Channel name", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
    }
}

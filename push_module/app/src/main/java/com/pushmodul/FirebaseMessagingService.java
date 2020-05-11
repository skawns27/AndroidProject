package com.pushmodul;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static final String TAG="FirebaseMsgService";

    public void onMessageReceived(RemoteMessage remoteMessage){
        sendNotification(remoteMessage.getData().get("message"));
    }

    private void sendNotification(String messageBody){
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this,0,intent,
                PendingIntent.FLAG_ONE_SHOT);

        //알림을 띄우는 설정
        Uri.defaultSoundUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("FCM Push Test")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setConentIntent(pendingIntent);

        NotificationManager notificationManager=
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0,notificationBuilder.build());

    }
}

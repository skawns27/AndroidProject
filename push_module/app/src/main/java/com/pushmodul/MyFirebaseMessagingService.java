package com.pushmodul;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="FirebaseMsgService";

    public void onMessageReceived(RemoteMessage remoteMessage){
        sendNotification(remoteMessage.getData().get("message"));
    }

    /*알림 띄우기*/
    private void sendNotification(String messageBody){
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        //알림을 띄우는 설정
        Uri defaultSoundUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder notificationBuilder=new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("FCM Push Test")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0,notificationBuilder.build());

    }
}

package com.pushtest.org;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;
// 전체적인 Firebase 메시지 전달받는 기능

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="FMS";

     public MyFirebaseMessagingService(){

    }
    public void onNewToken(String token){//사용자가 FCM에 계정 등록할 때
         super.onNewToken(token);
    }
     public void onMessageReceived(RemoteMessage remoteMessage){//push 메세지 받을 때
         Map<String,String> data=remoteMessage.getData();
         String from=data.get("from");
         String url=data.get("");
         onSendMessage(getApplicationContext(),from,url);
     }

     public void onSendMessage(Context context,String From, String url){
         Intent intent=new Intent(context,MainActivity.class);
         intent.putExtra("Link",url);
         intent.putExtra("From",From);
         NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);
         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
         context.startActivity(intent);
     }

}

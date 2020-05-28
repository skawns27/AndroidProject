package com.pushmodul;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseIIDService";
                @Override
                public void onNewToken(String token) {
                    super.onNewToken(token);
                    // Get updated InstanceID token.
                    Log.d(TAG, "Refreshed token: " + token);

                    // 생성등록된 토큰을 개인 앱서버에 보내 저장해 두었다가 추가 뭔가를 하고 싶으면 할 수 있도록 한다.
                   // sendRegistrationToServer(token);
                }
//

}

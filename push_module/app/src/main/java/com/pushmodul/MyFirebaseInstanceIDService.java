package com.pushmodul;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class MyFirebaseInstanceIDService extends MyFirebaseMessagingService {
    private static final String TAG = "MyFirebaseIIDService";
                @Override

                public void onNewToken(String token) {
                    // Get updated InstanceID token.
                    Log.d(TAG, "Refreshed token: " + token);

                    // 생성등록된 토큰을 개인 앱서버에 보내 저장해 두었다가 추가 뭔가를 하고 싶으면 할 수 있도록 한다.
                    sendRegistrationToServer(token);
                }

    protected void sendRegistrationToServer(String token) {
        OkHttpClient client = new OkHttpClient();
        Log.d("서버전송-", "전송토큰: " + token);
        RequestBody body = new FormBody.Builder()
                .add("Token", token)
                .build();
        /*서버 url 입력하기*/
        Request request = new Request.Builder()
                .url("http://skawns27.dothome.co.kr/register.php")
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

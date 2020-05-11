package com.pushmodul;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class FirebaseInstanceIDService{

    private static final String TAG="MyFirebaseIdService";

    public void onTokenRefresh(){
        String token=FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed token:"+token);

        sendRegistrationToServer(token);
    }
    /*서버 결과 전송*/
    private void sendRegistrationToServer(String token){
        OkHttpClient client= new OkHttpClient();
        RequestBody body= new FormBody.Builder()
                .add("Token",token)
                .build();

        Request request= new Request.Builder()
                /*서버 url 입력하기*/
                .url("주소")
                .build();

        try{
            client.newCall(request).execute();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

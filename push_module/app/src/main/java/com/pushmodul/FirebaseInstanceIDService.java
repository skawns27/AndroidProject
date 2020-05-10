package com.pushmodul;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

public class FirebaseInstanceIDService{

    private static final String TAG="MyFirebaseIdService";

    public void onTokenRefresh(){
        String token=FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed token:"+token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token){
        OkHttpClient client= new OkHttpClient();
        RequestBody body= new FormBody.Builder()
                .add("Token",token)
                .build();

        Request request= new Request.Builder()
                .url("주소")
                .build();

        try{
            client.newCall(request).execute();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

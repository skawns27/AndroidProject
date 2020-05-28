package com.pushmodul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        token=findViewById(R.id.token);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                sendRegistrationToServer();
            }
        });
        thread.start();
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this,
                new OnSuccessListener<InstanceIdResult>() {
                    @Override
                    public void onSuccess(InstanceIdResult instanceIdResult) {
                        String newToken =instanceIdResult.getToken();
                        Log.d("token", newToken);
                    }
                });


    }
    protected void sendRegistrationToServer() {
        String Token="TestToken";
        OkHttpClient client = new OkHttpClient();
        Log.d("서버전송-", "전송토큰: " + Token);
        RequestBody body = new FormBody.Builder()
                .add("Token", Token)
                .build();
        /*서버 url 입력하기*/
        Request request = new Request.Builder()
                .url("http://skawns27.dothome.co.kr/register.php")
                .post(body)
                .build();

        try {
            Response response=client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

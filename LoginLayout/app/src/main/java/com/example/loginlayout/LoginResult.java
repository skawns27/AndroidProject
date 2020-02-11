package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResult extends AppCompatActivity {
    TextView login_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_result=findViewById(R.id.result_login);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String email=bundle.getString("email");
        String password=bundle.getString("password");
        login_result.setText(email+"/"+password);
    }
}

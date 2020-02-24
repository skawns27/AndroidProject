package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResult extends AppCompatActivity {
    TextView login_result;
    Button logout_btn,study_btn,look_btn;
    final int REQUEST_LOGOUT=200;
    final int REQUEST_STUDY=101;
    final int REQUEST_SEARCH=102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        login_result=findViewById(R.id.result_login);
        logout_btn=findViewById(R.id.logout_button);
        study_btn=findViewById(R.id.study_btn);
        look_btn=findViewById(R.id.look_btn);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
        study_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_study();
            }
        });

        String email=bundle.getString("email");
        login_result.setText(email+"님 환영합니다.");


    }
    private void Logout(){
        setResult(REQUEST_LOGOUT);
        finish();
    }
    private void start_study(){
        Intent intent=new Intent(LoginResult.this,study_activity.class);
        startActivityForResult(intent,REQUEST_STUDY);
    }
}


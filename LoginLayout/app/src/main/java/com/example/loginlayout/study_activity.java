package com.example.loginlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class study_activity extends AppCompatActivity implements activityCollection{
    TextView date,time,record;
    Button sound_control,logout;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_study);


        logout=findViewById(R.id.logout_button);
        sound_control=findViewById(R.id.sound_control);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                }
            });
        }

    @Override
    public void logout() {
        setResult(REQUEST_LOCK);
        finish();
    }
}


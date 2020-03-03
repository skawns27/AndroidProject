package com.example.loginlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class study_activity extends AppCompatActivity {
    TextView date,time,record;
    Button sound_control,logout;
    Calendar now=Calendar.getInstance();
    final int REQUEST_STOP=201;
    int month,day;//오늘날짜
    int today;//금일기록

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_study);

        date.setText(now.toString());
        logout=findViewById(R.id.logout_button);
        sound_control=findViewById(R.id.sound_control);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(REQUEST_STOP);
                finish();
                }
            });
        }
    }


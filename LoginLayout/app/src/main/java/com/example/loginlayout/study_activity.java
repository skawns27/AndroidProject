package com.example.loginlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.DataFormatException;


public class study_activity extends AppCompatActivity implements activityCollection{
    TextView date,sec_tv,min_tv,hour_tv,m_sec_tv,today_record;
    Button sound_control,logout;
    long study_sec=0;
    long study_min=0;
    long study_hour=0;
    long study_m_sec=0;

    long G_min;
    long G_hour;
    long G_sec;
    String today;
    String progress;


    TimerTask timerTask= new TimerTask() {
        @Override
        public void run() {
                study_m_sec++;
                if(study_m_sec==10){
                    study_m_sec=0;
                    study_sec++;
                    if (study_sec%60==0) {
                        study_min++;
                        min_tv.setText(Long.toString(study_min%60));
                        if (study_min%60==0) {
                            study_hour++;
                        }
                    }
                }
            m_sec_tv.setText(Long.toString(study_m_sec%100));
            sec_tv.setText(Long.toString(study_sec%60));
            min_tv.setText(Long.toString(study_min));
            hour_tv.setText(Long.toString(study_hour));
        }
    };
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_study);

        logout=findViewById(R.id.logout_button);
        sound_control=findViewById(R.id.sound_control);
        hour_tv=findViewById(R.id.st_hour);
        min_tv=findViewById(R.id.st_min);
        sec_tv=findViewById(R.id.st_sec);
        date=findViewById(R.id.date);
        m_sec_tv=findViewById(R.id.st_m_sec);
        DateFormat myData= DateFormat.getDateInstance();
        today=myData.toString();
        date.setText(today);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(202);
                finish();
                }
            });
        Timer timer=new Timer();
        timer.schedule(timerTask,0,100);
        }

    @Override
    public void logout() {
        setResult(202);
        finish();
    }
}


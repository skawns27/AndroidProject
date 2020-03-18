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


public class study_activity extends AppCompatActivity implements activityCollection{
    TextView date,sec_tv,min_tv,hour_tv,today_record;
    Button sound_control,logout;
    long study_sec=0;
    long study_min=0;
    long study_hour=0;
    String today;


    TimerTask timerTask= new TimerTask() {
        @Override
        public void run() {
                study_sec++;
            if (study_sec == 60) {
                study_sec = 0;
                study_min++;
                min_tv.setText(Long.toString(study_min));
                if (study_min == 60) {
                    study_min = 0;
                    study_hour++;
                    if (study_hour == 24) {
                        study_hour = 0;
                    }
                }
            }
            sec_tv.setText(Long.toString(study_sec));
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

        today=DateFormat.getInstance().format(myData);
        date.setText(df);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(202);
                finish();
                }
            });
        Timer timer=new Timer();
        timer.schedule(timerTask,0,1000);
        }

    @Override
    public void logout() {
        setResult(202);
        finish();
    }
}


package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        Toast.makeText(this,"로그아웃",Toast.LENGTH_SHORT).show();
        setResult(REQUEST_LOGOUT);
        finish();
    }
    private void start_study(){
        Intent intent=new Intent(LoginResult.this,study_activity.class);
        startActivityForResult(intent,REQUEST_STUDY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);//메뉴추가
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId=item.getItemId();
        switch(curId){
            case R.id.menu_refresh:{
                Toast.makeText(this,"새로고침 되었습니다",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_search:{
                Toast.makeText(this,"검색 메뉴 선택",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_setting:{
                Toast.makeText(this,"설정 중",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}


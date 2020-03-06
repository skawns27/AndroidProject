package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class LoginResult extends AppCompatActivity implements Logout{
    TextView login_result;
    Button logout_btn,start_btn,search_btn;
    final int REQUEST_LOGOUT=200;
    final int REQUEST_STUDY=101;
    final int REQUEST_SEARCH=102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        login_result=findViewById(R.id.login_result);
        logout_btn=findViewById(R.id.logout_btn);
        start_btn=findViewById(R.id.start_btn);
        search_btn=findViewById(R.id.search_btn);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_study();
            }
        });

        String email=bundle.getString("email");
        login_result.setText(email+"님 환영합니다.");


    }


    @Override
    public void logout() {
        Toast.makeText(this,"로그아웃",Toast.LENGTH_SHORT).show();
        setResult(REQUEST_LOGOUT);
        finish();
    }
    protected void start_study(){
        Toast.makeText(this,"학습시작",Toast.LENGTH_LONG).show();
        Intent mIntent=new Intent(getApplicationContext(),study_activity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                        Intent.FLAG_ACTIVITY_SINGLE_TOP|
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(mIntent,REQUEST_STUDY);
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


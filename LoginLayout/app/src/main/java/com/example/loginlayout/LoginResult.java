package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import java.util.TimerTask;

public class LoginResult extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,activityCollection, FragmentManager {

    TextView login_result;
    Button start_btn;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer=findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        login_result=findViewById(R.id.login_result);
        start_btn=findViewById(R.id.start_btn);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();


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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.d("결과코드",Integer.toString(requestCode));
        if(resultCode==REQUEST_STOP){
            Toast.makeText(this,"사용종료",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==REQUEST_LOGOUT){
            Toast.makeText(this,"로그아웃",Toast.LENGTH_LONG).show();
            finish();
        }
        else if(resultCode==REQUEST_LOCK){
            Toast.makeText(this,"로그인 화면으로 전환합니다",Toast.LENGTH_LONG).show();
            finish();
        }
            super.onActivityResult(requestCode, resultCode, data);
    }
}


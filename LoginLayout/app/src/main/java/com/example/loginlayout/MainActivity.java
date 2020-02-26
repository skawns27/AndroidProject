package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_LOGIN=100;
    String input_email="";
    String input_password="";
    TextView login_log;
    TextView sign_up;
    TextInputEditText TextView_email,TextView_password;
    RelativeLayout relativeLayout_login;
    String email1="skawns27";
    String password1="1234";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView_email = findViewById(R.id.Input_email);
        TextView_password = findViewById(R.id.Input_password);
        relativeLayout_login = findViewById(R.id.login_button);
        login_log =findViewById(R.id.login_log);
        sign_up=findViewById(R.id.sign_up);


        //이메일 옵저버
        TextView_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass_login();
                if (s != null) {//입력이 됐을 때 입력
                    input_email = s.toString();
                    Log.d("password",input_email);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //--------------------------------------
        //비밀번호 옵저버
        TextView_password.addTextChangedListener(new TextWatcher() {//내부 클래스에서 작업
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s != null) {//입력 값이 아무것도 없지 않을 때
                    input_password = s.toString();
                    Log.d("password",input_password);
                }
                else
                    input_password=null;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //--------------------------------------------
        //회원가입 회원

        pass_login();
    }


    private void pass_login() {
        //입력값과 지정값이 같다면
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        relativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//클릭 이벤트 발생
                if (input_email.equals(email1) && input_password.equals(password1)) {
                    Intent intent = new Intent(MainActivity.this, LoginResult.class);//배송위치
                    intent.putExtra("email", input_email);//인텐트 엑스트라에 입력
                    intent.putExtra("password", input_password);
                    startActivityForResult(intent,REQUEST_LOGIN);//인텐트 전달
                }//입력정보 분기점
                else {
                    if (TextView_email.getText().toString().equals("")||TextView_password.getText().toString().equals("")) {
                        login_log.setText("이메일과 비밀번호를 입력해주세요");//이메일 공백 이벤트
                    } else {//등록되지 않은 계정
                        login_log.setText("등록되지 않은 계정입니다. 이메일이나 비밀번호를 확인해 주세요.");
                    }
                }

                //로그인 불가 이벤트 추가할 것
            }
        });
    }
}


















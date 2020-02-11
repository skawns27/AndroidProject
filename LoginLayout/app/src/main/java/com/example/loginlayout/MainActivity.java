package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String input_email="";
    String input_password="";
    TextView login_log;
    TextView TextView_email,TextView_password;
    RelativeLayout relativeLayout_login;
    String email1="skawns27";
    String password1="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView_email = findViewById(R.id.Input_email);
        TextView_password = findViewById(R.id.Input_password);
        relativeLayout_login = findViewById(R.id.login_button);
        login_log =findViewById(R.id.login_log);
        TextView_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass_login();
                if (s != null) {//입력이 됐을 때 입력
                    input_email = s.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        TextView_password.addTextChangedListener(new TextWatcher() {//내부 클래스에서 작업
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass_login();
                if (s != null) {//입력 값이 아무것도 없지 않을 때
                    input_password = s.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        }
       private void pass_login() {
           if (input_email.equals(email1) && input_password.equals(password1)) {//입력값과 지정값이 같다면
               relativeLayout_login.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {//클릭 이벤트 발생
                       Intent intent = new Intent(MainActivity.this, LoginResult.class);//배송위치
                       intent.putExtra("email", input_email);//인텐트 엑스트라에 입력
                       intent.putExtra("password", input_password);
                       startActivity(intent);//인텐트 전달
                   }
               });
           }
           else {
                   relativeLayout_login.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if (TextView_email.getText().toString().equals("")||TextView_password.getText().toString().equals("")) {
                               login_log.setText("이메일과 비밀번호를 입력해주세요");//이메일 공백 이벤트

                           } else {//등록되지 않은 계정
                               login_log.setText("등록되지 않은 계정입니다. 이메일이나 비밀번호를 확인해 주세요.");
                           }
                       }
                   });
           }

           //로그인 불가 이벤트 추가할 것
    }
    }



















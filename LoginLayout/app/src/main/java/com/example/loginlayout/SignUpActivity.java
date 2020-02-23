package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    CheckBox male,female;
    TextView log;
    TextInputEditText TextView_email,TextView_password,TextView_password_check;
    Button email_confirm,send_in;
    String input_email="";
    String input_password="",input_check="";
    boolean confirm;//가입신청 버튼
    //1.회원가입 신청 중복 확인 sql->DB연동 조회 확인
    //2.중복 확인 후 메인화면으로 돌아오고 가입완료 이벤트 창 띄우기->DB정보 추가
    //3.

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        TextView_email=findViewById(R.id.TextView_email);
        TextView_password=findViewById(R.id.TextView_password);
        TextView_password_check=findViewById(R.id.password_check);
        email_confirm=findViewById(R.id.check_email);
        male=findViewById(R.id.man);
        female=findViewById(R.id.woman);
        log=findViewById(R.id.sign_up_log);
        send_in=findViewById(R.id.send_in);

        send_in.setEnabled(false);
        confirm=false;
        observer();
        //email 입력변화 확인

    }


    private void checkPassword(String input_password,String input_check){
        if(input_password.equals(input_check)){
            log.setText("비밀번호가 일치합니다.");
        }
        else if(input_check==null||input_password==null){
            log.setText("비밀번호나 비밀번호 확인란을 입력해주세요");
        }
        else
            log.setText("비밀번호가 일치하지 않습니다");

    }
    // private void checkEmail(String input_email)

    private void observer(){
        TextView_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null)
                    input_email=s.toString();//중복 이메일 확인 메서드 추가
                else
                    input_email=null;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextView_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null)
                    input_password=s.toString();
                else
                    input_password=null;
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        TextView_password_check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null) {
                    input_check = s.toString();
                    checkPassword(input_password, input_check);
                }
                else input_check=null;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

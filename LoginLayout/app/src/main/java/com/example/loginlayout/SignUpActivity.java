package com.example.loginlayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    CheckBox male,female;
    TextInputEditText email,password,password_check;
    Button email_confirm;
    String input_email;
    String input_password,input_check;
    //1.회원가입 신청 중복 확인 sql->DB연동 조회 확인
    //2.중복 확인 후 메인화면으로 돌아오고 가입완료 이벤트 창 띄우기->DB정보 추가
    //3.
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        email.findViewById(R.id.email);
        password.findViewById(R.id.password);
        email_confirm.findViewById(R.id.check_email);
        male.findViewById(R.id.man);
        female.findViewById(R.id.woman);
        //email 입력변화 확인
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_email=s.toString();//중복 이메일 확인 메서드 추가
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_password=s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password_check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_check=s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void checkPassword(String input_password,String input_check){
        if(input_password.equals(input_check)){

        }
        else if(input_check==null||input_password==null){

        }
    }
    private void checkEmail(String input_email){

    }

}

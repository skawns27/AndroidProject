package com.example.loginlayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class find_password extends AppCompatActivity {
    EditText name,id,pw,ch_pw;
    TextView state_log;
    String input_name=null;
    String input_pw=null;
    String input_check=null;
    String input_id=null;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_password);

        name=findViewById(R.id.TextView_name);
        id=findViewById(R.id.TextView_email);
        pw=findViewById(R.id.TextView_pw);
        ch_pw=findViewById(R.id.confirm_pw);
        state_log=findViewById(R.id.state_log);

        textObv();

    }
    private void pw_change(){ //비밀번호 변경



    }
    private void textObv(){

        name.addTextChangedListener(new TextWatcher() {//이름
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_name=s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        id.addTextChangedListener(new TextWatcher() {//id
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_id=s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pw.addTextChangedListener(new TextWatcher() { //비밀번호 입력
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input_pw=s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ch_pw.addTextChangedListener(new TextWatcher() { //비밀번호 확인
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
}

package com.example.loginlayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    CheckBox man,women;
    TextInputEditText email,password,password_check;
    String input_email;
    String input_password,input_check;

    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.sign_up);

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
}

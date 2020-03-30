package com.example.loginlayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String input_email=null;
    String input_password=null;

    TextView login_log;
    TextView sign_up;

    TextInputEditText TextView_email,TextView_password;
    RelativeLayout relativeLayout_login;

    String email1="skawns27";
    String password1="1234";

    static boolean login_state;

    request_login R_login;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView_email = findViewById(R.id.Input_email);
        TextView_password = findViewById(R.id.Input_password);
        relativeLayout_login = findViewById(R.id.login_button);
        login_log =findViewById(R.id.login_log);
        sign_up=findViewById(R.id.sign_up);
        login_state=false;


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

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //회원가입
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        relativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//로그인
                boolean success;

                if (input_email == null || input_password == null) {
                    login_log.setText("이메일과 비밀번호를 입력해주세요");//이메일 공백 이벤트
                }
                else {
                    Response.Listener<String> respondListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject();
                                login_state = jsonObject.getBoolean("success");

                                if (login_state) {
                                    Intent intent = new Intent(getApplicationContext(), LoginResult.class);
                                    intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK |
                                            intent.FLAG_ACTIVITY_SINGLE_TOP |
                                            intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.putExtra("email", input_email);//인텐트 엑스트라에 입력
                                    intent.putExtra("password", input_password);
                                    login_state = false;//로그인 승인 초기화
                                    startActivity(intent);//인텐트 전달
                                }//입력정보 분기점
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    Response.ErrorListener errorListener = new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            login_log.setText("등록되지 않은 계정입니다. 이메일이나 비밀번호를 확인해 주세요.");
                        }
                    };
                    R_login = new request_login(input_email, input_password, respondListener, errorListener);
                    //로그인 불가 이벤트 추가 완료
                }
            }
        });
    }
}


















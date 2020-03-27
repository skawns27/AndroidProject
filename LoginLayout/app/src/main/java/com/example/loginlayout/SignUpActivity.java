package com.example.loginlayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {
    CheckBox male,female;
    TextView log;
    TextInputEditText TextView_id,TextView_password,TextView_password_check,TextView_name;
    Button id_confirm,send_in;
    String input_name="";
    String input_id="";
    String input_password="",input_check="";
    String sex="";
    boolean confirm;//가입신청 버튼
    SignUpRequest signupRequest;
    //1.회원가입 신청 중복 확인 sql->DB연동 조회 확인
    //2.중복 확인 후 메인화면으로 돌아오고 가입완료 이벤트 창 띄우기->DB정보 추가
    //3.

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        confirm=false;

        TextView_id=findViewById(R.id.TextView_email);
        TextView_name=findViewById(R.id.TextView_name);
        TextView_password=findViewById(R.id.TextView_password);
        TextView_password_check=findViewById(R.id.password_check);
        id_confirm=findViewById(R.id.check_email);
        male=findViewById(R.id.man);
        female=findViewById(R.id.woman);
        log=findViewById(R.id.sign_up_log);
        send_in=findViewById(R.id.send_in);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setChecked(false);
                sex="male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(false);
                sex="female";
            }
        });
        send_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(confirm){
                                Toast.makeText(getApplicationContext(),"계정생성 완료",Toast.LENGTH_LONG);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"입력하신 ID 또는 PW는 사용하실 수 없습니다",Toast.LENGTH_LONG);
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                    };
                Response.ErrorListener errorListener=new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"계정생성 실패",Toast.LENGTH_LONG);
                    }
                };

                signupRequest=new SignUpRequest(input_name,input_id,input_password,sex,responseListener,errorListener);
                }
        });
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
        TextView_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null)
                    input_id=s.toString();//중복 이메일 확인 메서드 추가
                else
                    input_id=null;
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

        TextView_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null) {
                    input_name = s.toString();
                }
                else Toast.makeText(getApplicationContext(),"이름을 입력해 주세요",Toast.LENGTH_SHORT);
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

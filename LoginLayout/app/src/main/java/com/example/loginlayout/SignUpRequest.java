package com.example.loginlayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SignUpRequest extends StringRequest {
    HashMap<String,String> map;
    final static String URL="";
    SignUpRequest(String name, String id, String pw, String sex, Response .Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST,URL,listener,errorListener);
        map.put("userName",name);
        map.put("userId",id);
        map.put("userPw",pw);
        map.put("userSex",sex);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
package com.example.loginlayout;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class request_login extends StringRequest {
    HashMap<String,String> map;
    final static String URL="http://skawns27.dothome.co.kr/Login.php";

    request_login( String userID, String userPassword, Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST,URL,listener, errorListener);//통신프로토콜,URL,리스너,오류리스너)
        map=new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

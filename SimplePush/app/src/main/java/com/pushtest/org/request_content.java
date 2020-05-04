package com.pushtest.org;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class request_content extends StringRequest {
    HashMap<String,String> map;
    final static String URL="http://skawns27.dothome.co.kr/PROJECT.php";
    request_content(String userID, String pj_title, String pj_content, String pj_date, Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.GET, URL, listener, errorListener);

        map.put("userID",userID);
        map.put("pj_title",pj_title);
        map.put("pj_content",pj_content);
        map.put("pj_date",pj_date);
    }

    protected Map<String,String> getParams() throws AuthFailureError {
        return map;
    }
}

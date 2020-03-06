package org.techtown.samplerequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText input_url;
    TextView result_content;
    Button request_btn;

    static RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_url=findViewById(R.id.input_url);
        result_content=findViewById(R.id.result_content);
        request_btn=findViewById(R.id.request_btn);

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });
    }
   public void makeRequest(){
        String url=input_url.getText().toString();

       StringRequest request=new StringRequest(Request.Method.GET, url,
               new Response.Listener<String>() {//요청 결과 처리
                   @Override
                   public void onResponse(String response) {
                       println("응답->" + response);
                   }
               }, new Response.ErrorListener() {
                 @Override
                   public void onErrorResponse(VolleyError error) {//요청 에러 처리
                        println("에러:->"+ error.getMessage());
               }
       }
   ){
           protected Map<String,String> getParams() throws AuthFailureError{
               Map<String,String>params=new HashMap<String,String>();
               return params;
           }
       };
       request.setShouldCache(false);//이전 응답 결과 저장 유무
       requestQueue.add(request);
       println("요청보냄");
   }

   public void println(String log){
        result_content.append(log);
   }
}

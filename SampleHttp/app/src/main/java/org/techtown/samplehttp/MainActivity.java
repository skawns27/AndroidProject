package org.techtown.samplehttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {
    TextView result_address;
    EditText address_input;
    Button request_btn;

    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_address=findViewById(R.id.result_address);
        request_btn=findViewById(R.id.request_btn);
        address_input=findViewById(R.id.address_input);

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr=address_input.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(urlStr);
                    }
                }).start();
            }
        });

    }
    public void request(String urlStr){
        StringBuilder output=new StringBuilder();//크기 변경 유동적
        try{
            URL url=new URL(urlStr);

            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            if(connection!=null){
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);

                int resCode=connection.getResponseCode();
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                //정보전달 경로: 커낵션(도로)->스티림리더(차)->버퍼(박스) 괄호 안에 있을 수록 정보 가공이 될된거임
                String line=null;
                while(true){
                    line=reader.readLine();////한 라인씩 불러옴
                    if(line==null){
                        break;
                    }
                    output.append(line+"\n");
                }
                reader.close();
                connection.disconnect();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        println("응답->"+output);
    }
    public void println(final String message){
       handler.post(new Runnable() {
           @Override
           public void run() {

               result_address.append(message+"\n");
           }
       });
    }
}

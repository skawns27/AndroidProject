package org.techtown.samplesocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button start_server,send_btn;
    TextView server_result,send_result;
    Handler handler=new Handler();
    EditText inputData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_server=findViewById(R.id.star_server);
        send_btn=findViewById(R.id.send_btn);
        send_result=findViewById(R.id.send_result);
        server_result=findViewById(R.id.server_result);
        inputData=findViewById(R.id.input_data);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final String data = inputData.getText().toString();
                    Log.d("data",data);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            send(data);
                        }
                    }).start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        start_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });
    }

    public void send(String data) {
        try {
            int portNumber = 2700;
            Socket socket = new Socket("localhost", portNumber);
            printClientLog("소켓연결");
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            outStream.writeObject(data);
            outStream.flush();
            printClientLog("데이터 전송함");

            ObjectInputStream objectINputStream=new ObjectInputStream(socket.getInputStream());
            printClientLog("서버로부터 받아옴:"+objectINputStream.readObject());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer(){
        try{
            int portNumber=2700;
            ServerSocket server=new ServerSocket(portNumber);
            printServerLog("서버시작"+portNumber);

            while(true){//서버를 열고 계속 송수신
                Socket sock=server.accept();
                InetAddress clientHost=sock.getLocalAddress();
                int clientPort=sock.getPort();//사용자 포트
                printServerLog("클라이언트 연결 됨"+clientHost+clientPort);//클라이언트+호스트 소켓 출력

                ObjectInputStream inputStream=new ObjectInputStream(sock.getInputStream());
                Object obj=inputStream.readObject();
                printServerLog("데이터 수신:"+obj);

                ObjectOutputStream outputStream=new ObjectOutputStream(sock.getOutputStream());
                outputStream.writeObject(obj+"from server");//메시지 로그 위치 변경
                outputStream.flush();
                printServerLog("데이터 보냄");

                sock.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void printClientLog(final String data) {
        Log.d("MainActivityData",data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                send_result.append(data+"\n");
            }
        });
    }

    private void printServerLog(final String data){
        Log.d("MainActivity",data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                server_result.append(data+"\n");
            }
        });
    }
}

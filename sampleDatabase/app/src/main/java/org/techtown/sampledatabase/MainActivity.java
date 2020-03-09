package org.techtown.sampledatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dbName,tableName;
    Button createDb_btn,createTable_btn;
    TextView resultLog;
    SQLiteDatabase database;
    String table_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbName=findViewById(R.id.dbName);
        tableName=findViewById(R.id.tableName);
        createDb_btn=findViewById(R.id.createDB_btn);
        createTable_btn=findViewById(R.id.createTable_btn);
        resultLog=findViewById(R.id.resultLog);

        createDb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DB_name=dbName.getText().toString();
                makeDb(DB_name);
            }
        });

        createTable_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_name=tableName.getText().toString();
                println("테이블 생성 시작");
                makeTable(table_name);
                insertData();
            }
        });
    }

    public void makeDb(String DB_name){
        database=openOrCreateDatabase(DB_name,MODE_PRIVATE,null);
        println("데이터 베이스 생성 완료");
    }

    public void makeTable(String table_name){
        if(database==null){
            Toast.makeText(this,"데이터 베이스가 없습니다",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            database.execSQL("create table if not exists "+table_name +"("
                    + "_id integer PRIMARY KEY autoincrement, "
                    + "name text, "
                    + "age integer, "//쉼포와 따옴표와 공백 있어야함
                    + "mobile text) ");
            println("데이터베이스 테이블 생성 완료!");
        }
    }
    public void println(String log){
        resultLog.append(log+"\n");
    }

    public void insertData(){

        println("입력메서드 호출");
        if(database==null){
            Toast.makeText(this,"데이터 베이스가 없습니다",Toast.LENGTH_LONG).show();
            return;
        }
        if(table_name==null){
            Toast.makeText(this,"생성된 테이블이 없습니다",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            database.execSQL("insert into"+table_name
                            +"(name,age,moblie)"+"values"+"(남준섭,24,010-3316-7959)");
            println("레코드 추가 완료");
        }
    }
}

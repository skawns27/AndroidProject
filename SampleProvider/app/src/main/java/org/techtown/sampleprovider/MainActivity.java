package org.techtown.sampleprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button recent_btn,query_btn,update_btn,delete_btn;
    TextView content_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recent_btn=findViewById(R.id.recent_btn);
        query_btn=findViewById(R.id.query_btn);
        update_btn=findViewById(R.id.update_btn);
        delete_btn=findViewById(R.id.delete_btn);
        content_text=findViewById(R.id.content_text);

        recent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPerson();
            }
        });

    }
    public void insertPerson(){
        println("insertPerson 호출됨");

        String uriString="content://orgtechtown.provider/person";
        Uri uri= new Uri.Builder().build().parse(uriString);

        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        String[] columns=cursor.getColumnNames();
        println("columns count->"+columns.length);

        for(int i=0;i<columns.length;i++){
            println("#"+i+":"+columns[i]);
        }
        ContentValues values=new ContentValues();
        values.put("name","nam");
        values.put("age","24");
        values.put("mobile","010-2131-7706");

        uri=getContentResolver().insert(uri,values);
    }
    public void println(String str){
        content_text.append(str+"\n");
    }
}

package org.techtown.provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.techtown.provider.R;

public class MainActivity extends AppCompatActivity {

    Button recent_btn,query_btn,update_btn,delete_btn;
    TextView content_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Button
        recent_btn=findViewById(R.id.recent_btn);
        query_btn=findViewById(R.id.query_btn);
        update_btn=findViewById(R.id.update_btn);
        delete_btn=findViewById(R.id.delete_btn);
     //TextView
        content_text=findViewById(R.id.content_text);

        recent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPerson();
            }
        });
        query_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

    }
    public void insertPerson(){
        println("insertPerson 호출됨");

        String uriString="content://org.techtown.provider/person";
        Uri uri= new Uri.Builder().build().parse(uriString);

        Cursor cursor=getContentResolver().query(uri,null,null,null,null);


        ContentValues values=new ContentValues();
        values.put("name","nam");
        values.put("age","24");
        values.put("mobile","010-2131-7706");

        uri=getContentResolver().insert(uri,values);
        println(uri.toString());
    }
    public void search(){
        try {
            String uriString = "content://org.techtown.provide/person";
            Uri uri = new Uri.Builder().build().parse(uriString);
            String[] columns = {"name", "age", "mobile"};
            Cursor cursor = getContentResolver().query(uri, columns, null, null, "name+ASC");
            int index=0;
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(columns[0]));
                int age = cursor.getInt(cursor.getColumnIndex(columns[1]));
                String mobile = cursor.getString(cursor.getColumnIndex(columns[2]));

                println(name + "|" + age + "|" + mobile);
                index++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete() {
        try{
            String uriString="content://org.techtown.provider/person";
            Uri uri=new Uri.Builder().build().parse(uriString);
            String session="name=?";
            String[] sessionArg={"jonh"};
            getContentResolver().delete(uri,session,sessionArg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void println(String str){
        content_text.append(str+"\n");
    }
}

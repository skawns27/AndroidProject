package org.techtown.sampleprovider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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


    }
}

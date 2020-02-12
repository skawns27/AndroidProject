package com.skawns27.newsapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class bodyActivity extends AppCompatActivity {
    TextView title;
    TextView content;
    ImageView imageContent;
    NewData newData;
    String imageUrl;

   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.listbody);//xml연결
       title=findViewById(R.id.title);
       content=findViewById(R.id.content);
       imageContent=findViewById(R.id.imageContent);

       Intent intent=getIntent();
       Bundle bundle=intent.getExtras();
       newData=(NewData)bundle.getSerializable("article");

       title.setText(newData.getTitle());
       content.setText(newData.getDescription());
       imageUrl=newData.getUrlToImage();

   }
}

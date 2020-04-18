package com.skawns27.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;//recyclerView 전체요소
    private RecyclerView.Adapter mAdapter;//recyclerView 리스트 구성어뎁터
    private RecyclerView.LayoutManager layoutManager;//recyclerView 데이터 처리 방식
    private NewData mDataset;// need initial data
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//시스템의 진행 시작 메인 함수
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);//xml연결
        mrecyclerView = findViewById(R.id.recyclerView);//recycleView 객체 생성

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mrecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(layoutManager);//Apply recycleLayout
        queue=Volley.newRequestQueue(this);
        // specify an adapter (see also next example)
        getnews();//네트워크 통신 시작

    }
    public void getnews(){//URL 로부터 뉴스를 받아오기
            //Method sequence
        // 1. Set url and make new StringRequest
        // 2. Call onResponse method to
            //Take information used to Queue from URL
        String url ="";//통신할 url

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {//Response Json Text
                        Log.d("res",response);
                        //convert String to JsonObject to decode text Imformation
                        try {
                            //Take JSONObject from url
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray arrayArticles=jsonObject.getJSONArray("articles");//Make JsonObjectArray
                            List<NewData> news = new ArrayList<>();//news data 자료형 배열

                            for(int i=0,j=arrayArticles.length();i<j;i++){//article 단위로 배열에 삽입
                                NewData new_data = new NewData();//NewData 데이터 생성
                                JSONObject tmpObj=arrayArticles.getJSONObject(i);//tmpObj(1 article)에 arrayArticle[i] 데이터 저장

                                Log.d("total",tmpObj.toString());
                                //take information from arrayArticles to tmp
                                new_data.setTitle((tmpObj.getString("title")));//title을 tmpObj에서 가져와 NewData 객체 Title 설정
                                new_data.setDescription((tmpObj.getString("description")));//
                                new_data.setUrlToImage((tmpObj.getString("urlToImage")));
                                new_data.setContent(tmpObj.getString("content"));
                                news.add(new_data);
                            }
                            mAdapter=new MyAdapter(news, NewsActivity.this, new View.OnClickListener(){
                                //클릭하였을 때
                                //1.객체에 태그 가져오기
                                //2.
                                public void onClick(View v){
                                    Object obj= v.getTag();
                                    if(obj!=null){
                                        int position=(int)obj;
                                        Intent intent= new Intent(NewsActivity.this,bodyActivity.class);
                                        intent.putExtra("article", ((MyAdapter)(mAdapter)).getNews(position));
                                        startActivity(intent);
                                    }
                                }
                            });
                            mrecyclerView.setAdapter(mAdapter);

                        }catch(JSONException e){
                            //Trace error and print log
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}

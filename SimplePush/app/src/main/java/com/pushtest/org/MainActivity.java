package com.pushtest.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private NewProject myDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Response.Listener<String> responseListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject= new JSONObject(response);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset, this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Object obj=v.getTag();
                  if(obj!=null){
                      Intent intent=new Intent(this, pj_body.class);
                      intent.putExtra()
                  }
            }
        });
        recyclerView.setAdapter(mAdapter);
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this,
                                                                                new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken=instanceIdResult.getToken();

            }
        });
    }

    protected void clickCollect(){

    }

}

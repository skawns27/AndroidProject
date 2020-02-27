package org.techtown.tab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1=new Fragment();
        fragment2=new Fragment();
        fragment3=new Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        TabLayout tab=findViewById(R.id.tab);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

        });

    }

}

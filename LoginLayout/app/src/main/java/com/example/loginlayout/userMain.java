package com.example.loginlayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class userMain extends Fragment {
    ImageButton start_btn;//인터페이스 생성
    public interface start_study{
        public void onStart_study();
    }
    start_study callback;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        ViewGroup root=(ViewGroup)inflater.inflate(R.layout.user_main,container,false);
        start_btn=root.findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            callback.onStart_study();
            }
        });
        return  root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof start_study)
        callback=(start_study)context;
    }


}

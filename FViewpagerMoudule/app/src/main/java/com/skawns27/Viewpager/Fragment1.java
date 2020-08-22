package com.skawns27.Viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment1,container,false);
        return rootView;
    }

}

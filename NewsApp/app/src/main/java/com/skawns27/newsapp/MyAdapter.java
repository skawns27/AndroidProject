package com.skawns27.newsapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<NewData> mDataset;
    private static View.OnClickListener onClickListener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextViewTitle;//구성요소1
        public TextView TextViewContent;//2
        public SimpleDraweeView ImageView_title;//3
        public View rootView;
        public MyViewHolder(View v) {//리스트의 각 요소 설정
            super(v);
            TextViewTitle = v.findViewById(R.id.TextView_title);//recycleview의 구성 리스트 연결(여러개 반복)
            TextViewContent=v.findViewById(R.id.TextView_content);
            ImageView_title = v.findViewById(R.id.ImageView_title);
            rootView=v;
            v.setEnabled(true);
            v.setClickable(true);//list 활성화
            v.setOnClickListener(onClickListener);//??

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)->어느
    public MyAdapter(List<NewData> myDataset, Context context,View.OnClickListener onClick) {
        mDataset = myDataset;
        onClickListener=onClick;
        Fresco.initialize(context);
    }//recycle의 한개의 리스트 연결
    // Create new views (invoked by the layout manager)
    // Override MyAdapter to connect list
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {//MyViewHoler 클래스 호출 생성
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//데이터의 배치 설정 함수
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        NewData newData=mDataset.get(position);
        Uri uri = Uri.parse(newData.getUrlToImage());
        holder.TextViewTitle.setText(newData.getTitle());
        holder.TextViewContent.setText(newData.getDescription());
        holder.ImageView_title.setImageURI(uri);
        holder.rootView.setTag(position);



    }
    public NewData getNews(int position){
        return mDataset!=null?mDataset.get(position):null;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset==null?0:mDataset.size();
    }
}

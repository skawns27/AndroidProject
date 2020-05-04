package com.pushtest.org;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<NewProject> mDataset;
    private static View.OnClickListener onClickListener; /*메인으로 부터 클릭 이벤트 전달 받기*/

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView pj_title;
        public TextView pj_content;
        public TextView pj_num;
        public TextView pj_date;
        public View rootView;
        public MyViewHolder(View v) {
            super(v);
            rootView=v;
            pj_title=v.findViewById(R.id.pj_title);
            pj_content=v.findViewById(R.id.pj_content);
            pj_num=v.findViewById(R.id.pj_state);
            pj_date=v.findViewById(R.id.pj_date);
            v.setEnabled(true);
            v.setClickable(true);
            v.setOnClickListener(onClickListener);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<NewProject> myDataset, Context context, View.OnClickListener onClick) {
        mDataset = myDataset;
        onClickListener=onClick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listbody, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        NewProject np=mDataset.get(position);
        holder.pj_title.setText(np.getTitle());
        holder.pj_content.setText(np.getContent());
        holder.pj_num.setText(np.getTeamNum());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset==null?0:mDataset.size();
    }
}

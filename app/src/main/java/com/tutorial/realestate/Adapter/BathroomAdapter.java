package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class BathroomAdapter extends RecyclerView.Adapter<BathroomAdapter.MyView> {
    private List<String> list;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView img_down;
        public MyView(View view) {
            super(view);
            tv_title = (TextView)view.findViewById(R.id.tv_title);
            img_down = (ImageView)view.findViewById(R.id.img_down);
        }
    }
    public BathroomAdapter(List<String> horizontalList) {
        this.list = horizontalList;
    }
    @Override
    public BathroomAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bedroom_item_layout, parent, false);
        return new BathroomAdapter.MyView(itemView);
    }
    @Override
    public void onBindViewHolder(final BathroomAdapter.MyView holder, final int position) {
        holder.tv_title.setText(list.get(position));
//        switch (position){
//            case 5:
//                holder.img_down.setVisibility(View.GONE);
//                break;
//        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

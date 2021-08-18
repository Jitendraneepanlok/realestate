package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class AlmostBedroomadapter extends RecyclerView.Adapter<AlmostBedroomadapter.MyView> {
    private List<String> source;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView img_down;
        public MyView(View view) {
            super(view);
            tv_title = (TextView)view.findViewById(R.id.tv_title);
            img_down = (ImageView)view.findViewById(R.id.img_down);
        }
    }
    public AlmostBedroomadapter(List<String> horizontalList) {
        this.source = horizontalList;
    }
    @Override
    public AlmostBedroomadapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bedroom_item_layout, parent, false);
        return new AlmostBedroomadapter.MyView(itemView);
    }
    @Override
    public void onBindViewHolder(final AlmostBedroomadapter.MyView holder, final int position) {
        holder.tv_title.setText(source.get(position));
//        switch (position){
//            case 5:
//                holder.img_down.setVisibility(View.GONE);
//                break;
//        }

    }

    @Override
    public int getItemCount() {
        return source.size();
    }
}


package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class Demandadapter extends RecyclerView.Adapter<Demandadapter.MyView> {
    private List<String> demandList;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public Demandadapter(List<String> horizontalList) {
        this.demandList = horizontalList;
    }

    @Override
    public Demandadapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.demand_item_layout, parent, false);
        return new Demandadapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final Demandadapter.MyView holder, final int position) {
        holder.tv_title.setText(demandList.get(position));
    }

    @Override
    public int getItemCount() {
        return demandList.size();
    }
}




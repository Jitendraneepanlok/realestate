package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class FreshPropertyAdapter extends RecyclerView.Adapter<FreshPropertyAdapter.MyView> {
    private List<String> fresh_property;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public FreshPropertyAdapter(List<String> horizontalList) {
        this.fresh_property = horizontalList;
    }

    @Override
    public FreshPropertyAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fresh_item_layout, parent, false);
        return new FreshPropertyAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final FreshPropertyAdapter.MyView holder, final int position) {
        holder.tv_title.setText(fresh_property.get(position));
    }

    @Override
    public int getItemCount() {
        return fresh_property.size();
    }
}


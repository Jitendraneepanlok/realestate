package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class PrimeAdapter extends RecyclerView.Adapter<PrimeAdapter.MyView> {
    private List<String> source;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public PrimeAdapter(List<String> horizontalList) {
        this.source = horizontalList;
    }

    @Override
    public PrimeAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.prime_item_layout, parent, false);
        return new PrimeAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final PrimeAdapter.MyView holder, final int position) {
        holder.tv_title.setText(source.get(position));
    }

    @Override
    public int getItemCount() {
        return source.size();
    }
}


package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class NewlyLaunchedAdapter extends RecyclerView.Adapter<NewlyLaunchedAdapter.MyView> {
    private List<String> newlyLaunchedlist;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public NewlyLaunchedAdapter(List<String> horizontalList) {
        this.newlyLaunchedlist = horizontalList;
    }

    @Override
    public NewlyLaunchedAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.newly_launched_item_layout, parent, false);
        return new NewlyLaunchedAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final NewlyLaunchedAdapter.MyView holder, final int position) {
        holder.tv_title.setText(newlyLaunchedlist.get(position));
    }

    @Override
    public int getItemCount() {
        return newlyLaunchedlist.size();
    }
}




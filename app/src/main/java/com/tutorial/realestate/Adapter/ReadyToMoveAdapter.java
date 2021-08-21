package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class ReadyToMoveAdapter extends RecyclerView.Adapter<ReadyToMoveAdapter.MyView> {
    private List<String> ReadyToMoveAdapter;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public ReadyToMoveAdapter(List<String> horizontalList) {
        this.ReadyToMoveAdapter = horizontalList;
    }

    @Override
    public ReadyToMoveAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.readytomove_item_layout, parent, false);
        return new ReadyToMoveAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final ReadyToMoveAdapter.MyView holder, final int position) {
        holder.tv_title.setText(ReadyToMoveAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return ReadyToMoveAdapter.size();
    }
}



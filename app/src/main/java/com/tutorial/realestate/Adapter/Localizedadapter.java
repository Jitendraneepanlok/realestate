package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class Localizedadapter extends RecyclerView.Adapter<Localizedadapter.MyView> {
    private List<String> localizedList;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyView(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public Localizedadapter(List<String> horizontalList) {
        this.localizedList = horizontalList;
    }

    @Override
    public Localizedadapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.localized_item_layout, parent, false);
        return new Localizedadapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final Localizedadapter.MyView holder, final int position) {
        holder.tv_title.setText(localizedList.get(position));
    }

    @Override
    public int getItemCount() {
        return localizedList.size();
    }
}




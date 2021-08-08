package com.tutorial.realestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class ConstructionAgeAdapter  extends RecyclerView.Adapter<ConstructionAgeAdapter.MyView> {
    private List<String> listdata;

    public class MyView extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView img_down;
        public MyView(View view) {
            super(view);
            tv_title = (TextView)view.findViewById(R.id.tv_title);
            img_down = (ImageView)view.findViewById(R.id.img_down);
        }
    }
    public ConstructionAgeAdapter(FragmentActivity activity, List<String> verticalList) {
        this.listdata = verticalList;
    }
    @Override
    public ConstructionAgeAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.floor_item_layout, parent, false);
        return new ConstructionAgeAdapter.MyView(itemView);
    }
    @Override
    public void onBindViewHolder(final ConstructionAgeAdapter.MyView holder, final int position) {
        holder.tv_title.setText(listdata.get(position));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}







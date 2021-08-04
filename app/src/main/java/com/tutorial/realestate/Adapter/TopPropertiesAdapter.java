package com.tutorial.realestate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.Pojo.TopPropertiesConstantPojo;
import com.tutorial.realestate.Pojo.TopProperty;
import com.tutorial.realestate.R;

import java.util.List;

public class TopPropertiesAdapter extends RecyclerView.Adapter<TopPropertiesAdapter.MyViewHolder> {

    private Context mContext;
    private TopPropertiesConstantPojo topPropertiesConstantPojo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title, tvlocation,tv_bhk,tv_area,tv_price,tv_project,tvprice;
        public ImageView image, img_check;

        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tvlocation = (TextView) view.findViewById(R.id.tvlocation);
            tv_bhk = (TextView)view.findViewById(R.id.tv_bhk);
            tv_area = (TextView)view.findViewById(R.id.tv_area);
            tv_price = (TextView)view.findViewById(R.id.tv_price);
            tvprice = (TextView)view.findViewById(R.id.tvprice);
            tv_project = (TextView)view.findViewById(R.id.tv_project);
            image = (ImageView) view.findViewById(R.id.image);
            img_check = (ImageView)view.findViewById(R.id.img_check);
        }
    }


    public TopPropertiesAdapter(Context mContext, TopPropertiesConstantPojo topPropertiesConstantPojo) {
        this.mContext = mContext;
        this.topPropertiesConstantPojo = topPropertiesConstantPojo;
    }

    @Override
    public TopPropertiesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_properties_layout, parent, false);

        return new TopPropertiesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TopPropertiesAdapter.MyViewHolder holder, int position) {
        TopProperty topProperty = topPropertiesConstantPojo.getRealstate().getTopProperties().get(position);
        holder.tv_title.setText(" "+topProperty.getTxtbuilderName());
        holder.tvlocation.setText(" "+topProperty.getTxtLocalityName()+","+topProperty.getTxtsublocality()+","+topProperty.getTxtStateName());
        holder.tv_bhk.setText(" "+topProperty.getTxtBHK());
        holder.tv_area.setText(" "+topProperty.getTxtArea());
        holder.tv_price.setText(" "+topProperty.getTxtPrice());
        holder.tv_project.setText(" "+topProperty.getTxtProjectStatus());
        holder.tvprice.setText(" "+topProperty.getTxtPricefrom()+"/month");
        Glide.with(mContext).load(topProperty.getTxtImage()).into(holder.image);
        Glide.with(mContext).load(topProperty.getTxtIsVerified()).into(holder.img_check);

    }

    @Override
    public int getItemCount() {
        return topPropertiesConstantPojo.getRealstate().getTopProperties().size();
    }
}

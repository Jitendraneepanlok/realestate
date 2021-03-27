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
import com.tutorial.realestate.R;

import java.util.List;

public class BuyFeatureProductAdapter extends RecyclerView.Adapter<BuyFeatureProductAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title, count;
        public ImageView image, overflow;

        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            count = (TextView) view.findViewById(R.id.count);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }


    public BuyFeatureProductAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public BuyFeatureProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_layout, parent, false);

        return new BuyFeatureProductAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BuyFeatureProductAdapter.MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.tv_title.setText(album.getName());
//        holder.count.setText(album.getNumOfSongs() + " songs");
        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

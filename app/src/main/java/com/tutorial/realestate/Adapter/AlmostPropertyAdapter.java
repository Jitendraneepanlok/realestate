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

public class AlmostPropertyAdapter extends RecyclerView.Adapter<AlmostPropertyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public AlmostPropertyAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public AlmostPropertyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.almost_list_row, parent, false);

        return new AlmostPropertyAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AlmostPropertyAdapter.MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);


    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

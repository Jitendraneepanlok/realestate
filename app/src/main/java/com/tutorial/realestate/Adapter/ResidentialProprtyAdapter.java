package com.tutorial.realestate.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tutorial.realestate.Activity.LoginActivity;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.List;

public class ResidentialProprtyAdapter extends RecyclerView.Adapter<ResidentialProprtyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    private NavController navController;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count,tvconect;
        public ImageView thumbnail, overflow;
       public RelativeLayout rl_layout;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            tvconect = (TextView)view.findViewById(R.id.tvconect);
            rl_layout = (RelativeLayout)view.findViewById(R.id.rl_layout);
        }
    }


    public ResidentialProprtyAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public ResidentialProprtyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.residential_property_list_row, parent, false);

        return new ResidentialProprtyAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ResidentialProprtyAdapter.MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController((Activity) mContext, R.id.nav_host_fragment);
                navController.navigate(R.id.action_residiantialpropertyFragment_to_propertyDetailsFragment);

            }
        });
        holder.tvconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenConactDialog();
            }
        });

    }

    private void OpenConactDialog() {
        Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.contact_dialog_box);
        dialog.setCancelable(false);

        ImageView img_cancel = (ImageView)dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}


package com.tutorial.realestate.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.List;

public class PropertyRentAdapter extends RecyclerView.Adapter<PropertyRentAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_price,txt_call_owner,txt_phone,text_save;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            txt_call_owner = (TextView)view.findViewById(R.id.txt_call_owner);
            txt_phone = (TextView)view.findViewById(R.id.txt_phone);
            text_save = (TextView)view.findViewById(R.id.text_save);
        }
    }


    public PropertyRentAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public PropertyRentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rent_list_row, parent, false);

        return new PropertyRentAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PropertyRentAdapter.MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.tv_price.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.txt_call_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog();
            }
        });


        holder.txt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpengetPhoneNoDialog();
            }
        });


        holder.text_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpengetSaveDialog();
            }
        });
    }

    private void OpengetSaveDialog() {
        Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.open_save_dialog_box);
        dialog.setCancelable(false);

        CheckBox get_more_options = (CheckBox)dialog.findViewById(R.id.get_more_options);
        get_more_options.setVisibility(View.VISIBLE);

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

    private void OpengetPhoneNoDialog() {
        Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.get_phone_dialog_box);
        dialog.setCancelable(false);

        CheckBox get_more_options = (CheckBox)dialog.findViewById(R.id.get_more_options);
        get_more_options.setVisibility(View.VISIBLE);

        ImageView img_cancel = (ImageView)dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        AppCompatRadioButton radio_agent = (AppCompatRadioButton)dialog.findViewById(R.id.radio_agent);
        radio_agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_agent.isChecked()){
                    get_more_options.setVisibility(View.GONE);
                }
            }
        });

        AppCompatRadioButton radio_individual = (AppCompatRadioButton)dialog.findViewById(R.id.radio_individual);
        radio_individual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_individual.isChecked()){
                    get_more_options.setVisibility(View.VISIBLE);
                }
            }
        });


        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();

    }

    private void OpenDialog() {
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


package com.tutorial.realestate.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.R;

import java.util.List;

public class OwnerPackageAdapter extends RecyclerView.Adapter<OwnerPackageAdapter.MyView> {
    private List<String> source;
    Context context;

    public class MyView extends RecyclerView.ViewHolder {
        AppCompatTextView txt_tittle, txtprice_gst, txt_gst, txt_off, txt_rate;
        CardView card_view;

        public MyView(View view) {
            super(view);
            txt_tittle = (AppCompatTextView) view.findViewById(R.id.txt_tittle);
            txtprice_gst = (AppCompatTextView) view.findViewById(R.id.txtprice_gst);
            txt_gst = (AppCompatTextView) view.findViewById(R.id.txt_gst);
            txt_off = (AppCompatTextView) view.findViewById(R.id.txt_off);
            txt_rate = (AppCompatTextView) view.findViewById(R.id.txt_rate);
            card_view = (CardView) view.findViewById(R.id.card_view);

        }
    }

    public OwnerPackageAdapter(List<String> horizontalList, Context context) {
        this.source = horizontalList;
        this.context = context;
    }

    @Override
    public OwnerPackageAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_item_layout, parent, false);
        return new OwnerPackageAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final OwnerPackageAdapter.MyView holder, final int position) {
        holder.txt_tittle.setText(source.get(position));
        holder.txtprice_gst.setText(context.getResources().getString(R.string.post_5) + " 3263");
        holder.txt_gst.setText("+ GST");
        holder.txt_off.setText("50 % Off");
        holder.txt_rate.setText(context.getResources().getString(R.string.post_5) + "9228");
        holder.txt_rate.setPaintFlags(holder.txt_rate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.card_view.setCardBackgroundColor(context.getResources().getColor(R.color.red));
                holder.txt_tittle.setTextColor(context.getResources().getColor(R.color.white));
                holder.txtprice_gst.setTextColor(context.getResources().getColor(R.color.white));
                holder.txt_gst.setTextColor(context.getResources().getColor(R.color.white));
                holder.txt_off.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.txt_rate.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.txt_rate.setPaintFlags(holder.txt_rate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            }
        });
    }

    @Override
    public int getItemCount() {
        return source.size();
    }
}



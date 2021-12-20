package com.tutorial.realestate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tutorial.realestate.Pojo.FeaturePropertiesContantPojo;
import com.tutorial.realestate.Pojo.FeaturedPropertyPojo;
import com.tutorial.realestate.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class BuyFeatureProductAdapter extends RecyclerView.Adapter<BuyFeatureProductAdapter.MyViewHolder> {

    private Context mContext;
    private FeaturePropertiesContantPojo featuredPropertyResponse;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title, count, tvlocation, tv_sqft, tvbathroom, tvprice;
        public ImageView image, img_verify;

        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            count = (TextView) view.findViewById(R.id.count);
            image = (ImageView) view.findViewById(R.id.image);
            tvlocation = (TextView) view.findViewById(R.id.tvlocation);
            tv_sqft = (TextView) view.findViewById(R.id.tv_sqft);
            tvbathroom = (TextView) view.findViewById(R.id.tvbathroom);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            img_verify = (ImageView) view.findViewById(R.id.img_verify);
        }
    }


    public BuyFeatureProductAdapter(Context mContext, FeaturePropertiesContantPojo featuredPropertyResponse) {
        this.mContext = mContext;
        this.featuredPropertyResponse = featuredPropertyResponse;
    }

    @Override
    public BuyFeatureProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_layout, parent, false);

        return new BuyFeatureProductAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BuyFeatureProductAdapter.MyViewHolder holder, int position) {
        FeaturedPropertyPojo featuredPropertyPojo = featuredPropertyResponse.getRealstate().getFeaturedProperties().get(position);

        holder.tv_title.setText(" " + featuredPropertyPojo.getTxtpropertyTitle());
        holder.tvlocation.setText(" " + featuredPropertyPojo.getTxtLocalityName() + "," + featuredPropertyPojo.getTxtCityName() + "," + featuredPropertyPojo.getTxtStateName());
        holder.tv_sqft.setText(" " + featuredPropertyPojo.getTxtArea());
        holder.tvbathroom.setText("" + featuredPropertyPojo.getTxtBedrooms() + " Bedroom");
        holder.tvprice.setText(" Start From / Rs. " + featuredPropertyPojo.getTxtsaleExpectedPrice());

        Glide.with(mContext).
                load(featuredPropertyPojo.getTxtImage())
                .error(R.drawable.login_1)
                .into(holder.image);

        Glide.with(mContext).load(featuredPropertyPojo.getTxtIsVerified())
                .error(R.drawable.ic_checkmark)
                .into(holder.img_verify);
    }

    @Override
    public int getItemCount() {
        return featuredPropertyResponse.getRealstate().getFeaturedProperties().size();
    }
}

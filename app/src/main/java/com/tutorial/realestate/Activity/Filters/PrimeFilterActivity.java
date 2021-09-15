package com.tutorial.realestate.Activity.Filters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.tutorial.realestate.Adapter.AlmostBedroomadapter;
import com.tutorial.realestate.Adapter.AlmostPropertyAdapter;
import com.tutorial.realestate.Adapter.AmenitiesAdapter;
import com.tutorial.realestate.Adapter.FacingAdapter;
import com.tutorial.realestate.Adapter.FilterAdapter;
import com.tutorial.realestate.Adapter.FurnishedAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class PrimeFilterActivity extends AppCompatActivity {
    AppCompatImageView img_close;
    FurnishedAdapter adapter;
    AmenitiesAdapter amenitiesAdapter;
    RecyclerView recycler_furnished_status,recycler_amenities,recycler_facing;
    private List<Album> albumList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager HorizontalLayout;
    FacingAdapter facingAdapter;
    ArrayList<String> source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_filter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.title_bar_color));
        }
        initView();
        FurnishedStatus();
        AmenitiesDetails();
        Facing();
    }

    private void Facing() {
        recycler_facing = (RecyclerView)findViewById(R.id.recycler_facing);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_facing.setLayoutManager(RecyclerViewLayoutManager);
        FacingArrayList();
        facingAdapter = new FacingAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_facing.setLayoutManager(HorizontalLayout);
        recycler_facing.setAdapter(facingAdapter);
    }

    private void FacingArrayList() {
        source = new ArrayList<>();
        source.add("North");
        source.add("North-East");
        source.add("North-West");
        source.add("South");
        source.add("South-East");
        source.add("South-West");
        source.add("West");
    }

    private void AmenitiesDetails() {
        albumList = new ArrayList<>();
        amenitiesAdapter = new AmenitiesAdapter(getApplicationContext(), albumList);
        recycler_amenities = (RecyclerView)findViewById(R.id.recycler_amenities);
        HorizontalLayout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_amenities.setLayoutManager(HorizontalLayout);
        recycler_amenities.setItemAnimator(new DefaultItemAnimator());
        recycler_amenities.setAdapter(amenitiesAdapter);
        AmenitiesAlbums();
    }

    private void AmenitiesAlbums() {
        int[] covers = new int[]{R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot,
                R.drawable.plot};

        Album a = new Album("Parking", 13, covers[0]);
        albumList.add(a);

        a = new Album("Lift", 14, covers[1]);
        albumList.add(a);

        a = new Album("Power Backup", 15, covers[2]);
        albumList.add(a);

        a = new Album("Gass Pipeline", 16, covers[3]);
        albumList.add(a);

        a = new Album("Park", 17, covers[4]);
        albumList.add(a);

        a = new Album("Gymnasium", 18, covers[5]);
        albumList.add(a);

        a = new Album("Swimming pool", 19, covers[6]);
        albumList.add(a);

        a = new Album("Club House", 20, covers[7]);
        albumList.add(a);

        amenitiesAdapter.notifyDataSetChanged();
    }

    private void FurnishedStatus() {
        albumList = new ArrayList<>();
        adapter = new FurnishedAdapter(getApplicationContext(), albumList);
        recycler_furnished_status = (RecyclerView)findViewById(R.id.recycler_furnished_status);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycler_furnished_status.setLayoutManager(gridLayoutManager);
        recycler_furnished_status.setItemAnimator(new DefaultItemAnimator());
        recycler_furnished_status.setAdapter(adapter);
        prepareAlbums();
    }

    private void initView() {

        img_close = (AppCompatImageView) findViewById(R.id.img_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void prepareAlbums() {
        int[] covers = new int[]{R.drawable.flat, R.drawable.flat, R.drawable.flat};

        Album a = new Album("Furnished", 13, covers[0]);
        albumList.add(a);

        a = new Album("Semi-Furnished", 8, covers[1]);
        albumList.add(a);

        a = new Album("Un-Furnished", 11, covers[2]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }
}
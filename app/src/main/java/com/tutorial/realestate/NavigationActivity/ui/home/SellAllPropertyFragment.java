package com.tutorial.realestate.NavigationActivity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Activity.Filters.PrimeFilterActivity;
import com.tutorial.realestate.Adapter.BuyAdapter;
import com.tutorial.realestate.Adapter.CommercialAdapter;
import com.tutorial.realestate.Adapter.FilterAdapter;
import com.tutorial.realestate.Adapter.PropertyRentAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class SellAllPropertyFragment extends Fragment {
    View view;
    RecyclerView filers_recycler, recycler_rent_property;
    ArrayList<String> source;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    FilterAdapter adapter;
    LinearLayoutManager HorizontalLayout;
    AppCompatImageView img_back;
    private List<Album> albumList;
    PropertyRentAdapter propertyRentAdapter;
    AppCompatTextView tv_prime_filter, tv_saved_search;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_see_all_property, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        initView();
        return view;
    }

    private void initView() {
        tv_prime_filter = (AppCompatTextView) view.findViewById(R.id.tv_prime_filter);
        tv_prime_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), PrimeFilterActivity.class));
            }
        });
        tv_saved_search = (AppCompatTextView) view.findViewById(R.id.tv_saved_search);


        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });

        filers_recycler = (RecyclerView) view.findViewById(R.id.filers_recycler);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        filers_recycler.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        adapter = new FilterAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        filers_recycler.setLayoutManager(HorizontalLayout);
        filers_recycler.setAdapter(adapter);

        recycler_rent_property = (RecyclerView) view.findViewById(R.id.recycler_rent_property);
        albumList = new ArrayList<>();
        propertyRentAdapter = new PropertyRentAdapter(getActivity(), albumList);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler_rent_property.setLayoutManager(verticalLayoutManager);
        recycler_rent_property.setItemAnimator(new DefaultItemAnimator());
        recycler_rent_property.setAdapter(propertyRentAdapter);
        prepareAlbums();
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1,
                R.drawable.login_1};

        Album a = new Album("\u20B9 15,500", 13, covers[0]);
        albumList.add(a);

        a = new Album("\u20B9 20,400", 8, covers[1]);
        albumList.add(a);

        a = new Album("\u20B9 35,000", 11, covers[2]);
        albumList.add(a);

        a = new Album("\u20B9 18,000", 12, covers[3]);
        albumList.add(a);

        a = new Album("\u20B9 9,000", 14, covers[4]);
        albumList.add(a);

        a = new Album("\u20B9 10,500", 1, covers[5]);
        albumList.add(a);

        a = new Album("\u20B9 11,000", 11, covers[6]);
        albumList.add(a);

        a = new Album("\u20B9 12,700", 14, covers[7]);
        albumList.add(a);

        a = new Album("\u20B9 18,000", 11, covers[8]);
        albumList.add(a);

        a = new Album("\u20B9 14,000", 17, covers[9]);
        albumList.add(a);

        propertyRentAdapter.notifyDataSetChanged();
    }


    public void AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("Budget");
        source.add("BHK");
        source.add("Verified");
        source.add("Owner");
        source.add("Furnished");
        source.add("With Photos");
        source.add("Popular Localities");
        source.add("For Family");
        source.add("For Bachlors");
        source.add("Exclusive");
        source.add("Most Recent");
    }


    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}

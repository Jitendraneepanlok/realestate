package com.tutorial.realestate.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.CommercialAdapter;
import com.tutorial.realestate.Adapter.FilterAdapter;
import com.tutorial.realestate.Adapter.ResidentialProprtyAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;
import com.tutorial.realestate.RecyclerViewCliked.ClickListener;
import com.tutorial.realestate.RecyclerViewCliked.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class CommercialFragment extends Fragment {
    View view;
    private NavController navController;
    RecyclerView filers_recycler, residential_recycler;
    ArrayList<String> source;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    FilterAdapter adapter;
    LinearLayoutManager HorizontalLayout;
    CommercialAdapter commercialAdapter;
    private List<Album> albumList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_commercial, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        initView();
        initView2();
        return view;
    }

    private void initView2() {
        residential_recycler = (RecyclerView) view.findViewById(R.id.residential_recycler);
        albumList = new ArrayList<>();
        commercialAdapter = new CommercialAdapter(getActivity(), albumList);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        residential_recycler.setLayoutManager(verticalLayoutManager);
        residential_recycler.setItemAnimator(new DefaultItemAnimator());
        residential_recycler.setAdapter(commercialAdapter);
        prepareAlbums();

        residential_recycler.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), residential_recycler, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {

//                navController.navigate(R.id.action_residiantialpropertyFragment_to_propertyDetailsFragment);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "Item Clicked" + position, Toast.LENGTH_LONG).show();
            }
        }));


    }

    private void initView() {

        filers_recycler = (RecyclerView) view.findViewById(R.id.filers_recycler);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        filers_recycler.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        adapter = new FilterAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        filers_recycler.setLayoutManager(HorizontalLayout);
        filers_recycler.setAdapter(adapter);

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

        Album a = new Album("3BHK Apartment for Sale in Velachery", 13, covers[0]);
        albumList.add(a);

        a = new Album("8BHK Office for Sale in Velachery", 8, covers[1]);
        albumList.add(a);

        a = new Album("3BHK Shop for Sale", 11, covers[2]);
        albumList.add(a);

        a = new Album("9BHK Complex for Sale in Adambakkam", 12, covers[3]);
        albumList.add(a);

        a = new Album("5BHK Shop for Sale in Addevishvanathapura", 14, covers[4]);
        albumList.add(a);



        commercialAdapter.notifyDataSetChanged();
    }

    public void AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("PROPERTY TYPE");
        source.add("BHK");
        source.add("PROPERTY TYPE");
        source.add("FURNISHING TYPE");
        source.add("MORE");
        source.add("RESET");
        source.add("SORT BY FEATURED");
    }
}
package com.tutorial.realestate.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BuyAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class RentFragment extends Fragment {
    private RecyclerView recyclerView;
    private BuyAdapter adapter;
    private List<Album> albumList;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_rent,container,false);
        initView();
        return view;
    }

    private void initView() {

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new BuyAdapter(getActivity(), albumList);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

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

        Album a = new Album("3BHK Apartment for Sale in Velachery" , 13, covers[0]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 8, covers[1]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 11, covers[2]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 12, covers[3]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 14, covers[4]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 1, covers[5]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 11, covers[6]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 14, covers[7]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 11, covers[8]);
        albumList.add(a);

        a = new Album("3BHK Apartment for Sale in Velachery", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

}

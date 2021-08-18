package com.tutorial.realestate.Fragments.StartingDetailFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BuyAdapter;
import com.tutorial.realestate.Adapter.PopularCityAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class StartPopularCityFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_next;
    View view;
    RecyclerView recycler_popular;
    PopularCityAdapter popularCityAdapter;
    private List<Album> albumList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popular_city, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartContactDetailFragment startContactDetailFragment = new StartContactDetailFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startContactDetailFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        btn_next = (AppCompatButton) view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartAlmostPropertyFragment startAlmostPropertyFragment = new StartAlmostPropertyFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startAlmostPropertyFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
        albumList = new ArrayList<>();
        popularCityAdapter = new PopularCityAdapter(getActivity(), albumList);

        recycler_popular = (RecyclerView) view.findViewById(R.id.recycler_popular);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycler_popular.setLayoutManager(gridLayoutManager);
        recycler_popular.setItemAnimator(new DefaultItemAnimator());
        recycler_popular.setAdapter(popularCityAdapter);
        prepareAlbums();

    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.popular_6,
                R.drawable.popular_4,
                R.drawable.popular_1,
                R.drawable.popular_7,
                R.drawable.popular_2,
                R.drawable.popular_1,
                R.drawable.popular_7,
                R.drawable.popular_3,
                R.drawable.popular_5,
                R.drawable.popular_4};

        Album a = new Album("Noida", 13, covers[0]);
        albumList.add(a);

        a = new Album("Mumbai", 8, covers[1]);
        albumList.add(a);

        a = new Album("Bangalore", 11, covers[2]);
        albumList.add(a);

        a = new Album("Delhi", 12, covers[3]);
        albumList.add(a);

        a = new Album("Bhopal", 14, covers[4]);
        albumList.add(a);

        a = new Album("Pune", 1, covers[5]);
        albumList.add(a);

        a = new Album("Gurgaon", 11, covers[6]);
        albumList.add(a);

        a = new Album("Ghaziabad", 14, covers[7]);
        albumList.add(a);

        a = new Album("Haryana", 11, covers[8]);
        albumList.add(a);

        popularCityAdapter.notifyDataSetChanged();
    }


}

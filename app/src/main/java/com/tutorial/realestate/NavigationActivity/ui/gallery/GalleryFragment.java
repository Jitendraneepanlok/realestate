package com.tutorial.realestate.NavigationActivity.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BuyAdapter;
import com.tutorial.realestate.Adapter.BuyFeatureProductAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    private RecyclerView featproduct_recyler;
    private BuyFeatureProductAdapter adapter;
    private List<Album> albumList;
    private GalleryViewModel galleryViewModel;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        root = inflater.inflate(R.layout.fragment_gallery, container, false);
       /* final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        return root;
    }

    private void initView() {

        featproduct_recyler = (RecyclerView)root.findViewById(R.id.featproduct_recyler);

        albumList = new ArrayList<>();
        adapter = new BuyFeatureProductAdapter(getActivity(), albumList);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        featproduct_recyler.setLayoutManager(verticalLayoutManager);

        featproduct_recyler.setItemAnimator(new DefaultItemAnimator());
        featproduct_recyler.setAdapter(adapter);

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

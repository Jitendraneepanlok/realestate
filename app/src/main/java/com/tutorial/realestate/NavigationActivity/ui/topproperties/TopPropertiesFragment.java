package com.tutorial.realestate.NavigationActivity.ui.topproperties;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BuyFeatureProductAdapter;
import com.tutorial.realestate.Adapter.TopPropertiesAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.NavigationActivity.ui.gallery.GalleryViewModel;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class TopPropertiesFragment extends Fragment {

    private TopProperiesModel topProperiesModel;
    private RecyclerView topproperties_recyler;
    private TopPropertiesAdapter adapter;
    private List<Album> albumList;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        topProperiesModel = ViewModelProviders.of(this).get(TopProperiesModel.class);
        root = inflater.inflate(R.layout.fragment_top_properties, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        TopProperiesModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        return root;
    }

    private void initView() {

        topproperties_recyler = (RecyclerView)root.findViewById(R.id.topproperties_recyler);

        albumList = new ArrayList<>();
        adapter = new TopPropertiesAdapter(getActivity(), albumList);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        topproperties_recyler.setLayoutManager(verticalLayoutManager);

        topproperties_recyler.setItemAnimator(new DefaultItemAnimator());
        topproperties_recyler.setAdapter(adapter);

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

        Album a = new Album("XYZ Kumar" , 13, covers[0]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 8, covers[1]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 11, covers[2]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 12, covers[3]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 14, covers[4]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 1, covers[5]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 11, covers[6]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 14, covers[7]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 11, covers[8]);
        albumList.add(a);

        a = new Album("XYZ Kumar", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

}
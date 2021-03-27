package com.tutorial.realestate.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.FilterAdapter;
import com.tutorial.realestate.Adapter.GalleryAdapter;
import com.tutorial.realestate.Model.ImageModel;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class DetailsGalleryFragment extends Fragment {
    RecyclerView gallery_recycler;
    private ArrayList<ImageModel> imageModelArrayList;
    private GalleryAdapter adapter;

    private int[] myImageList = new int[]{R.drawable.login_1, R.drawable.login_1,R.drawable.property_dummy, R.drawable.login_1,R.drawable.property_dummy,R.drawable.login_1,R.drawable.login_1};
    private String[] myImageNameList = new String[]{"Apple","Mango" ,"Strawberry","Pineapple","Orange","Blueberry","Watermelon"};
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details_gallery,container,false);
        gallery_recycler = (RecyclerView)view.findViewById(R.id.gallery_recycler);

        imageModelArrayList = eatFruits();
        adapter = new GalleryAdapter(getActivity(), imageModelArrayList);
        gallery_recycler.setAdapter(adapter);
        gallery_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
    private ArrayList<ImageModel> eatFruits(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            ImageModel fruitModel = new ImageModel();
            fruitModel.setName(myImageNameList[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
    }
}

package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.OwnerPackageAdapter;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class OwnerPackageFragment extends Fragment {

    View view;
    AppCompatImageView img_back;
    RecyclerView recycler_packages;
    OwnerPackageAdapter adapter;
    ArrayList<String> source;
    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_packages, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OwnerOtpFragment ownerOtpFragment = new OwnerOtpFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, ownerOtpFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        recycler_packages = (RecyclerView) view.findViewById(R.id.recycler_packages);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_packages.setLayoutManager(RecyclerViewLayoutManager);
        AddPackageItemsToRecyclerViewArrayList();
        adapter = new OwnerPackageAdapter(source, getActivity());
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_packages.setLayoutManager(HorizontalLayout);
        recycler_packages.setAdapter(adapter);
    }

    private void AddPackageItemsToRecyclerViewArrayList() {
        source = new ArrayList<>();
        source.add("Free");
        source.add("Diamond");
        source.add("Titanium");
    }
}

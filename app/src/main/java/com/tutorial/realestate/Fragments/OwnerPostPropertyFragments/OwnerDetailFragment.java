package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class OwnerDetailFragment extends Fragment {
    private View view;
    private AppCompatImageView img_back;
    private AppCompatButton btn_continue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_details, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostPropertyOwnerDetailsFragment postPropertyOwnerDetailsFragment = new PostPropertyOwnerDetailsFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, postPropertyOwnerDetailsFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OwnerDetailsTwoFragment ownerDetailsTwoFragment = new OwnerDetailsTwoFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, ownerDetailsTwoFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
    }
}

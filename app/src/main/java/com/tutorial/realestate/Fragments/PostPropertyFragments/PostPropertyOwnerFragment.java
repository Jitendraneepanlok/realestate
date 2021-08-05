package com.tutorial.realestate.Fragments.PostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class PostPropertyOwnerFragment extends Fragment {
    AppCompatImageView img_back;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_post_property, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView)view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostPropertyStartFragment postPropertyStartFragment = new PostPropertyStartFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, postPropertyStartFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
    }
}

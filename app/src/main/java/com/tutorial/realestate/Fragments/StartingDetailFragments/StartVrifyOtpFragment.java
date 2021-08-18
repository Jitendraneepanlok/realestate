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

import com.tutorial.realestate.R;

public class StartVrifyOtpFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_verify;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start_otp_verify,container,false);
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

        btn_verify = (AppCompatButton) view.findViewById(R.id.btn_verify);
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartPopularCityFragment startPopularCityFragment = new StartPopularCityFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startPopularCityFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
    }
}



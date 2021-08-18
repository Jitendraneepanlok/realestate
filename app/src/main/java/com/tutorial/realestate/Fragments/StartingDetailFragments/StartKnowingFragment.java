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

import com.tutorial.realestate.Fragments.AgentPostProperty.AgentOtpVerifyFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.PostPropertyStartFragment;
import com.tutorial.realestate.R;

public class StartKnowingFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_next;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start_knowing, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartFragmentsDetails startFragmentsDetails = new StartFragmentsDetails();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startFragmentsDetails);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        btn_next = (AppCompatButton) view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
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
    }
}


package com.tutorial.realestate.NavigationActivity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tutorial.realestate.Activity.LoginActivity;
import com.tutorial.realestate.Activity.SavedActivity;
import com.tutorial.realestate.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    View view;
    private NavController navController;
    AppCompatImageView img_1, img_2, img_3, img_4, img_5;
    AppCompatTextView login_signup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        initView();
        return view;
    }

    private void initView() {
        img_1 = (AppCompatImageView) view.findViewById(R.id.img_5);
        img_2 = (AppCompatImageView) view.findViewById(R.id.img_5);
        img_3 = (AppCompatImageView) view.findViewById(R.id.img_5);
        img_4 = (AppCompatImageView) view.findViewById(R.id.img_5);
        img_5 = (AppCompatImageView) view.findViewById(R.id.img_5);
        login_signup = (AppCompatTextView) view.findViewById(R.id.login_signup);

        img_1.setOnClickListener(this);
        img_2.setOnClickListener(this);
        img_3.setOnClickListener(this);
        img_4.setOnClickListener(this);
        img_5.setOnClickListener(this);
        login_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_1:
                CallCommonPage();
                break;
            case R.id.img_2:
                CallCommonPage();
                break;
            case R.id.img_3:
                CallCommonPage();
                break;
            case R.id.img_4:
                CallCommonPage();
                break;
            case R.id.img_5:
                CallCommonPage();
                break;
            case R.id.login_signup:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }

    private void CallCommonPage() {
        startActivity(new Intent(getActivity(), SavedActivity.class));

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }


}

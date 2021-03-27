package com.tutorial.realestate.NavigationActivity.ui.others;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OthersFragment extends Fragment {
    OthersModel othersModel;
    View view;
    Spinner all_india,spin_international,spin_adverties;
    String[] allindia = {"All India", "Popular Cities", "Others Cities"};
    String[] international = {" Popular Cities", "Dubai", "Sydney"," Berlin"," Paris","London","Hong Kong","Tokyo"," Amsterdam"," Singapore","Los AngelesNew"," York City"};
    String []adverties = {"Advertise","Featured Property","Top Selling Projects"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        othersModel = ViewModelProviders.of(this).get(OthersModel.class);
        view = inflater.inflate(R.layout.fragment_others, container, false);
        initView();
        return view;
    }

    private void initView() {
        spin_adverties = (Spinner)view.findViewById(R.id.spin_adverties);
        ArrayAdapter adapteradds = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, adverties);
        adapteradds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_adverties.setAdapter(adapteradds);


        spin_international = (Spinner)view.findViewById(R.id.spin_international);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, international);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_international.setAdapter(adapter);


        all_india = (Spinner) view.findViewById(R.id.all_india);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, allindia);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        all_india.setAdapter(aa);
    }
}
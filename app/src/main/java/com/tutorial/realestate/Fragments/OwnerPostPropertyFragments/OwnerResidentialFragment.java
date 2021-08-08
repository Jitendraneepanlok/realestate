package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class OwnerResidentialFragment extends Fragment {
    View view;
    RadioGroup rg_property_type;
    RadioButton radio_flat_apartment, radio_house, radio_villa, radio_builder_floor, radio_plot, radio_studio_aprtment, radio_panthouse, radio_farm_house;
    String selectValue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_residential, container, false);
        initView();
        return view;
    }

    private void initView() {

        radio_flat_apartment = (RadioButton) view.findViewById(R.id.radio_flat_apartment);
        radio_house = (RadioButton) view.findViewById(R.id.radio_house);
        radio_villa = (RadioButton) view.findViewById(R.id.radio_builder);
        radio_builder_floor = (RadioButton) view.findViewById(R.id.radio_builder_floor);
        radio_plot = (RadioButton) view.findViewById(R.id.radio_plot);
        radio_studio_aprtment = (RadioButton) view.findViewById(R.id.radio_studio_aprtment);
        radio_panthouse = (RadioButton) view.findViewById(R.id.radio_panthouse);
        radio_farm_house = (RadioButton) view.findViewById(R.id.radio_farm_house);

        rg_property_type = (RadioGroup) view.findViewById(R.id.rg_property_type);
        rg_property_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_flat_apartment.isChecked()) {
                    selectValue = radio_flat_apartment.getText().toString();
                    CallCommonFragment();
                } else if (radio_house.isChecked()) {
                    selectValue = radio_house.getText().toString();
                    CallCommonFragment();

                } else if (radio_villa.isChecked()) {
                    selectValue = radio_villa.getText().toString();
                    CallCommonFragment();

                } else if (radio_builder_floor.isChecked()) {
                    selectValue = radio_builder_floor.getText().toString();
                    CallCommonFragment();

                } else if (radio_plot.isChecked()) {
                    selectValue = radio_plot.getText().toString();
                    CallCommonFragment();

                } else if (radio_studio_aprtment.isChecked()) {
                    selectValue = radio_studio_aprtment.getText().toString();
                    CallCommonFragment();

                } else if (radio_panthouse.isChecked()) {
                    selectValue = radio_panthouse.getText().toString();
                    CallCommonFragment();

                } else if (radio_farm_house.isChecked()) {
                    selectValue = radio_farm_house.getText().toString();
                    CallCommonFragment();

                }
                Toast.makeText(getActivity(), selectValue, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void CallCommonFragment() {
        OwnerPropertyLocationFragment ownerPropertyLocationFragment = new OwnerPropertyLocationFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, ownerPropertyLocationFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }

}

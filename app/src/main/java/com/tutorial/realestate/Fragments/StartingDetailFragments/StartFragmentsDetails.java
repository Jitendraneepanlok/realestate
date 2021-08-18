package com.tutorial.realestate.Fragments.StartingDetailFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.Activity.PostProperty.PostPropertyActivity;
import com.tutorial.realestate.Fragments.AgentPostProperty.PostPropertyAgentFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.PostPropertyOwnerDetailsFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.PostPropertyWelcomeFragment;
import com.tutorial.realestate.R;

public class StartFragmentsDetails extends Fragment {
    RadioGroup rg_1;
    RadioButton radio_buy_property, radio_rent_pg_property, radio_sell_rent_property, radio_already_post_property;
    String selectValue;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_starting_fragment, container, false);
        initView();

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    getActivity().finish();
                }
                return false;
            }
        });
        return view;
    }

    private void initView() {
        radio_buy_property = (RadioButton) view.findViewById(R.id.radio_buy_property);
        radio_rent_pg_property = (RadioButton) view.findViewById(R.id.radio_rent_pg_property);
        radio_sell_rent_property = (RadioButton) view.findViewById(R.id.radio_sell_rent_property);
        radio_already_post_property = (RadioButton) view.findViewById(R.id.radio_already_post_property);

        rg_1 = (RadioGroup) view.findViewById(R.id.rg_1);
    }

    @Override
    public void onResume() {
        super.onResume();
        radio_buy_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_buy_property.isChecked()) {
                    callCommonFragment();
                }
            }
        });
        radio_rent_pg_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_rent_pg_property.isChecked()) {
                    callCommonFragment();
                }
            }
        });
        radio_sell_rent_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_sell_rent_property.isChecked()) {
                    startActivity(new Intent(getActivity(), PostPropertyActivity.class));
                }
            }
        });
        radio_already_post_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_already_post_property.isChecked()) {
                    startActivity(new Intent(getActivity(), PostPropertyActivity.class));
                }
            }
        });
    }

    private void callCommonFragment() {
        StartKnowingFragment startKnowingFragment = new StartKnowingFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.start_frame_main, startKnowingFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}


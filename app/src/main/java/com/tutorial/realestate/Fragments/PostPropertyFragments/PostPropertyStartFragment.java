package com.tutorial.realestate.Fragments.PostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class PostPropertyStartFragment extends Fragment {
    AppCompatImageView img_back;
    RadioGroup rg_1;
    RadioButton radio_owner, radio_agent, radio_builder;
    String selectValue;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start_post_property, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostPropertyWelcomeFragment postPropertyWelcomeFragment = new PostPropertyWelcomeFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, postPropertyWelcomeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        radio_owner = (RadioButton) view.findViewById(R.id.radio_owner);
        radio_agent = (RadioButton) view.findViewById(R.id.radio_agent);
        radio_builder = (RadioButton) view.findViewById(R.id.radio_builder);

        rg_1 = (RadioGroup) view.findViewById(R.id.rg_1);
        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_owner.isChecked()) {
                    selectValue = radio_owner.getText().toString();
                    CallOwnerFragment();
                } else if (radio_agent.isChecked()) {
                    selectValue = radio_agent.getText().toString();
                    callCommonFragment();

                } else if (radio_builder.isChecked()) {
                    selectValue = radio_builder.getText().toString();
                    callCommonFragment();
                }
                Toast.makeText(getActivity(), selectValue, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void callCommonFragment() {
        PostPropertyAgentFragment postPropertyAgentFragment = new PostPropertyAgentFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, postPropertyAgentFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }

    private void CallOwnerFragment() {
        PostPropertyOwnerDetailsFragment postPropertyOwnerFragment = new PostPropertyOwnerDetailsFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, postPropertyOwnerFragment);
        transaction.addToBackStack("Back");
        transaction.commit();

    }
}

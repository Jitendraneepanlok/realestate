package com.tutorial.realestate.Fragments.AgentPostProperty;

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

import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerDetailFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerPropertyTypeFragment;
import com.tutorial.realestate.R;

public class AgentpropertyPostFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    RadioGroup rg_2;
    RadioButton rb_sell, rb_rent_lease, rb_pg;
    String selectValue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agent_property_category,container,false);
        initView();
        return view;

    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgentOtpVerifyFragment agentOtpVerifyFragment = new AgentOtpVerifyFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, agentOtpVerifyFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        rb_sell = (RadioButton) view.findViewById(R.id.rb_sell);
        rb_rent_lease = (RadioButton) view.findViewById(R.id.rb_rent_lease);
        rb_pg = (RadioButton) view.findViewById(R.id.rb_pg);

        rg_2 = (RadioGroup) view.findViewById(R.id.rg_2);
        rg_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_sell.isChecked()) {
                    selectValue = rb_sell.getText().toString();
                    callCommonFragment();
                } else if (rb_rent_lease.isChecked()) {
                    selectValue = rb_rent_lease.getText().toString();
                    callCommonFragment();
                } else if (rb_pg.isChecked()) {
                    selectValue = rb_pg.getText().toString();

                    Toast.makeText(getActivity(), "comming Soon", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void callCommonFragment() {
        AgentPropertyTypeFragment agentPropertyTypeFragment = new AgentPropertyTypeFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, agentPropertyTypeFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }

}

package com.tutorial.realestate.Fragments.AgentPostProperty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.PostPropertyStartFragment;
import com.tutorial.realestate.R;

public class AgentOtpVerifyFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_continue;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agent_otp_verify,container,false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView)view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostPropertyAgentFragment postPropertyAgentFragment = new PostPropertyAgentFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, postPropertyAgentFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgentpropertyPostFragment agentpropertyPostFragment = new AgentpropertyPostFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, agentpropertyPostFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
    }
}

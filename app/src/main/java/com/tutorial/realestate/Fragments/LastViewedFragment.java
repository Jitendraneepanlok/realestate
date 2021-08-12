package com.tutorial.realestate.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class LastViewedFragment extends Fragment {
    View view;
    AppCompatTextView txt_properties, txt_agent, txt_project,txt_no_contacted, txt_havenot, txt_start_searching;
    AppCompatImageView img_projects;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_last_viewed,container,false);
        initView();
        return view;
    }

    private void initView() {
        img_projects = (AppCompatImageView) view.findViewById(R.id.img_projects);
        txt_no_contacted = (AppCompatTextView) view.findViewById(R.id.txt_no_contacted);
        txt_havenot = (AppCompatTextView) view.findViewById(R.id.txt_havenot);
        txt_start_searching = (AppCompatTextView) view.findViewById(R.id.txt_start_searching);

        txt_properties = (AppCompatTextView) view.findViewById(R.id.txt_properties);
        txt_properties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_projects.setImageResource(R.drawable.property_home);
                txt_no_contacted.setText(getActivity().getResources().getString(R.string.last_viewed));
                txt_havenot.setText(getActivity().getResources().getString(R.string.you_lastviewed));
                txt_start_searching.setText(getActivity().getResources().getString(R.string.start_searcing_lastviewd));
                txt_properties.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style));
                txt_properties.setTextColor(getActivity().getResources().getColor(R.color.white));
                txt_agent.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_agent.setTextColor(getActivity().getResources().getColor(R.color.black));
                txt_project.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_project.setTextColor(getActivity().getResources().getColor(R.color.black));

            }
        });
        txt_agent = (AppCompatTextView) view.findViewById(R.id.txt_agent);
        txt_agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_projects.setImageResource(R.drawable.agent);
                txt_no_contacted.setText(getActivity().getResources().getString(R.string.lastviewed_4));
                txt_havenot.setText(getActivity().getResources().getString(R.string.lastviewed_5));
                txt_start_searching.setText(getActivity().getResources().getString(R.string.lastviewed_6));
                txt_agent.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style));
                txt_agent.setTextColor(getActivity().getResources().getColor(R.color.white));
                txt_properties.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_properties.setTextColor(getActivity().getResources().getColor(R.color.black));
                txt_project.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_project.setTextColor(getActivity().getResources().getColor(R.color.black));

            }
        });
        txt_project = (AppCompatTextView)view.findViewById(R.id.txt_project);
        txt_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_projects.setImageResource(R.drawable.project);
                txt_no_contacted.setText(getActivity().getResources().getString(R.string.lastviewed_1));
                txt_havenot.setText(getActivity().getResources().getString(R.string.lastviewed_2));
                txt_start_searching.setText(getActivity().getResources().getString(R.string.lastviewed_3));
                txt_project.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_project.setTextColor(getActivity().getResources().getColor(R.color.black));
                txt_properties.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_properties.setTextColor(getActivity().getResources().getColor(R.color.black));
                txt_agent.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style_gray));
                txt_agent.setTextColor(getActivity().getResources().getColor(R.color.black));
                txt_project.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.btn_style));
                txt_project.setTextColor(getActivity().getResources().getColor(R.color.white));
            }
        });
    }
}



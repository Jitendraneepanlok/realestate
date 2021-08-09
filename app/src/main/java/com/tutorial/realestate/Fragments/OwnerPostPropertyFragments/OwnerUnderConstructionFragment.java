package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

import java.util.Calendar;

public class OwnerUnderConstructionFragment extends Fragment {
    DatePickerDialog picker;
    AppCompatTextView tv_date;
    AppCompatButton btn_continue;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_under_constraction, container, false);

        initView();
        return view;
    }

    private void initView() {
        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallCommonFragment();
            }
        });
        tv_date = (AppCompatTextView) view.findViewById(R.id.tv_date);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMonthOrYearPicker();
            }
        });

    }

    private void OpenMonthOrYearPicker() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tv_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

    private void CallCommonFragment() {
        OwnerOtpFragment ownerOtpFragment = new OwnerOtpFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, ownerOtpFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }
    }


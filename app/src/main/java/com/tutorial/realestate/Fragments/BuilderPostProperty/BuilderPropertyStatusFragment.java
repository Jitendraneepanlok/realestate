package com.tutorial.realestate.Fragments.BuilderPostProperty;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.Adapter.ConstructionAgeAdapter;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerExpectPriceFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerOtpFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerPropertyStatusFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerReadyToMoveFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerUnderConstructionFragment;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BuilderPropertyStatusFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    DatePickerDialog picker;
    AppCompatTextView tv_date;
    AppCompatButton btn_continue;
    RelativeLayout rl_datepicker, rl_age_contraction;
    AppCompatTextView tv_construction_age;
    AppCompatCheckBox check_under_constrauction, check_ready_to_move;
    String[] ageconstraction = {"New Construction","Less than 5 years","5 to 10 years","10 to 15 years","15 to 20 years","Above 20 years"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_builder_property_status, container, false);
        initView();
        rl_datepicker = (RelativeLayout) view.findViewById(R.id.rl_datepicker);
        rl_datepicker.setVisibility(View.VISIBLE);

        rl_age_contraction = (RelativeLayout) view.findViewById(R.id.rl_age_contraction);
        rl_age_contraction.setVisibility(View.INVISIBLE);
        return view;
    }

    private void initView() {
        check_under_constrauction = (AppCompatCheckBox) view.findViewById(R.id.check_under_constrauction);
        check_ready_to_move = (AppCompatCheckBox) view.findViewById(R.id.check_ready_to_move);
        check_under_constrauction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_under_constrauction.isChecked()) {
                    rl_datepicker.setVisibility(View.VISIBLE);
                    rl_age_contraction.setVisibility(View.GONE);
                } else {
                }
            }
        });

        check_ready_to_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_ready_to_move.isChecked()) {
                    check_ready_to_move.setVisibility(View.VISIBLE);
                    rl_datepicker.setVisibility(View.GONE);
                } else {
                }
            }
        });


        tv_construction_age = (AppCompatTextView) view.findViewById(R.id.tv_construction_age);
        tv_construction_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBottomDialog();
            }
        });
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuilderExpectPriceFragment builderExpectPriceFragment = new BuilderExpectPriceFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, builderExpectPriceFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
        btn_continue = (AppCompatButton) view.findViewById(R.id.btn_continue);
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
        BuilderOtpFragment builderOtpFragment = new BuilderOtpFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, builderOtpFragment);
        transaction.addToBackStack("Back");
        transaction.commit();
    }


    private void OpenBottomDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bedroom_dialog_ready);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ListView recycler_view_age_constraction = (ListView) dialog.findViewById(R.id.recycler_view_age_constraction);
        ConstructionAgeAdapter adapter = new ConstructionAgeAdapter(getActivity(), ageconstraction);
        recycler_view_age_constraction.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

}



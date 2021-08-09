package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.ConstructionAgeAdapter;
import com.tutorial.realestate.Adapter.FloorAdapter;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class OwnerReadyToMoveFragment extends Fragment {
    View view;
    AppCompatTextView tv_construction_age;
    ArrayList<String> listdata;
    AppCompatButton btn_continue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_ready_to_move, container, false);

        initView();
        return view;
    }

    private void initView() {
        tv_construction_age = (AppCompatTextView) view.findViewById(R.id.tv_construction_age);
        tv_construction_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBottomDialog();
            }
        });

        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallCommonFraggment();
            }
        });
    }

    private void CallCommonFraggment() {
        OwnerOtpFragment ownerOtpFragment = new OwnerOtpFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, ownerOtpFragment);
        transaction.addToBackStack("Back");
        transaction.commit();

    }

    private void OpenBottomDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bedroom_dialog);
        dialog.setCancelable(false);

        ArrayList<String> listdata = new ArrayList<>();

        AppCompatImageView img_cancel = dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        RecyclerView recycler_age = (RecyclerView) dialog.findViewById(R.id.recycler_age);
        ConstructionAgeAdapter adapter = new ConstructionAgeAdapter(getActivity(), listdata);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler_age.setLayoutManager(verticalLayoutManager);
        ConstructionListData();
        recycler_age.setItemAnimator(new DefaultItemAnimator());
        recycler_age.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

    private void ConstructionListData() {
        listdata = new ArrayList<>();
        listdata.add("New Construction");
        listdata.add("Less than 5 years");
        listdata.add("5 to 10 years");
        listdata.add("10 to 15 years");
        listdata.add("15 to 20 years");
        listdata.add("Above 20 years");
    }
}

package com.tutorial.realestate.Fragments.BuilderPostProperty;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.Adapter.BrokeragePriceAdapter;
import com.tutorial.realestate.Adapter.FloorAdapter;
import com.tutorial.realestate.Fragments.AgentPostProperty.AgentPropertyLocationFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerPropertyStatusFragment;
import com.tutorial.realestate.R;

public class BuilderExpectPriceFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_continue;
    String[] brokerpricelist = {"No Brokerage", "0.25%", "0.5%", "0.75%", "1%", "1.5%", "2%", "3%", "4%", "5%"};
    AppCompatTextView txt_broerage;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_builder_expected_price, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuilderMoreDetailsFragment builderMoreDetailsFragment = new BuilderMoreDetailsFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, builderMoreDetailsFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });
        btn_continue = (AppCompatButton) view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuilderPropertyStatusFragment builderPropertyStatusFragment = new BuilderPropertyStatusFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, builderPropertyStatusFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        txt_broerage = (AppCompatTextView) view.findViewById(R.id.txt_broerage);
        txt_broerage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBrokeragePriceDialog();
            }
        });
    }

    private void OpenBrokeragePriceDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.brokerage_price_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ListView brokerage_list = (ListView) dialog.findViewById(R.id.brokerage_list);
        BrokeragePriceAdapter adapter = new BrokeragePriceAdapter(getActivity(), brokerpricelist);
        brokerage_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();


    }
}

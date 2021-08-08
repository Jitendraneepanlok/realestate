package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.PostPropertyAdapter;
import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class PostPropertyWelcomeFragment extends Fragment {
    View view;
    AppCompatTextView tv_price;
    RecyclerView post_recyler_view;
    PostPropertyAdapter adapter;
    ArrayList<String> source;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager HorizontalLayout;
    AppCompatImageView img_back;
    AppCompatButton btn_continue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome_post_property, container, false);
        initView();
        return view;
    }

    private void initView() {
        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallStartFragment();
            }
        });
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });
        tv_price = (AppCompatTextView) view.findViewById(R.id.tv_price);
        tv_price.setText(getResources().getString(R.string.post_5) + " 5000");
        tv_price.setPaintFlags(tv_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        post_recyler_view = (RecyclerView) view.findViewById(R.id.post_recyler_view);

        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        post_recyler_view.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        adapter = new PostPropertyAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        post_recyler_view.setLayoutManager(HorizontalLayout);
        post_recyler_view.setAdapter(adapter);
    }



    public void AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("Uploading Property Photos");
        source.add("Tagging the right locality");
        source.add("Contacing intrested buyers");

    }
    private void CallStartFragment() {
        PostPropertyStartFragment postPropertyStartFragment = new PostPropertyStartFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.post_propertyfragments, postPropertyStartFragment);
        transaction.addToBackStack("Back");
        transaction.commit();

    }
}

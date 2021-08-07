package com.tutorial.realestate.Fragments.PostPropertyFragments;

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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.BedroomAdapter;
import com.tutorial.realestate.Adapter.FilterAdapter;
import com.tutorial.realestate.Interface.RecyclerItemClickListener;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class OwnerMoreDetailsFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    RecyclerView recyler_bedroom, recyler_bathroom, recyler_balcony;
    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<String> source;
    BedroomAdapter bedroomAdapter;
    BathroomAdapter bathroomAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_more_details, container, false);
        initView();
        return view;
    }

    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OwnerPropertyLocationFragment ownerPropertyLocationFragment = new OwnerPropertyLocationFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, ownerPropertyLocationFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        recyler_bedroom = (RecyclerView) view.findViewById(R.id.recyler_bedroom);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyler_bedroom.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        bedroomAdapter = new BedroomAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyler_bedroom.setLayoutManager(HorizontalLayout);
        recyler_bedroom.setAdapter(bedroomAdapter);
        recyler_bedroom.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        switch (position) {

                            case 0:

                                break;
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                ShortBedroomDialog();
                                break;
                        }

                    }
                })
        );



        recyler_bathroom = (RecyclerView) view.findViewById(R.id.recyler_bathroom);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyler_bathroom.setLayoutManager(RecyclerViewLayoutManager);
        AddBathroomItemsToRecyclerViewArrayList();
        bathroomAdapter = new BathroomAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyler_bathroom.setLayoutManager(HorizontalLayout);
        recyler_bathroom.setAdapter(bathroomAdapter);

        recyler_bathroom.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        switch (position) {

                            case 0:

                                break;
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                ShortBathroomDialog();
                                break;
                        }

                    }
                })
        );

        recyler_balcony = (RecyclerView) view.findViewById(R.id.recyler_balcony);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyler_balcony.setLayoutManager(RecyclerViewLayoutManager);
        AddBathroomItemsToRecyclerViewArrayList();
        bathroomAdapter = new BathroomAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyler_balcony.setLayoutManager(HorizontalLayout);
        recyler_balcony.setAdapter(bathroomAdapter);
        recyler_balcony.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        switch (position) {

                            case 0:

                                break;
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                ShortBalconyDialog();
                                break;
                        }

                    }
                })
        );

    }


    private void AddBathroomItemsToRecyclerViewArrayList() {
        source = new ArrayList<>();
        source.add("0");
        source.add("1");
        source.add("2");
        source.add("3");
        source.add("4");
        source.add("+4");

    }

    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("1 BHK");
        source.add("2 BHK");
        source.add("3 BHK");
        source.add("4 BHK");
        source.add("5 BHK");
        source.add("5 BHK+");
    }

    private void ShortBedroomDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bedroom_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

    private void ShortBalconyDialog(){
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bedhroom_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

    private void ShortBathroomDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bathroom_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();


    }

}
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

import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.BedroomAdapter;
import com.tutorial.realestate.Adapter.FloorAdapter;
import com.tutorial.realestate.Adapter.NoFloorAdapter;
import com.tutorial.realestate.Adapter.SuperAreaAdapter;
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
    ArrayList<String>listdata;
    BedroomAdapter bedroomAdapter;
    BathroomAdapter bathroomAdapter;
    AppCompatTextView txt_popup,txt_floor_no_popup,txt_sqft_2,txt_sqft;
    AppCompatButton btn_continue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_more_details, container, false);
        initView();
        return view;
    }

    private void initView() {
        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OwnerExpectPriceFragment ownerExpectPriceFragment = new OwnerExpectPriceFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, ownerExpectPriceFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

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

        txt_popup = (AppCompatTextView)view.findViewById(R.id.txt_popup);
        txt_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFloorDialog();
            }
        });


        txt_floor_no_popup = (AppCompatTextView)view.findViewById(R.id.txt_floor_no_popup);
        txt_floor_no_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFloorNoDialog();
            }
        });


        txt_sqft_2 = (AppCompatTextView)view.findViewById(R.id.txt_sqft_2);
        txt_sqft_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSuperAreaDialog();
            }
        });

        txt_sqft = (AppCompatTextView)view.findViewById(R.id.txt_sqft);
        txt_sqft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSuperAreaDialog();
            }
        });
    }

    private void OpenSuperAreaDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.super_area_dialog);
        dialog.setCancelable(false);
        ArrayList<String> listdata = new ArrayList<>();

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        RecyclerView super_area_recycler = (RecyclerView) dialog.findViewById(R.id.super_area_recycler);
        super_area_recycler.setHasFixedSize(true);

        SuperAreaAdapter adapter = new SuperAreaAdapter(getActivity(), listdata);
        final  LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        super_area_recycler.setLayoutManager(verticalLayoutManager);
        SuperAreaListData();
        super_area_recycler.setItemAnimator(new DefaultItemAnimator());
        super_area_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    private void SuperAreaListData() {
        listdata = new ArrayList<>();
        listdata.add("Sqft");
        listdata.add("Sqyrd");
        listdata.add("Sqm");
        listdata.add("Acre");
        listdata.add("Bigha");
        listdata.add("Hectare");
        listdata.add("Marla");
        listdata.add("Kanal");
        listdata.add("Biswa 1");
        listdata.add("Biswa 2");
        listdata.add("Ground");
        listdata.add("Aankadam");
        listdata.add("Rood");
        listdata.add("Chatak");
        listdata.add("Kottah");
        listdata.add("Cent");
        listdata.add("Perch");
        listdata.add("Guntha");
        listdata.add("Are");
        
    }

    private void OpenFloorNoDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.no_floor_dialog);
        dialog.setCancelable(false);
        ArrayList<String> listdata = new ArrayList<>();

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        RecyclerView floor_recycler = (RecyclerView) dialog.findViewById(R.id.floor_recycler);
        NoFloorAdapter adapter = new NoFloorAdapter(getActivity(), source);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        floor_recycler.setLayoutManager(verticalLayoutManager);
        NoFloorListData();
        floor_recycler.setItemAnimator(new DefaultItemAnimator());
        floor_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();


    }

    private void NoFloorListData() {
        listdata = new ArrayList<>();
        listdata.add("Lower Basement");
        listdata.add("Upper Basement");
        listdata.add("Ground");
        listdata.add("1");
        listdata.add("2");
        listdata.add("3");
        listdata.add("4");
        listdata.add("5");
        listdata.add("6");
        listdata.add("7");
        listdata.add("8");
        listdata.add("9");
        listdata.add("10");
        listdata.add("11");
        listdata.add("12");
        listdata.add("13");
        listdata.add("14");
        listdata.add("15");
        listdata.add("16");
        listdata.add("17");
        listdata.add("18");
        listdata.add("10");
        listdata.add("20");
        listdata.add("21");
        listdata.add("22");
        listdata.add("23");
        listdata.add("24");
        listdata.add("25");

    }

    private void OpenFloorDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.floor_dialog);
        dialog.setCancelable(false);
        ArrayList<String> listdata = new ArrayList<>();

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        RecyclerView floor_recycler = (RecyclerView) dialog.findViewById(R.id.floor_recycler);
        FloorAdapter adapter = new FloorAdapter(getActivity(), source);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        floor_recycler.setLayoutManager(verticalLayoutManager);
        FloorListData();
        floor_recycler.setItemAnimator(new DefaultItemAnimator());
        floor_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();


    }

    private void FloorListData() {
        source = new ArrayList<>();
        source.add("1");
        source.add("2");
        source.add("3");
        source.add("4");
        source.add("5");
        source.add("6");
        source.add("7");
        source.add("8");
        source.add("9");
        source.add("10");
        source.add("11");
        source.add("12");
        source.add("13");
        source.add("14");
        source.add("15");
        source.add("16");
        source.add("17");
        source.add("18");
        source.add("10");
        source.add("20");
        source.add("21");
        source.add("22");
        source.add("23");
        source.add("24");
        source.add("25");

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
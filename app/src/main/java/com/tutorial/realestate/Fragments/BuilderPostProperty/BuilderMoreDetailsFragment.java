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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.BedRoomListAdapter;
import com.tutorial.realestate.Adapter.BedroomAdapter;
import com.tutorial.realestate.Adapter.FloorAdapter;
import com.tutorial.realestate.Adapter.NoFloorAdapter;
import com.tutorial.realestate.Adapter.SuperAreaAdapter;
import com.tutorial.realestate.Fragments.AgentPostProperty.AgentPropertyLocationFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerExpectPriceFragment;
import com.tutorial.realestate.Interface.RecyclerItemClickListener;
import com.tutorial.realestate.R;

import java.util.ArrayList;

public class BuilderMoreDetailsFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    RecyclerView recyler_bedroom, recyler_bathroom, recyler_balcony;
    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<String> source;
    BedroomAdapter bedroomAdapter;
    BathroomAdapter bathroomAdapter;
    AppCompatTextView txt_popup, txt_floor_no_popup, txt_sqft_2, txt_sqft;
    AppCompatButton btn_continue;
    String[] bedroomlist = {"6 BHK", "7 BHK", "8 BHK", "9 BHK", "10 BHK", ">10 BHK"};
    String[] superAreaList = {"Sqft", "Sqyrd", "Sqm", "Acre", "Bigha", "Hectare", "Marla", "Kanal", "Biswa 1", "Biswa 2", "Ground", "Aankadam", "Rood", "Chatak", "Kottah", "Cent", "Perch", "Guntha", "Are"};

    String[] floorsbuildinglist = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"};

    String[] floornolist ={"Lower Basement","Upper Basement","Ground","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bulder_more_details, container, false);
        initView();

        return view;
    }

    private void initView() {
        btn_continue = (AppCompatButton) view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
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

        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgentPropertyLocationFragment agentPropertyLocationFragment = new AgentPropertyLocationFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, agentPropertyLocationFragment);
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

        txt_popup = (AppCompatTextView) view.findViewById(R.id.txt_popup);
        txt_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFloorBuildingDialog();
            }
        });


        txt_floor_no_popup = (AppCompatTextView) view.findViewById(R.id.txt_floor_no_popup);
        txt_floor_no_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFloorNoDialog();
            }
        });


        txt_sqft_2 = (AppCompatTextView) view.findViewById(R.id.txt_sqft_2);
        txt_sqft_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSuperAreaDialog();
            }
        });

        txt_sqft = (AppCompatTextView) view.findViewById(R.id.txt_sqft);
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

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ListView super_area_list = (ListView) dialog.findViewById(R.id.super_area_list);
        SuperAreaAdapter adapter = new SuperAreaAdapter(getActivity(), superAreaList);
        super_area_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();
    }

    private void OpenFloorNoDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.no_floor_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ListView floor_no_recycler = (ListView) dialog.findViewById(R.id.floor_no_recycler);

        NoFloorAdapter adapter = new NoFloorAdapter(getActivity(), floornolist);
        floor_no_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();


    }


    private void OpenFloorBuildingDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.floor_dialog);
        dialog.setCancelable(false);

        AppCompatImageView img_cancel = (AppCompatImageView) dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ListView floor_recycler = (ListView) dialog.findViewById(R.id.floor_recycler);
        FloorAdapter adapter = new FloorAdapter(getActivity(), floorsbuildinglist);
        floor_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();


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
        ListView listview_age_constraction = (ListView) dialog.findViewById(R.id.listview_age_constraction);
        BedRoomListAdapter adapter = new BedRoomListAdapter(getActivity(), bedroomlist);
        listview_age_constraction.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }

    private void ShortBalconyDialog() {
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

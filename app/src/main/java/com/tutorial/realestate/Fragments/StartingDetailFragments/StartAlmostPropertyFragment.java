package com.tutorial.realestate.Fragments.StartingDetailFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.AlmostBedroomadapter;
import com.tutorial.realestate.Adapter.AlmostPropertyAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class StartAlmostPropertyFragment extends Fragment {
    AppCompatImageView img_back;
    AppCompatButton btn_next;
    View view;
    RecyclerView recycler_type_property, recycler_bedroom, recycler_type_commercial;
    AlmostPropertyAdapter adapter;
    private List<Album> albumList;
    AppCompatSpinner spin_min, spin_max, spin_sqft, spin_min_area, spin_max_area;
    String[] min_price = {"\u20B9 Min", "\u20B9 5 Lac", "\u20B9 10 Lac", "\u20B9 20 Lac", "\u20B9 30 Lac", "\u20B9 40 Lac", "\u20B9 50 Lac", "\u20B9 60 Lac"};
    String[] max_price = {"\u20B9 Max", "\u20B9 10 Lac", "\u20B9 20 Lac", "\u20B9 30 Lac", "\u20B9 40 Lac", "\u20B9 50 Lac", "\u20B9 60 Lac", "\u20B9 70 Lac"};
    String[] square_area = {"Sqft", "Sqyrd", "Sqm", "Acre", "Bigha", "Hectare", "Marla", "Kanal", "Biswa 1", "Biswa 2", "Ground", "Aankadam", "Rood", "Chatak", "Kottah", "Cent", "Perch", "Guntha", "Are"};
    String[] min_area = {"Min", "100", "200", "300", "400", "1000", "1500", "2000", "3000", "4000", "5000", "10000", "25000", "50000", "50000+"};
    String[] max_area = {"Max", "100", "200", "300", "400", "1000", "1500", "2000", "3000", "4000", "5000", "10000", "25000", "50000", "50000+"};

    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<String> source;
    AlmostBedroomadapter almostBedroomadapter;
    RadioGroup rg_property_type;
    RadioButton radio_residential, radio_commercial;
    AppCompatTextView txt_bedroom;
    RelativeLayout rl_almost_3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start_almost_property, container, false);
        initView();
        recycler_type_property.setVisibility(View.VISIBLE);
        recycler_bedroom.setVisibility(View.VISIBLE);
        recycler_type_commercial.setVisibility(View.GONE);
        rl_almost_3.setVisibility(View.GONE);
        txt_bedroom.setVisibility(View.VISIBLE);
        return view;
    }

    private void initView() {
        spin_sqft = (AppCompatSpinner) view.findViewById(R.id.spin_sqft);
        spin_min_area = (AppCompatSpinner) view.findViewById(R.id.spin_min_area);
        spin_max_area = (AppCompatSpinner) view.findViewById(R.id.spin_max_area);
        rl_almost_3 = (RelativeLayout) view.findViewById(R.id.rl_almost_3);
        txt_bedroom = (AppCompatTextView) view.findViewById(R.id.txt_bedroom);
        recycler_type_commercial = (RecyclerView) view.findViewById(R.id.recycler_type_commercial);
        radio_commercial = (RadioButton) view.findViewById(R.id.radio_commercial);
        radio_residential = (RadioButton) view.findViewById(R.id.radio_residential);

        rg_property_type = (RadioGroup) view.findViewById(R.id.rg_property_type);

        spin_min = (AppCompatSpinner) view.findViewById(R.id.spin_min);
        ArrayAdapter minprice = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, min_price);
        minprice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_min.setAdapter(minprice);


        spin_max = (AppCompatSpinner) view.findViewById(R.id.spin_max);
        ArrayAdapter maxprice = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, max_price);
        maxprice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_max.setAdapter(maxprice);

        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartPopularCityFragment startPopularCityFragment = new StartPopularCityFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startPopularCityFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        btn_next = (AppCompatButton) view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* StartAlmostPropertyFragment startAlmostPropertyFragment = new StartAlmostPropertyFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.start_frame_main, startAlmostPropertyFragment);
                transaction.addToBackStack("Back");
                transaction.commit();*/
            }
        });

        albumList = new ArrayList<>();
        adapter = new AlmostPropertyAdapter(getActivity(), albumList);
        recycler_type_property = (RecyclerView) view.findViewById(R.id.recycler_type_property);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycler_type_property.setLayoutManager(gridLayoutManager);
        recycler_type_property.setItemAnimator(new DefaultItemAnimator());
        recycler_type_property.setAdapter(adapter);
        prepareAlbums();


        recycler_bedroom = (RecyclerView) view.findViewById(R.id.recycler_bedroom);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_bedroom.setLayoutManager(RecyclerViewLayoutManager);
        BedroomArrayList();
        almostBedroomadapter = new AlmostBedroomadapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_bedroom.setLayoutManager(HorizontalLayout);
        recycler_bedroom.setAdapter(almostBedroomadapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        radio_residential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_residential.isChecked()) {
                    recycler_type_property.setVisibility(View.VISIBLE);
                    recycler_bedroom.setVisibility(View.VISIBLE);
                    recycler_type_commercial.setVisibility(View.GONE);
                    rl_almost_3.setVisibility(View.GONE);
                    txt_bedroom.setVisibility(View.VISIBLE);
                }
            }
        });

        radio_commercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_commercial.isChecked()) {
                    recycler_type_commercial.setVisibility(View.VISIBLE);
                    rl_almost_3.setVisibility(View.VISIBLE);
                    recycler_type_property.setVisibility(View.GONE);
                    recycler_bedroom.setVisibility(View.GONE);
                    txt_bedroom.setVisibility(View.GONE);
                    CallCommercialPropertyType();
                    CallAllSpinner();
                }
            }
        });
    }

    private void CallAllSpinner() {
        ArrayAdapter squareArea = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, square_area);
        squareArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_sqft.setAdapter(squareArea);

        ArrayAdapter minArea = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, min_area);
        minArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_min_area.setAdapter(minArea);

        ArrayAdapter maxArea = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, max_area);
        maxArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_max_area.setAdapter(maxArea);
    }

    private void CallCommercialPropertyType() {
        albumList = new ArrayList<>();
        adapter = new AlmostPropertyAdapter(getActivity(), albumList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycler_type_commercial.setLayoutManager(gridLayoutManager);
        recycler_type_commercial.setItemAnimator(new DefaultItemAnimator());
        recycler_type_commercial.setAdapter(adapter);
        prepareCommercial();

    }

    private void prepareCommercial() {
        int[] covers = new int[]{
                R.drawable.office_space,
                R.drawable.shop,
                R.drawable.other_commercial};

        Album a = new Album("Office Space", 13, covers[0]);
        albumList.add(a);

        a = new Album("Shop / \n Showroom", 8, covers[1]);
        albumList.add(a);

        a = new Album("Other Commercial", 11, covers[2]);
        albumList.add(a);

        adapter.notifyDataSetChanged();

    }

    private void BedroomArrayList() {
        source = new ArrayList<>();
        source.add("1 BHK");
        source.add("2 BHK");
        source.add("3 BHK");
        source.add("4 BHK");
        source.add(">4 BHK");
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.flat,
                R.drawable.villa,
                R.drawable.plot};

        Album a = new Album("Flat", 13, covers[0]);
        albumList.add(a);

        a = new Album("House/Villa", 8, covers[1]);
        albumList.add(a);

        a = new Album("Plot", 11, covers[2]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

}


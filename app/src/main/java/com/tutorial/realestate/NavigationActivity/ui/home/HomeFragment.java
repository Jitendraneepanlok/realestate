package com.tutorial.realestate.NavigationActivity.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.Demandadapter;
import com.tutorial.realestate.Adapter.FreshPropertyAdapter;
import com.tutorial.realestate.Adapter.Localizedadapter;
import com.tutorial.realestate.Adapter.NewlyLaunchedAdapter;
import com.tutorial.realestate.Adapter.PrimeAdapter;
import com.tutorial.realestate.Adapter.ReadyToMoveAdapter;
import com.tutorial.realestate.Adapter.SlidingImage_Adapter;
import com.tutorial.realestate.Fragments.AgentFragment;
import com.tutorial.realestate.Fragments.BuyFragment;
import com.tutorial.realestate.Fragments.RentFragment;
import com.tutorial.realestate.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.banner_images, R.drawable.banner_images, R.drawable.banner_images, R.drawable.banner_images};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ViewPager view_pager_ads;
    View root;
    RecyclerView recycler_prime_member, recycler_fresh_property, recycler_ready_tomove, recycler_new_launch, recycler_demand, recycler_popular_local;
    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<String> source;
    ArrayList<String> fresh_property;
    ArrayList<String> readytomovelist;
    ArrayList<String> newlyLaunchedlist;
    ArrayList<String> demandList;
    ArrayList<String> localizedList;
    AppCompatTextView txt_see_all;
    Localizedadapter localizedadapter;
    Demandadapter demandadapter;
    NewlyLaunchedAdapter newlyLaunchedAdapter;
    ReadyToMoveAdapter readyToMoveAdapter;
    PrimeAdapter primeAdapter;
    FreshPropertyAdapter freshPropertyAdapter;
    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        ViewPager();
        initView();
        return root;
    }

    private void initView() {
        txt_see_all = (AppCompatTextView) root.findViewById(R.id.txt_see_all);
        txt_see_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_to_seeAllPropertyFragment);
            }
        });
        recycler_prime_member = (RecyclerView) root.findViewById(R.id.recycler_prime_member);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_prime_member.setLayoutManager(RecyclerViewLayoutManager);
        AddPrimeList();
        primeAdapter = new PrimeAdapter(source);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_prime_member.setLayoutManager(HorizontalLayout);
        recycler_prime_member.setAdapter(primeAdapter);
        primeAdapter.notifyDataSetChanged();


        recycler_fresh_property = (RecyclerView) root.findViewById(R.id.recycler_fresh_property);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_fresh_property.setLayoutManager(RecyclerViewLayoutManager);
        AddFreshPropertyList();
        freshPropertyAdapter = new FreshPropertyAdapter(fresh_property);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_fresh_property.setLayoutManager(HorizontalLayout);
        recycler_fresh_property.setAdapter(freshPropertyAdapter);
        freshPropertyAdapter.notifyDataSetChanged();


        recycler_ready_tomove = (RecyclerView) root.findViewById(R.id.recycler_ready_tomove);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_ready_tomove.setLayoutManager(RecyclerViewLayoutManager);
        ReadyToMovePropertyList();
        readyToMoveAdapter = new ReadyToMoveAdapter(readytomovelist);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_ready_tomove.setLayoutManager(HorizontalLayout);
        recycler_ready_tomove.setAdapter(readyToMoveAdapter);
        readyToMoveAdapter.notifyDataSetChanged();


        recycler_new_launch = (RecyclerView) root.findViewById(R.id.recycler_new_launch);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_new_launch.setLayoutManager(RecyclerViewLayoutManager);
        NewlyLaunchedPropertyList();
        newlyLaunchedAdapter = new NewlyLaunchedAdapter(newlyLaunchedlist);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_new_launch.setLayoutManager(HorizontalLayout);
        recycler_new_launch.setAdapter(newlyLaunchedAdapter);
        newlyLaunchedAdapter.notifyDataSetChanged();


        recycler_demand = (RecyclerView) root.findViewById(R.id.recycler_demand);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_demand.setLayoutManager(RecyclerViewLayoutManager);
        DemadPropertyList();
        demandadapter = new Demandadapter(demandList);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_demand.setLayoutManager(HorizontalLayout);
        recycler_demand.setAdapter(demandadapter);
        demandadapter.notifyDataSetChanged();


        recycler_popular_local = (RecyclerView) root.findViewById(R.id.recycler_popular_local);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_popular_local.setLayoutManager(RecyclerViewLayoutManager);
        LocalizedList();
        localizedadapter = new Localizedadapter(localizedList);
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_popular_local.setLayoutManager(HorizontalLayout);
        recycler_popular_local.setAdapter(localizedadapter);
        localizedadapter.notifyDataSetChanged();

    }

    private void LocalizedList() {
        localizedList = new ArrayList<>();
        localizedList.add("Noida Extension, Noida");
        localizedList.add("Sector 62, Noida");
        localizedList.add("Sector 137, Noida");
        localizedList.add("White Field, Bangalore");
        localizedList.add("Marathalli, Bangalore");

    }

    private void DemadPropertyList() {
        demandList = new ArrayList<>();
        demandList.add("\u20B9 Rs. 20 Lac-\u20B9 Rs. 88 Lac");
        demandList.add("\u20B9 30 Lac-\u20B9 Rs. 1 Cr");
        demandList.add("\u20B9 40 Lac-\u20B9 Rs. 80 Lac");
        demandList.add("\u20B9 50 Lac-\u20B9 Rs. 60 Lac");
        demandList.add("\u20B9 60 Lac-\u20B9 Rs. 2.5 Cr");
        demandList.add("\u20B9 70 Lac-\u20B9 Rs. 50 Lac");
        demandList.add("\u20B9 80 Lac-\u20B9 Rs. 48 Lac");
        demandList.add("\u20B9 90 Lac-\u20B9 Rs. 38 Lac");

    }

    private void NewlyLaunchedPropertyList() {
        newlyLaunchedlist = new ArrayList<>();
        newlyLaunchedlist.add("\u20B9 Rs. 20 Lac-\u20B9 Rs. 88 Lac");
        newlyLaunchedlist.add("\u20B9 30 Lac-\u20B9 Rs. 1 Cr");
        newlyLaunchedlist.add("\u20B9 40 Lac-\u20B9 Rs. 80 Lac");
        newlyLaunchedlist.add("\u20B9 50 Lac-\u20B9 Rs. 60 Lac");
        newlyLaunchedlist.add("\u20B9 60 Lac-\u20B9 Rs. 2.5 Cr");
        newlyLaunchedlist.add("\u20B9 70 Lac-\u20B9 Rs. 50 Lac");
        newlyLaunchedlist.add("\u20B9 80 Lac-\u20B9 Rs. 48 Lac");
        newlyLaunchedlist.add("\u20B9 90 Lac-\u20B9 Rs. 38 Lac");

    }

    private void ReadyToMovePropertyList() {
        readytomovelist = new ArrayList<>();
        readytomovelist.add("\u20B9 Rs. 20 Lac-\u20B9 Rs. 88 Lac");
        readytomovelist.add("\u20B9 30 Lac-\u20B9 Rs. 1 Cr");
        readytomovelist.add("\u20B9 40 Lac-\u20B9 Rs. 80 Lac");
        readytomovelist.add("\u20B9 50 Lac-\u20B9 Rs. 60 Lac");
        readytomovelist.add("\u20B9 60 Lac-\u20B9 Rs. 2.5 Cr");
        readytomovelist.add("\u20B9 70 Lac-\u20B9 Rs. 50 Lac");
        readytomovelist.add("\u20B9 80 Lac-\u20B9 Rs. 48 Lac");
        readytomovelist.add("\u20B9 90 Lac-\u20B9 Rs. 38 Lac");

    }

    private void AddFreshPropertyList() {
        fresh_property = new ArrayList<>();
        fresh_property.add("\u20B9 Rs. 20 Lac");
        fresh_property.add("\u20B9 30 Lac");
        fresh_property.add("\u20B9 40 Lac");
        fresh_property.add("\u20B9 50 Lac");
        fresh_property.add("\u20B9 60 Lac");
        fresh_property.add("\u20B9 70 Lac");
        fresh_property.add("\u20B9 80 Lac");
        fresh_property.add("\u20B9 90 Lac");
    }

    private void AddPrimeList() {
        source = new ArrayList<>();
        source.add("1 BHK Flat | \u20B9 20 Lac");
        source.add("2 BHK Flat | \u20B9 30 Lac");
        source.add("3 BHK Flat | \u20B9 40 Lac");
        source.add("4 BHK Flat | \u20B9 50 Lac");
        source.add("5 BHK Flat | \u20B9 60 Lac");
        source.add("6 BHK Flat | \u20B9 70 Lac");
        source.add("7 BHK Flat | \u20B9 80 Lac");
        source.add("8 BHK Flat | \u20B9 90 Lac");

    }

    private void ViewPager() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        view_pager_ads = (ViewPager) root.findViewById(R.id.view_pager_ads);

        view_pager_ads.setAdapter(new SlidingImage_Adapter(getActivity(), ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator) root.findViewById(R.id.indicator);
        indicator.setViewPager(view_pager_ads);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES = IMAGES.length;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                view_pager_ads.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
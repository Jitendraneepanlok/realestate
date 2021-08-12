package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tutorial.realestate.Activity.Payment.PaymentActivity;
import com.tutorial.realestate.Adapter.BathroomAdapter;
import com.tutorial.realestate.Adapter.OwnerPackageAdapter;
import com.tutorial.realestate.Adapter.PackageSlideAdapter;
import com.tutorial.realestate.Adapter.SlidingImage_Adapter;
import com.tutorial.realestate.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OwnerPackageFragment extends Fragment {
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.user_profile, R.drawable.user_profile, R.drawable.user_profile};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ViewPager view_pager_ads;
    private AppCompatButton btn_continue;
    View view;
    AppCompatImageView img_back;
    RecyclerView recycler_packages;
    OwnerPackageAdapter adapter;
    ArrayList<String> source;
    LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_packages, container, false);
        initView();
        SecondViewPager();

        return view;
    }

    private void initView() {
        btn_continue = (AppCompatButton)view.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PaymentActivity.class));
            }
        });

        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OwnerOtpFragment ownerOtpFragment = new OwnerOtpFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, ownerOtpFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        recycler_packages = (RecyclerView) view.findViewById(R.id.recycler_packages);
        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recycler_packages.setLayoutManager(RecyclerViewLayoutManager);
        AddPackageItemsToRecyclerViewArrayList();
        adapter = new OwnerPackageAdapter(source, getActivity());
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_packages.setLayoutManager(HorizontalLayout);
        recycler_packages.setAdapter(adapter);
    }

    private void AddPackageItemsToRecyclerViewArrayList() {
        source = new ArrayList<>();
        source.add("Free");
        source.add("Diamond");
        source.add("Titanium");
    }

    private void SecondViewPager() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        view_pager_ads = (ViewPager) view.findViewById(R.id.view_pager_ads);

        view_pager_ads.setAdapter(new PackageSlideAdapter(getActivity(), ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
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

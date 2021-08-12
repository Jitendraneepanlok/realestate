package com.tutorial.realestate.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.Fragments.AgentFragment;
import com.tutorial.realestate.Fragments.BuyFragment;
import com.tutorial.realestate.Fragments.ConactedFragment;
import com.tutorial.realestate.Fragments.LastViewedFragment;
import com.tutorial.realestate.Fragments.RentFragment;
import com.tutorial.realestate.Fragments.SavedSearchFragment;
import com.tutorial.realestate.Fragments.ScheduleTourFragment;
import com.tutorial.realestate.Fragments.ShortListedFragment;
import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.NavigationActivity.ui.home.HomeFragment;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity {
AppCompatImageView img_back;
    TabLayout tab_layout;
    ViewPager view_pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

    initView();
    }

    private void initView() {
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tab_layout.setupWithViewPager(view_pager);
        AddTabsToFragments();

        img_back = (AppCompatImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });
    }

    private void AddTabsToFragments() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFrag(new ConactedFragment(), getString(R.string.contacted));
        viewPagerAdapter.addFrag(new ShortListedFragment(), getString(R.string.shortlisted));
        viewPagerAdapter.addFrag(new LastViewedFragment(), getString(R.string.lastViewed));
        viewPagerAdapter.addFrag(new SavedSearchFragment(), getString(R.string.saved_searched));
        viewPagerAdapter.addFrag(new ScheduleTourFragment(), getString(R.string.sechdule_tour));

        view_pager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
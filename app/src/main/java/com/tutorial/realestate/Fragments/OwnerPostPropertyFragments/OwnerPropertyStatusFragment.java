package com.tutorial.realestate.Fragments.OwnerPostPropertyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class OwnerPropertyStatusFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    TabLayout tab_available;
    ViewPager view_pager_tab_available;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_owner_property_status,container,false);
        initView();
        return view;
    }
    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
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
        tab_available = (TabLayout)view.findViewById(R.id.tab_available);
        tab_available.setTabGravity(TabLayout.GRAVITY_CENTER);
        view_pager_tab_available = (ViewPager)view.findViewById(R.id.view_pager_tab_available);
        AddTabsToFragments();
        tab_available.setupWithViewPager(view_pager_tab_available);


    }
    private void AddTabsToFragments() {
        OwnerPropertyStatusFragment.ViewPagerAdapter viewPagerAdapter = new OwnerPropertyStatusFragment.ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFrag(new OwnerUnderConstructionFragment(), getString(R.string.under_constraction));
        viewPagerAdapter.addFrag(new OwnerReadyToMoveFragment(), getString(R.string.ready_to_move));
        view_pager_tab_available.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm/*, int behavior*/) {
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

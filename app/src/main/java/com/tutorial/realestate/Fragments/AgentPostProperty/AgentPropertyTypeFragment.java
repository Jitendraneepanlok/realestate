package com.tutorial.realestate.Fragments.AgentPostProperty;

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
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerCommercialFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerDetailsTwoFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerPropertyTypeFragment;
import com.tutorial.realestate.Fragments.OwnerPostPropertyFragments.OwnerResidentialFragment;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class AgentPropertyTypeFragment extends Fragment {
    View view;
    AppCompatImageView img_back;
    TabLayout tab_type;
    ViewPager view_pager_type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agent_type_property,container,false);
        initView();
        return view;
    }
    private void initView() {
        img_back = (AppCompatImageView) view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgentpropertyPostFragment agentpropertyPostFragment = new AgentpropertyPostFragment();
                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.post_propertyfragments, agentpropertyPostFragment);
                transaction.addToBackStack("Back");
                transaction.commit();
            }
        });

        tab_type = (TabLayout)view.findViewById(R.id.tab_type);
        tab_type.setTabGravity(TabLayout.GRAVITY_CENTER);
        view_pager_type = (ViewPager)view.findViewById(R.id.view_pager_type);
        AddTabsToFragments();
        tab_type.setupWithViewPager(view_pager_type);


    }
    private void AddTabsToFragments() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFrag(new AgentResidentialFragment(), getString(R.string.residential));
        viewPagerAdapter.addFrag(new AgentCommercialFragment(), getString(R.string.commercial));
        view_pager_type.setAdapter(viewPagerAdapter);
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

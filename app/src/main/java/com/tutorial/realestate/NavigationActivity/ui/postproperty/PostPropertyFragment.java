package com.tutorial.realestate.NavigationActivity.ui.postproperty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.Fragments.AgentFragment;
import com.tutorial.realestate.Fragments.AminitiesFragment;
import com.tutorial.realestate.Fragments.BuyFragment;
import com.tutorial.realestate.Fragments.GalleryPrpertyFragment;
import com.tutorial.realestate.Fragments.GenralInfoFragment;
import com.tutorial.realestate.Fragments.NearbyFragment;
import com.tutorial.realestate.Fragments.PropertyInfoFragment;
import com.tutorial.realestate.Fragments.RentFragment;
import com.tutorial.realestate.NavigationActivity.ui.gallery.GalleryFragment;
import com.tutorial.realestate.NavigationActivity.ui.home.HomeFragment;
import com.tutorial.realestate.NavigationActivity.ui.topproperties.TopProperiesModel;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class PostPropertyFragment extends Fragment {
    private PostpropertyModel postpropertyModel;
    TabLayout tab_layout;
    ViewPager view_pager;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        postpropertyModel = ViewModelProviders.of(this).get(PostpropertyModel.class);
        root = inflater.inflate(R.layout.fragment_post_properties, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        TopProperiesModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        tab_layout = root.findViewById(R.id.tab_layout);
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        view_pager = root.findViewById(R.id.view_pager);
        tab_layout.setupWithViewPager(view_pager);
        AddTabsToFragments();
        return root;
    }
    private void AddTabsToFragments() {
        PostPropertyFragment.ViewPagerAdapter viewPagerAdapter = new PostPropertyFragment.ViewPagerAdapter(this.getChildFragmentManager());
        viewPagerAdapter.addFrag(new GenralInfoFragment(), getString(R.string.genral_info));
        viewPagerAdapter.addFrag(new PropertyInfoFragment(), getString(R.string.property_info));
        viewPagerAdapter.addFrag(new AminitiesFragment(), getString(R.string.aminties));
        viewPagerAdapter.addFrag(new NearbyFragment(), getString(R.string.nearby));
        viewPagerAdapter.addFrag(new GalleryPrpertyFragment(), getString(R.string.gallery));

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

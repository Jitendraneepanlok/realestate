package com.tutorial.realestate.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tutorial.realestate.NavigationActivity.ui.home.HomeFragment;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsFragment extends Fragment {
    private NavController navController;
    TabLayout tab_layout;
    ViewPager view_pager;
    View view;
    TextView tvrequest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_property_details,container,false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        tab_layout = view.findViewById(R.id.tab_layout);
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        view_pager = view.findViewById(R.id.view_pager);
        tab_layout.setupWithViewPager(view_pager);
        AddTabsToFragments();
        tvrequest = (TextView)view.findViewById(R.id.tvrequest);
        tvrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenConactDialog();
            }
        });
        return view;

    }
    private void AddTabsToFragments() {
        PropertyDetailsFragment.ViewPagerAdapter viewPagerAdapter = new PropertyDetailsFragment.ViewPagerAdapter(this.getChildFragmentManager());
        viewPagerAdapter.addFrag(new DescriptionFragment(), getString(R.string.description));
        viewPagerAdapter.addFrag(new DetailsGalleryFragment(), getString(R.string.gallery));
        viewPagerAdapter.addFrag(new FullDetailsFragment(), getString(R.string.details));
        viewPagerAdapter.addFrag(new PropertyNearByFragment(), getString(R.string.nearbylocation));

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
    private void OpenConactDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.contact_dialog_box);
        dialog.setCancelable(false);

        ImageView img_cancel = (ImageView)dialog.findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();


    }

}

package com.tutorial.realestate.NavigationActivity.ui.settings;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tutorial.realestate.NavigationActivity.ui.slideshow.SlideshowViewModel;
import com.tutorial.realestate.R;

public class SeetingFragment extends Fragment {
    private NavController navController;
    SeetingModel seetingModel;
    AppCompatTextView txt_chane_pass, txt_update;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        seetingModel = ViewModelProviders.of(this).get(SeetingModel.class);
        root = inflater.inflate(R.layout.fragment_setting, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
//        initView();
        return root;
    }

/*
    private void initView() {
        txt_chane_pass = (AppCompatTextView) root.findViewById(R.id.txt_chane_pass);
        txt_chane_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_SeetingFragment_to_changePasswordFragment);

            }
        });
        txt_update = (AppCompatTextView) root.findViewById(R.id.txt_update);
        txt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_SeetingFragment_to_updateProfileFragment);
            }
        });
    }
*/
}

package com.tutorial.realestate.NavigationActivity.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tutorial.realestate.NavigationActivity.ui.home.HomeViewModel;
import com.tutorial.realestate.R;

public class NotificationFragment extends Fragment {

    NotifictionModel notifictionModel;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        notifictionModel = ViewModelProviders.of(this).get(NotifictionModel.class);
         view = inflater.inflate(R.layout.fragment_notification,container,false);
        return view;
    }
}

package com.tutorial.realestate.NavigationActivity.ui.popularsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tutorial.realestate.Activity.PostProperty.PostPropertyActivity;
import com.tutorial.realestate.R;

public class PopularSearchFragment extends Fragment {
    private PopularSearchModel popularSearchModel;
    CardView cardfindAgent, cardresidentialproperty, cardpost, cardsale, cardrent, cardcommercial, cardplot;
    private NavController navController;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popular_searches, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        /* final TextView textView = root.findViewById(R.id.text_slideshow);
        PopularSearchModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        return view;
    }

    private void initView() {
        cardplot = (CardView) view.findViewById(R.id.cardplot);
        cardplot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_commercialFragment);
            }
        });

        cardcommercial = (CardView) view.findViewById(R.id.cardcommercial);
        cardcommercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_commercialFragment);
            }
        });

        cardrent = (CardView) view.findViewById(R.id.cardrent);
        cardrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_residiantialpropertyFragment);
            }
        });

        cardsale = (CardView) view.findViewById(R.id.cardsale);
        cardsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_residiantialpropertyFragment);

            }
        });

        cardresidentialproperty = (CardView) view.findViewById(R.id.cardresidentialproperty);
        cardresidentialproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_residiantialpropertyFragment);

            }
        });
        cardfindAgent = (CardView) view.findViewById(R.id.cardfindAgent);
        cardfindAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_popularSearchFragment_to_findAgentFragment);

            }
        });

        cardpost = (CardView) view.findViewById(R.id.cardpost);
        cardpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), PostPropertyActivity.class));
            }
        });
    }
}

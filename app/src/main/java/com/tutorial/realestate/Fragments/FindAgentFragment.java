package com.tutorial.realestate.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.BuyAdapter;
import com.tutorial.realestate.Adapter.FindAgentAdapter;
import com.tutorial.realestate.Helper.Album;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

public class FindAgentFragment extends Fragment {
    private NavController navController;
    private RecyclerView recyclerView;
    private FindAgentAdapter adapter;
    private List<Album> albumList;
    String[] Agents = {"All Agents", "Agents for Rent", "Agents for Buy"};
    Spinner spinagents;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find_agent, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        spinagents = (Spinner) view.findViewById(R.id.spinagents);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, Agents);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinagents.setAdapter(aa);
        initView();
        return view;
    }

    private void initView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new FindAgentAdapter(getActivity(), albumList);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.user_profile,
                R.drawable.user_profile,
                R.drawable.user_profile,
                R.drawable.user_profile};

        Album a = new Album("XYZ User", 13, covers[0]);
        albumList.add(a);

        a = new Album("ABC User", 8, covers[1]);
        albumList.add(a);

        a = new Album("XYZ User", 11, covers[2]);
        albumList.add(a);

        a = new Album("ABC User", 11, covers[2]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

}


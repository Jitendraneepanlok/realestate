package com.tutorial.realestate.NavigationActivity.ui.topproperties;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.realestate.Adapter.TopPropertiesAdapter;
import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Model.TopPropertiesConstantModel;
import com.tutorial.realestate.Model.TopPropertiesModel;
import com.tutorial.realestate.Pojo.TopPropertiesConstantPojo;
import com.tutorial.realestate.R;

import retrofit2.Call;
import retrofit2.Callback;

public class TopPropertiesFragment extends Fragment {

    private TopProperiesModel topProperiesModel;
    private RecyclerView topproperties_recyler;
    private TopPropertiesAdapter adapter;
    private ProgressDialog pDialog;

    View root;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        topProperiesModel = ViewModelProviders.of(this).get(TopProperiesModel.class);
        root = inflater.inflate(R.layout.fragment_top_properties, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        TopProperiesModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        CallTopPropertiesApi();
        return root;
    }



    private void initView() {
        topproperties_recyler = (RecyclerView)root.findViewById(R.id.topproperties_recyler);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        topproperties_recyler.setLayoutManager(verticalLayoutManager);
        topproperties_recyler.setItemAnimator(new DefaultItemAnimator());

    }


    private void CallTopPropertiesApi() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        TopPropertiesModel topPropertiesModel= new TopPropertiesModel();

        TopPropertiesConstantModel topPropertiesConstantModel = new TopPropertiesConstantModel();
        topPropertiesConstantModel.setRealstate(topPropertiesModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TopPropertiesConstantPojo> call = apiService.getTopProperties(topPropertiesConstantModel);
        try {
            call.enqueue(new Callback<TopPropertiesConstantPojo>() {
                @Override
                public void onResponse(Call<TopPropertiesConstantPojo> call, retrofit2.Response<TopPropertiesConstantPojo> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                        adapter = new TopPropertiesAdapter(getActivity(), response.body());

                        topproperties_recyler.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<TopPropertiesConstantPojo> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(getActivity(), "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(getActivity(), "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }

    }

}
package com.tutorial.realestate.NavigationActivity.ui.gallery;

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

import com.tutorial.realestate.Adapter.BuyFeatureProductAdapter;
import com.tutorial.realestate.Network.ApiClient;
import com.tutorial.realestate.Network.ApiInterface;
import com.tutorial.realestate.Model.FeaturePropertiesContsantModel;
import com.tutorial.realestate.Model.FeaturePropertiesModel;
import com.tutorial.realestate.Pojo.FeaturePropertiesContantPojo;
import com.tutorial.realestate.Pojo.FeaturedPropertyPojo;
import com.tutorial.realestate.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class GalleryFragment extends Fragment {
    private RecyclerView featproduct_recyler;
    private BuyFeatureProductAdapter adapter;
    private List<FeaturedPropertyPojo> featuredPropertyList;
    private GalleryViewModel galleryViewModel;
    View root;
    private ProgressDialog pDialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        root = inflater.inflate(R.layout.fragment_gallery, container, false);
       /* final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        FeaturedPropertyCallApi();
        return root;
    }

    private void initView() {

        featproduct_recyler = (RecyclerView)root.findViewById(R.id.featproduct_recyler);

        featuredPropertyList = new ArrayList<>();

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        featproduct_recyler.setLayoutManager(verticalLayoutManager);

        featproduct_recyler.setItemAnimator(new DefaultItemAnimator());

    }


    private void FeaturedPropertyCallApi() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        FeaturePropertiesModel featurePropertiesModel= new FeaturePropertiesModel();

        FeaturePropertiesContsantModel featurePropertiesContsantModel = new FeaturePropertiesContsantModel();
        featurePropertiesContsantModel.setRealstate(featurePropertiesModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<FeaturePropertiesContantPojo> call = apiService.getFeatureProperties(featurePropertiesContsantModel);
        try {
            call.enqueue(new Callback<FeaturePropertiesContantPojo>() {
                @Override
                public void onResponse(Call<FeaturePropertiesContantPojo> call, retrofit2.Response<FeaturePropertiesContantPojo> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        adapter = new BuyFeatureProductAdapter(getActivity(), response.body());
                        featproduct_recyler.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<FeaturePropertiesContantPojo> call, Throwable t) {
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

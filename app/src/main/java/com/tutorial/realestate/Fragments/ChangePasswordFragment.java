package com.tutorial.realestate.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tutorial.realestate.Activity.LoginActivity;
import com.tutorial.realestate.Interface.ApiClient;
import com.tutorial.realestate.Interface.ApiInterface;
import com.tutorial.realestate.Model.ChangePasswordModel;
import com.tutorial.realestate.Model.ForgetPasswordModel;
import com.tutorial.realestate.NavigationActivity.HomeActivity;
import com.tutorial.realestate.Pojo.ChangePassResponse;
import com.tutorial.realestate.Pojo.ForgetPasswordResponse;
import com.tutorial.realestate.R;

import retrofit2.Call;
import retrofit2.Callback;

public class ChangePasswordFragment extends Fragment {
    private NavController navController;
    TextView tvhome;
    EditText etoldpass,etnewpass,etconfpass;
    LinearLayout llbtn_submit;
    private ProgressDialog pDialog;
    String  OLD_PASSWORD,NEW_PASSWORD, CONFIRM_PASSWORD;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_change_password,container,false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        initView();
        return view;
    }

    private void initView() {
        etoldpass = (EditText)view.findViewById(R.id.etoldpass);
        etnewpass = (EditText)view.findViewById(R.id.etnewpass);
        etconfpass = (EditText)view.findViewById(R.id.etconfpass);
        llbtn_submit = (LinearLayout)view.findViewById(R.id.llbtn_submit);
        llbtn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
        tvhome = (TextView)view.findViewById(R.id.tvhome);
        tvhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });

    }

    private void validation() {

         OLD_PASSWORD = etoldpass.getText().toString().trim();
         NEW_PASSWORD = etnewpass.getText().toString().trim();
         CONFIRM_PASSWORD = etconfpass.getText().toString().trim();

        if (!OLD_PASSWORD.equals("")){
            if (!NEW_PASSWORD.equals("")){
                if (!CONFIRM_PASSWORD.equals("")){
                    ChangePasswordApi();
                }else {
                    etconfpass.setError("Enter your confirm password");
                }
            }else {
                etnewpass.setError("Enter your new password");
            }
        }else {
            etoldpass.setError("Enter your old Password");
        }
    }

    private void ChangePasswordApi() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        ChangePasswordModel changePasswordModel= new ChangePasswordModel();
        changePasswordModel.setCPassword(OLD_PASSWORD);
        changePasswordModel.setNewPassword(NEW_PASSWORD);
        changePasswordModel.setConfirmPassword(CONFIRM_PASSWORD);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ChangePassResponse> call = apiService.postchangepass("application/json", changePasswordModel);
        try {
            call.enqueue(new Callback<ChangePassResponse>() {
                @Override
                public void onResponse(Call<ChangePassResponse> call, retrofit2.Response<ChangePassResponse> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        etoldpass.setText("");
                        etnewpass.setText("");
                        etconfpass.setText("");
                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<ChangePassResponse> call, Throwable t) {
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

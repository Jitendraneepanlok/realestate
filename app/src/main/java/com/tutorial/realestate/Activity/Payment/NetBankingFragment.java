package com.tutorial.realestate.Activity.Payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.tutorial.realestate.R;

public class NetBankingFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    View view;
    AppCompatSpinner spin_other_bank;
    String[] options = {"HDFC BANK", "AXIX BANK", "ICICI BANK", "BANK OF INDIA", "SBI BANK", "YES BANK", "CANARA BANK", "CITY BANK", "UNION BANK", "DCB BANK", "IDFC BANK", "PUNJAB NATIONAL BANK", "INDUSLND BANK"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_net_banking, container, false);
        initView();
        return view;
    }

    private void initView() {

        spin_other_bank = (AppCompatSpinner) view.findViewById(R.id.spin_other_bank);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, options);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_other_bank.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getActivity(), options[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
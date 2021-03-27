package com.tutorial.realestate.NavigationActivity.ui.others;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OthersModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OthersModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is others fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

package com.tutorial.realestate.NavigationActivity.ui.popularsearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PopularSearchModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PopularSearchModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Post PopularSearch fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}


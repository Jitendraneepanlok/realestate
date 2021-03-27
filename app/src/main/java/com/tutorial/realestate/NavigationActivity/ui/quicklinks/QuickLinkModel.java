package com.tutorial.realestate.NavigationActivity.ui.quicklinks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuickLinkModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuickLinkModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is QuickLink fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

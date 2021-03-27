package com.tutorial.realestate.NavigationActivity.ui.notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotifictionModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotifictionModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notification fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

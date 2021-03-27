package com.tutorial.realestate.NavigationActivity.ui.postproperty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PostpropertyModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PostpropertyModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Post Properties fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}


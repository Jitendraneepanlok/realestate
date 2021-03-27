package com.tutorial.realestate.NavigationActivity.ui.topproperties;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopProperiesModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TopProperiesModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Top Properties fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

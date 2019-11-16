package com.silwester.smoothluggagecustomer.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MeasureLuggageViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeasureLuggageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("MeasureLuggageFragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
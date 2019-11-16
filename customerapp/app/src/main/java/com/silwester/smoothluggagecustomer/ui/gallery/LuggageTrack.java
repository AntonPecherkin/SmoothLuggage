package com.silwester.smoothluggagecustomer.ui.gallery;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class LuggageTrack {
    int counter;

    public LuggageTrack(int counter) {
        this.counter = counter;
    }

    public LuggageTrack() {
    }


}

package com.silwester.smoothluggagecustomer.ui.measure;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.silwester.smoothluggagecustomer.R;

public class BookingReferenceFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking_reference, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        final Button measureButton = view.findViewById(R.id.enter_booking_ref);
        final EditText edit = view.findViewById(R.id.refNumEdit);
        final TextView hint = view.findViewById(R.id.hint);
        measureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable text = edit.getText();
                if (text != null && text.toString().length() <3 ) {
                    hint.setVisibility(View.VISIBLE);
                    return;
                } else {
                    hint.setVisibility(View.GONE);
                }
                Navigation.findNavController(view).navigate(R.id.ref_to_measure);
            }
        });
    }
}
package com.silwester.smoothluggagecustomer.ui.gallery;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.silwester.smoothluggagecustomer.R;

import static android.support.constraint.Constraints.TAG;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference("message");

        final CheckBox chCheckIn = root.findViewById(R.id.chCheckIn);
        final CheckBox chCheckProhibitedItems = root.findViewById(R.id.chCheckProhibitedItems);
        final CheckBox chManualCheckProhibitedItems = root.findViewById(R.id.chManualCheckProhibitedItems);
        final CheckBox chLoadToAirplane = root.findViewById(R.id.chLoadToAirplane);
        final CheckBox chInFlight = root.findViewById(R.id.chInFlight);
        final CheckBox chLoadFromPlain = root.findViewById(R.id.chLoadFromPlain);
        final CheckBox chСonveyorLoad = root.findViewById(R.id.chСonveyorLoad);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value =dataSnapshot.getValue(Long.class).intValue();
                Log.d(TAG, "Value is: " + value);
                switch (value) {
                    case 0:
                        chCheckIn.setChecked(false);
                        chCheckProhibitedItems.setChecked(false);
                        chManualCheckProhibitedItems.setChecked(false);
                        chLoadToAirplane.setChecked(false);
                        chInFlight.setChecked(false);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 1:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(false);
                        chManualCheckProhibitedItems.setChecked(false);
                        chLoadToAirplane.setChecked(false);
                        chInFlight.setChecked(false);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 2:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(false);
                        chLoadToAirplane.setChecked(false);
                        chInFlight.setChecked(false);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 3:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(true);
                        chLoadToAirplane.setChecked(false);
                        chInFlight.setChecked(false);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 4:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(true);
                        chLoadToAirplane.setChecked(true);
                        chInFlight.setChecked(false);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 5:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(true);
                        chLoadToAirplane.setChecked(true);
                        chInFlight.setChecked(true);
                        chLoadFromPlain.setChecked(false);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 6:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(true);
                        chLoadToAirplane.setChecked(true);
                        chInFlight.setChecked(true);
                        chLoadFromPlain.setChecked(true);
                        chСonveyorLoad.setChecked(false);
                        break;
                    case 7:
                        chCheckIn.setChecked(true);
                        chCheckProhibitedItems.setChecked(true);
                        chManualCheckProhibitedItems.setChecked(true);
                        chLoadToAirplane.setChecked(true);
                        chInFlight.setChecked(true);
                        chLoadFromPlain.setChecked(true);
                        chСonveyorLoad.setChecked(true);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return root;
    }

    private void writeNewUser(String luggageId) {
        LuggageTrack luggage = new LuggageTrack(0);

        mDatabase.child("luggage").child(luggageId).setValue(luggage);
    }
}
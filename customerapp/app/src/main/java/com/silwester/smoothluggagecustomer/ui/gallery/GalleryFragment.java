package com.silwester.smoothluggagecustomer.ui.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.silwester.smoothluggagecustomer.R;

import static android.support.constraint.Constraints.TAG;

public class GalleryFragment extends Fragment {

    private DatabaseReference mDatabase;
    private Handler handler = new Handler();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference("message");
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        final CheckBox chCheckIn = root.findViewById(R.id.chCheckIn);
        final CheckBox chCheckProhibitedItems = root.findViewById(R.id.chCheckProhibitedItems);
        final CheckBox chManualCheckProhibitedItems = root.findViewById(R.id.chManualCheckProhibitedItems);
        final CheckBox chLoadToAirplane = root.findViewById(R.id.chLoadToAirplane);
        final CheckBox chInFlight = root.findViewById(R.id.chInFlight);
        final CheckBox chLoadFromPlain = root.findViewById(R.id.chLoadFromPlain);
        final CheckBox chСonveyorLoad = root.findViewById(R.id.chСonveyorLoad);

        CheckBox[] all = new CheckBox[]{chCheckIn, chCheckProhibitedItems, chManualCheckProhibitedItems, chLoadToAirplane, chInFlight, chLoadFromPlain, chСonveyorLoad };

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Long.class).intValue();
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
//        final CheckboxRunnable runnable = new CheckboxRunnable(0, all);
//        handler.postDelayed(runnable, 2000);
    }

    class CheckboxRunnable implements Runnable {
        int activeCheckboxes;
        CheckBox[] array;

        public CheckboxRunnable(int activeCheckboxes, CheckBox[] array) {
            this.activeCheckboxes = activeCheckboxes;
            this.array = array;
        }

        public void setActiveCheckboxes(int activeCheckboxes) {
            this.activeCheckboxes = activeCheckboxes;
        }

        @Override
        public void run() {
            for (int i = 0; i < activeCheckboxes; i++) {
                array[i].setChecked(true);
            }

            if (activeCheckboxes < array.length) {
                activeCheckboxes += 1;
                handler.postDelayed(this, 3000L);
            }
        }
    }

    private void writeNewUser(String luggageId) {
        LuggageTrack luggage = new LuggageTrack(0);

        mDatabase.child("luggage").child(luggageId).setValue(luggage);
    }
}
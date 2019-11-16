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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.silwester.smoothluggagecustomer.R;

import static android.support.constraint.Constraints.TAG;

public class TrackFragment extends Fragment {

    private DatabaseReference mDatabase;
    private Handler handler = new Handler();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_track, container, false);

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

        final TextView chCheckInDesc = root.findViewById(R.id.chCheckInDesc);
        final TextView chCheckProhibitedItemsDesc = root.findViewById(R.id.chCheckProhibitedItemsDesc);
        final TextView chManualCheckProhibitedItemsDesc = root.findViewById(R.id.chManualCheckProhibitedItemsDesc);
        final TextView chLoadToAirplaneDesc = root.findViewById(R.id.chLoadToAirplaneDesc);
        final TextView chInFlightDesc = root.findViewById(R.id.chInFlightDesc);
        final TextView chLoadFromPlainDesc = root.findViewById(R.id.chLoadFromPlainDesc);
        final TextView chСonveyorLoadDesc = root.findViewById(R.id.chСonveyorLoadDesc);


        final CheckBox[] all = new CheckBox[]{chCheckIn, chCheckProhibitedItems, chManualCheckProhibitedItems, chLoadToAirplane, chInFlight, chLoadFromPlain, chСonveyorLoad };
        final TextView[] allDesc = new TextView[]{chCheckInDesc, chCheckProhibitedItemsDesc, chManualCheckProhibitedItemsDesc, chLoadToAirplaneDesc, chInFlightDesc, chLoadFromPlainDesc, chСonveyorLoadDesc };
        final String[] stamps = new String[] {
            "15.11.2019 11:00",
            "15.11.2019 12:30",
            "15.11.2019 12:40",
            "15.11.2019 13:40",
            "15.11.2019 14:30",
            "15.11.2019 15:30",
            "15.11.2019 16:00"
        };
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Long.class).intValue();
                Log.d(TAG, "Value is: " + value);

                final CheckboxRunnable runnable = new CheckboxRunnable(value, all, allDesc, stamps);
                handler.post(runnable);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//        final CheckboxRunnable runnable = new CheckboxRunnable(0, all, allDesc, stamps);
//        handler.postDelayed(runnable, 2000);
    }

    class CheckboxRunnable implements Runnable {
        int activeCheckboxes;
        CheckBox[] array;
        TextView[] allDesc;
        String[] stamps;

        public CheckboxRunnable(int activeCheckboxes, CheckBox[] array, TextView[] allDesc, String[] stamps) {
            this.activeCheckboxes = activeCheckboxes;
            this.array = array;
            this.allDesc = allDesc;
            this.stamps = stamps;
        }

        public void setActiveCheckboxes(int activeCheckboxes) {
            this.activeCheckboxes = activeCheckboxes;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                boolean isActive = i < activeCheckboxes;
                array[i].setChecked(isActive);
                String startText = isActive ? "  Confirmed on " : "  ETA on ";
                allDesc[i].setText(startText + stamps[i]);
                allDesc[i].setVisibility(View.VISIBLE);
            }

//            if (activeCheckboxes < array.length) {
//                activeCheckboxes += 1;
//                handler.postDelayed(this, 3000L);
//            }
        }
    }

    private void writeNewUser(String luggageId) {
        LuggageTrack luggage = new LuggageTrack(0);

        mDatabase.child("luggage").child(luggageId).setValue(luggage);
    }
}
package com.manager.direct.blockchalleng;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class Main3Activity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    private BarcodeReader barcodeReader;
    FirebaseDatabase database;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);
        AlertDialog alertDialog = new AlertDialog.Builder(Main3Activity.this).create();
        alertDialog.setTitle("Luggage");
        alertDialog.setMessage("What is the condition of luggage?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Not OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance().getReference("message");

    }


    @Override
    public void onScanned(Barcode barcode) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));
               ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.drawable.ok);
        // play beep sound
        barcodeReader.playBeep();
        barcodeReader.playBeep();
        barcodeReader.playBeep();
        barcodeReader.playBeep();
        barcodeReader.playBeep();
        barcodeReader.playBeep();
        EtheriumRunner myTask = new EtheriumRunner();
        myTask.execute();
        int add = new Integer(mDatabase.getKey());
        int i = 1+add;// + (new Integer(mDatabase.getKey()) % 7);
        mDatabase.setValue(i);
//
//        int i = 1 + (new Integer(myRef.getKey()) % 7);
//        myRef.setValue(i);
        Intent intent2 = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent2);
    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String s) {

    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getApplicationContext(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}

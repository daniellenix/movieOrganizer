package com.example.movieorganizer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;

import com.example.movieorganizer.R;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class Activity2 extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    private BarcodeReader barcodeReader;

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, Activity2.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
    }

    @Override
    public void onScanned(final Barcode barcode) {
//        barcodeReader.playBeep();

        final String msg = "You clicked " + barcode.rawValue;

        Activity2.this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(Activity2.this, msg, Toast.LENGTH_LONG).show();
            }
        });



        Intent intent = Activity3.makeIntent(Activity2.this, barcode.displayValue);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
    }

    @Override
    public void onScanError(String errorMessage) {
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(Activity2.this, "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}
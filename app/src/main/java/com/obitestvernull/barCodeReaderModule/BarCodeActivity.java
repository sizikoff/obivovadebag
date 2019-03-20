package com.obitestvernull.barCodeReaderModule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;
import com.google.android.gms.vision.barcode.Barcode;
import com.example.geolocationcheckautomaticly.R;

import java.util.List;

import info.devcodenet.devbarcode.BarcodeReader;


public class BarCodeActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener,ContractBar.View {
    private static final String TAG = BarCodeActivity.class.getSimpleName();

    private BarcodeReader barcodeReader;
    private ContractBar.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        // инстанс баркода
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);
         barcodeReader.setBeepSoundFile("shutter.mp3");
         barcodeReader.pauseScanning();
         barcodeReader.resumeScanning();
        presenter = new PresenterBar(this, this);

    }

    @Override
    public void onScanned(final Barcode barcode) {
      showCode(barcode);
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }
        final String finalCodes = codes;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "" + finalCodes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getApplicationContext(), "Разрешение не дано", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void showCode( final Barcode barcode) {
        Log.e(TAG, "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();
        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "номер товара: " + barcode.displayValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
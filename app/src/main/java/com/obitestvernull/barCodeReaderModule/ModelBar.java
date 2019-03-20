package com.obitestvernull.barCodeReaderModule;


import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

public class ModelBar implements ContractBar.Model {

    @Override
    public void onFinishedCoordinates(List<Barcode> barcodes) {
        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }
    }
}
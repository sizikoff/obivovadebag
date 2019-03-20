package com.obitestvernull.barCodeReaderModule;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

public class PresenterBar implements ContractBar.Presenter {

    private static final String TAG = "pres";
    private ContractBar.View mainView;
    Context context;

    public PresenterBar(ContractBar.View mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void Barcode(List<Barcode> barcodes) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size());


    }
}

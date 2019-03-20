package com.obitestvernull.barCodeReaderModule;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

public interface ContractBar {

    interface Presenter {

        void onDestroy();

        void Barcode(List<Barcode> barcodes);
    }

    interface View {
        void showCode(Barcode barcode);
    }

    interface Model {
            void onFinishedCoordinates(List<Barcode> barcodes);;
    }
}
package com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth;


import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne.FindingProducts;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne.Product;

import java.util.ArrayList;

public interface Contract {

    interface Presenter{
        void onFinished(FindingProducts findingProducts);
        void onDestroy();
        void requestDataFromServer(String findingProduct);
    }

    interface MainView {
        void nothingToShow();
        void setDataToRecycler(ArrayList<Product> products);
        void onResponseFailure(Throwable throwable);
    }

    interface GetDataFromModel {
        interface OnFinishedListener {
            void onFinished(FindingProducts findingProducts);
            void onFailure(Throwable t);
        }

        void getArrayList(OnFinishedListener onFinishedListener, String findingProduct);
    }
}

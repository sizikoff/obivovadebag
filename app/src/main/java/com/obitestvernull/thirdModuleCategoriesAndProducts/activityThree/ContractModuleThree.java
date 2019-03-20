package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree;

import android.widget.ImageView;
import android.widget.TextView;

import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.CategoriesOfStore;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.Category;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ItemOfProducts;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ProductsOfStore;

import java.util.ArrayList;

public interface ContractModuleThree {

    interface Presenter{
        void onItemRecyclerViewClicked(int pos, Category category, TextView textView, ImageView imageView);
        void onDestroy();
        void requestDataFromServer(String nameStore, int obiStoreId);
    }

    interface MainView {
        void setRecyclerWithProducts(ArrayList<ItemOfProducts> p);
        void setRecyclerView(ArrayList<Category> s);
        void onResponseFailure(Throwable throwable);
    }

    interface ModelModuleThree {

        void getArrayList(OnFinishedListener onFinishedListener, String nameStore, int obiStoreId);
        interface OnFinishedListener {
            void onFinished(CategoriesOfStore categoriesOfStore);
            void onFailure(Throwable t);
        }

        void getArrayWithProducts(OnFinishedListenerArrProd onFinishedListenerArrProd, Category category, int obiStoreId);
        interface OnFinishedListenerArrProd {
            void onFinishedArrProd(ProductsOfStore productsOfStore);
            void onFailureArrProd(Throwable t);
        }
    }
}

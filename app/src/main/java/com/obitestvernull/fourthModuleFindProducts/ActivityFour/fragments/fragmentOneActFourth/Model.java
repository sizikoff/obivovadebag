package com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth;

import android.util.Log;

import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne.FindingProducts;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.CategoriesOfStore;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ProductsOfStore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.GetDataFromModel {

    private static final String TAG = "ModelFragOneActFour";

    @Override
    public void getArrayList(final OnFinishedListener onFinishedListener, final String findindProduct) {
        Log.i(TAG, "findindProduct: " + findindProduct);
//        Log.i(TAG, "category.getId(): " + category.getId());

        String ask2 = "query ($query: String!, $storeId: Int, $type: SearchTypeEnum) {search(query: $query, storeId: $storeId, type: $type) {products {obi_id store_id barcode price name description manufacturer quantity images existing_in_stores { store_id quantity } } } }";
        String ask3 = "{ \"query\":" + "\"" + findindProduct +"\"" + "," + "\"storeId\":" + 3 + ",\"type\": \"fulltext\"}";

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<FindingProducts> call = service.getFindingProducts(ask2, ask3);
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<FindingProducts>() {
            @Override
            public void onResponse(Call<FindingProducts> call, Response<FindingProducts> response) {
                FindingProducts findingProducts = response.body();
                onFinishedListener.onFinished(findingProducts);
                Log.i(TAG, "все норм");

            }

            @Override
            public void onFailure(Call<FindingProducts> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }
}

package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree;

import android.util.Log;

import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.CategoriesOfStore;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.Category;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ProductsOfStore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModelModuleThree implements ContractModuleThree.ModelModuleThree {

    private static final String TAG = "ModelModuleThree";

    @Override
    public void getArrayList(final OnFinishedListener onFinishedListener, final String nameStore, int obiStoreId) {

        String ask = "query { categories(obiStoreId:" + obiStoreId + ") { id name image root_id parent_id is_parent} }";

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<CategoriesOfStore> call = service.getCategoriesOfStore(ask);
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<CategoriesOfStore>() {
            @Override
            public void onResponse(Call<CategoriesOfStore> call, Response<CategoriesOfStore> response) {
                CategoriesOfStore categoriesOfStore = response.body();
                onFinishedListener.onFinished(categoriesOfStore);

                Log.i(TAG, "описание категории: " + categoriesOfStore.getDataThirdModule().getCategories().get(0).getName());
            }
            @Override
            public void onFailure(Call<CategoriesOfStore> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }

    @Override
    public void getArrayWithProducts(final OnFinishedListenerArrProd onFinishedListenerArrProd, Category category, int obiStoreId) {

        Log.i(TAG, "obiStoreId: " + obiStoreId);
        Log.i(TAG, "category.getId(): " + category.getId());

        String ask2 = "query ($storeId: Int, $obiStoreId: Int, $categoryId: Int, $offset: Int, $length: Int) { products(storeId: $storeId, obiStoreId: $obiStoreId, categoryId: $categoryId, offset: $offset, length: $length) { items { id store_id category_id name manufacturer description quantity image price link } } }";
        String ask3 = "{ \"obiStoreId\":" + obiStoreId + "," + "\"categoryId\":" + category.getId() + "}";

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<ProductsOfStore> call = service.getArrayOfProducts(ask2, ask3);
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<ProductsOfStore>() {
            @Override
            public void onResponse(Call<ProductsOfStore> call, Response<ProductsOfStore> response) {
                ProductsOfStore productsOfStore = response.body();
                onFinishedListenerArrProd.onFinishedArrProd(productsOfStore);

                Log.i(TAG, "название товара: " + productsOfStore.getData().getProducts().getItems().get(0).getName());
            }

            @Override
            public void onFailure(Call<ProductsOfStore> call, Throwable t) {
                onFinishedListenerArrProd.onFailureArrProd(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }
}

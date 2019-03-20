package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.CategoriesOfStore;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.Category;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ItemOfProducts;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ProductsOfStore;
import java.util.ArrayList;

public class PresenterModuleThree implements ContractModuleThree.Presenter, ContractModuleThree.ModelModuleThree.OnFinishedListener,
             ContractModuleThree.ModelModuleThree.OnFinishedListenerArrProd{

    private static final String TAG = "PresenterModuleThree";
    private ContractModuleThree.MainView mainView;
    private ContractModuleThree.ModelModuleThree modelModuleThree;
    Context context;

    CategoriesOfStore categoriesOfStore;
    ArrayList<Category> categoriesAndUnderCategories = new ArrayList<>();

    ArrayList<Category> parentsNullList;

    String storeName;
    int obiStoreId;

    public PresenterModuleThree(ContractModuleThree.MainView mainView, ContractModuleThree.ModelModuleThree modelModuleThree, Context context) {
        this.mainView = mainView;
        this.modelModuleThree = modelModuleThree;
        this.context = context;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    //запрашиваем у модели список категорий передавая ей в динамический запрос наш крутой название магаза и его айдишник
    @Override
    public void requestDataFromServer(String storeName, int obiStoreId) {
        this.storeName = storeName;
        this.obiStoreId = obiStoreId;

        modelModuleThree.getArrayList(this, storeName, obiStoreId);
    }

    //получаем список категорий и подкатегорий и показываем корневые элементы в активити
    @Override
    public void onFinished(CategoriesOfStore categoriesOfStore) {
        this.categoriesOfStore = categoriesOfStore;
        categoriesAndUnderCategories = categoriesOfStore.getDataThirdModule().getCategories();

        getTheParentListAndSetItToActivity();
        Log.i(TAG, "categoriesOfStoreSize: " + categoriesOfStore.getDataThirdModule().getCategories().size());
    }

    //как только происходит клик на ресайклер, формируем списочек детей и отправляем его на показ в активити
    @Override
    public void onItemRecyclerViewClicked(int pos, Category category, TextView textView, ImageView imageView) {
        int idOfProduct = category.getId();

        ArrayList<Category> myNextElementProducts = new ArrayList<>();
        for (int i = 0; i<categoriesAndUnderCategories.size(); i++) {
            if (categoriesAndUnderCategories.get(i).getParentId() == idOfProduct) {
                myNextElementProducts.add(categoriesAndUnderCategories.get(i));
            }
        }
        mainView.setRecyclerView(myNextElementProducts);
        Log.i(TAG, "myNextElementProducts: " + myNextElementProducts.size());

        //если подкатегорий больше нет, отлетает запрос на сервак, список товаров давай вася
        if (myNextElementProducts.size() == 0) {
            Log.i(TAG, "obiStoreId: " + obiStoreId);
            modelModuleThree.getArrayWithProducts(this, category, obiStoreId);
        }
    }

    //тут получаем данные уже с перечнем товаров
    @Override
    public void onFinishedArrProd(ProductsOfStore productsOfStore) {

        ArrayList<ItemOfProducts> products = (ArrayList<ItemOfProducts>) productsOfStore.getData().getProducts().getItems();
        Log.i(TAG, "products.size(): " + products.size() + " название товара: " + productsOfStore.getData().getProducts().getItems().get(0).getName());

        mainView.setRecyclerWithProducts(products);
    }

    //метод на случай каких либо ошибок
    @Override
    public void onFailureArrProd(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }

    //метод на случай каких либо ошибок
    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }

    //служебный метод во избежание задваивания кода
    private void getTheParentListAndSetItToActivity() {
        parentsNullList = new ArrayList<>();
        for (int i = 0; i<categoriesAndUnderCategories.size(); i++) {
            if (categoriesAndUnderCategories.get(i).getParentId() == 0) {
                parentsNullList.add(categoriesAndUnderCategories.get(i));
            }
        }
        mainView.setRecyclerView(parentsNullList);
    }
}

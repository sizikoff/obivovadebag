package com.obitestvernull.secondModuleCitiesAndStores.activityTwo;

import android.content.Context;
import android.util.Log;

import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.commonClassesAndUtils.POJO.City;
import com.obitestvernull.commonClassesAndUtils.POJO.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PresenterModuleTwo implements ContractModuleTwo.Presenter, ContractModuleTwo.GetNoticeIntractor.OnFinishedListener {

    private static final String TAG = "PresenterModuleTwo";
    private ContractModuleTwo.MainView mainView;
    private ContractModuleTwo.GetNoticeIntractor getNoticeIntractor;
    Context context;
    CitiesWithStores citiesWithStores;

    public PresenterModuleTwo(ContractModuleTwo.MainView mainView, ContractModuleTwo.GetNoticeIntractor getNoticeIntractor, Context context) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
        this.context = context;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestDataFromServer() {
       getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(CitiesWithStores citiesWithStores) {
        Log.i(TAG, "onFinished(citiesWithStores.getData().getCities().get(0).getName()): " +citiesWithStores.getData().getCities().get(0).getName());

        this.citiesWithStores = citiesWithStores;

        ArrayList<City> cities = (ArrayList<City>) citiesWithStores.getData().getCities();
        ArrayList<String> myCities = new ArrayList<>();

        for (int i = 0; i < cities.size(); i++) {
            myCities.add(cities.get(i).getName());
        }

        HashMap<String, List<Store>> hashMap = new HashMap<String, List<Store>>();

        for (int i = 0; i < cities.size(); i++) {
            hashMap.put(cities.get(i).getName(), cities.get(i).getStores());
        }

        mainView.setItemsToListView(myCities, hashMap);
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }
}

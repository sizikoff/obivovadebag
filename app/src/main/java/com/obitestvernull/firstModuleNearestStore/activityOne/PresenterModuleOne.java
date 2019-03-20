package com.obitestvernull.firstModuleNearestStore.activityOne;

import android.content.Context;
import android.util.Log;

import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.commonClassesAndUtils.POJO.City;
import com.obitestvernull.commonClassesAndUtils.POJO.Store;
import com.obitestvernull.firstModuleNearestStore.utils.HaversineAlgorithm;
import com.obitestvernull.commonClassesAndUtils.POJO.NearestStore;

import java.util.ArrayList;
import java.util.Collections;

public class PresenterModuleOne implements ContractModuleOne.Presenter, ContractModuleOne.GetNoticeIntractor.OnFinishedListener {

    private static final String TAG = "PresenterModuleOne";
    private ContractModuleOne.MainView mainView;
    private ContractModuleOne.GetNoticeIntractor getNoticeIntractor;
    Context context;
    CitiesWithStores citiesWithStores;
    ArrayList<Store> stores = new ArrayList<>();

    public PresenterModuleOne(ContractModuleOne.MainView mainView, ContractModuleOne.GetNoticeIntractor getNoticeIntractor, Context context) {
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
        mainView.showProgressBar();
        mainView.setTextToTextView("ищем ищем магазинчик...");
        getNoticeIntractor.getNoticeArrayList(this);
    }

    //получаем список координат всех магазинов во всех городах (28 штук где то их)
    @Override
    public void onFinished(CitiesWithStores citiesWithStores) {

        this.citiesWithStores = citiesWithStores;

        ArrayList<City> cities = (ArrayList<City>) citiesWithStores.getData().getCities();
        ArrayList<Store> myStores;

        if (stores.size()>0)
            stores.clear();

        for (int i = 0; i<cities.size(); i++) {
            myStores = (ArrayList<Store>) cities.get(i).getStores();
            stores.addAll(myStores);
        }
        Log.i(TAG, "stores.size(): " + stores.size());
    }

    //получаем наши координаты
    @Override
    public void onFinishedCoordinates(String k) {
        Log.i(TAG, "onFinishedCoordinates(String k): " + k);

        double myLat = Double.parseDouble(k.substring(0, k.indexOf(" ")));
        double myLong = Double.parseDouble(k.substring(k.indexOf(" ")));
        Log.i(TAG, "myLat: " + myLat + "; " + "myLong: " + myLong);

        String name = getStoreWithMinimumDistance(myLat, myLong).getName();
        String distance = String.format("%.2f", getStoreWithMinimumDistance(myLat, myLong).getDistance());

        if (mainView != null) {
            mainView.setTextToTextView("Ближайший магаз: " + name + "; расстояние: " + distance + "км");
            mainView.hideProgressBar();
        }
    }

    //функция которая сравнивает все дистанции, находит минимальную и возвращает название магаза с минимальной дистанцией
    private NearestStore getStoreWithMinimumDistance(double myLatitude, double myLongtitude) {
        ArrayList<Double> distances = new ArrayList<>();
        Double d = Double.valueOf(0);
        String nameOfNearestStore = "";
        if (stores != null) {
            for (int i = 0; i < stores.size(); i++) {
                double storeLat = stores.get(i).getLat();
                double storeLon = stores.get(i).getLng();
                double distance = HaversineAlgorithm.HaversineInKM(myLatitude, myLongtitude, storeLat, storeLon);
                distances.add(distance);
                Log.i(TAG, "distance: " + distance);
                d = Collections.min(distances);
                Log.i(TAG, "Double d: " + d);
                if (distance == d) {
                    nameOfNearestStore = stores.get(i).getName();
                }
            }
            Log.i(TAG, "nameOfNearestStore: " + nameOfNearestStore);
        }
        NearestStore nearestStore = new NearestStore();
        nearestStore.setName(nameOfNearestStore);
        nearestStore.setDistance(d);
        return nearestStore;
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }

    @Override
    public void getCoordinates() {
        ModelCoordinats modelCoordinats = new ModelCoordinats(context);
        modelCoordinats.getLocation(this);
    }
}

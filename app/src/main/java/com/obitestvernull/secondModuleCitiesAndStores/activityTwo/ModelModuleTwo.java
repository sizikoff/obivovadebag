package com.obitestvernull.secondModuleCitiesAndStores.activityTwo;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.commonClassesAndUtils.database.DatabaseAsking;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModelModuleTwo implements ContractModuleTwo.GetNoticeIntractor {

    private static final String TAG = "ModelModuleTwo";
    CitiesWithStores  citiesWithStores;

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<CitiesWithStores> call = service.getCitiesWithStores();
        Log.i("URL Called", call.request().url() + "");

        call.enqueue(new Callback<CitiesWithStores>() {
            @Override
            public void onResponse(Call<CitiesWithStores> call, Response<CitiesWithStores> response) {
                citiesWithStores =  response.body();

                String gson = new Gson().toJson(citiesWithStores);
                DatabaseAsking.insertSomeThing("citiesWithStores", gson);

                onFinishedListener.onFinished(citiesWithStores);
                Log.i(TAG, "описание магазина: ");
            }
            @Override
            public void onFailure(Call<CitiesWithStores> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.i(TAG, "ошибка: " + t.toString());

                if (DatabaseAsking.getSomeThing("citiesWithStores").length()>1) {
                    citiesWithStores = new Gson().fromJson(DatabaseAsking.getSomeThing("citiesWithStores"), new TypeToken<CitiesWithStores>() {}.getType());
                    onFinishedListener.onFinished(citiesWithStores);
                }

            }
        });
    }
}

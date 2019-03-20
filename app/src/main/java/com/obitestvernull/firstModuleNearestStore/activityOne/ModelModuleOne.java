package com.obitestvernull.firstModuleNearestStore.activityOne;

import android.util.Log;

import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModelModuleOne implements ContractModuleOne.GetNoticeIntractor {

    private static final String TAG = "ModelModuleOne";

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<CitiesWithStores> call = service.getCitiesWithStores();
        Log.i("URL Called", call.request().url() + "");

        call.enqueue(new Callback<CitiesWithStores>() {
            @Override
            public void onResponse(Call<CitiesWithStores> call, Response<CitiesWithStores> response) {
                CitiesWithStores  citiesWithStores = response.body();

                onFinishedListener.onFinished(citiesWithStores);
                Log.i(TAG, "описание магазина: ");
            }
            @Override
            public void onFailure(Call<CitiesWithStores> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }


}

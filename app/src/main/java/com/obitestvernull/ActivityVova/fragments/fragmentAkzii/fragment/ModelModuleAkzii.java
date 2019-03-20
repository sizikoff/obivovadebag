package com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment;

import android.util.Log;

import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelModuleAkzii implements ContractModuleAkzii.ModelModuleAkzii {

        private static final String TAG = "AkziiActivity";

    @Override
    public void modelRetrofit(final OnFinishedListenerAkzii onFinishedListenerAkzii) {
        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<List<ItemAkzii>> call = service.getAkziii();
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<List<ItemAkzii>>() {
            @Override
            public void onResponse(Call<List<ItemAkzii>> call, Response<List<ItemAkzii>> response) {
                ArrayList<ItemAkzii> itemAkziis = (ArrayList<ItemAkzii>) response.body();
                onFinishedListenerAkzii.onFinished(itemAkziis);
                Log.i(TAG, itemAkziis.get(2).getName());
            }
            @Override
            public void onFailure(Call<List<ItemAkzii>> call, Throwable t) {
                Log.i(TAG, "ошибка: " + t.toString());
                onFinishedListenerAkzii.onFailure(t);
            }
        });
    }
}

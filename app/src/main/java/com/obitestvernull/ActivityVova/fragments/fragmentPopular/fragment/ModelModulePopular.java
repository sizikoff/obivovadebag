package com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment;

import android.util.Log;

import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelModulePopular implements ContractModulePopular.ModelModulePopular {

        private static final String TAG = "PopularActivity";

    @Override
    public void modelRetrofit(final OnFinishedListenerPopular onFinishedListenerAkzii) {
        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<List<Popular>> call = service.getPopular();
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<List<Popular>>() {
            @Override
            public void onResponse(Call<List<Popular>> call, Response<List<Popular>> response) {
                ArrayList<Popular> itemPopular = (ArrayList<Popular>) response.body();
                onFinishedListenerAkzii.onFinished(itemPopular);
                Log.i(TAG, itemPopular.get(0).getName());
            }
            @Override
            public void onFailure(Call<List<Popular>> call, Throwable t) {
                Log.i(TAG, "ошибка: " + t.toString());
                onFinishedListenerAkzii.onFailure(t);
            }
        });
    }
}

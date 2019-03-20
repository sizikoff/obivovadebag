package com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment;

import android.util.Log;

import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;

import java.util.ArrayList;

public class PresenterModulePopular implements ContractModulePopular.Presenter, ContractModulePopular.ModelModulePopular.OnFinishedListenerPopular {

    private ContractModulePopular.MainView mainView;
    private ContractModulePopular.ModelModulePopular modelModuleAkzii;
    private static final String TAG = "PopularImage";

    public PresenterModulePopular(ContractModulePopular.MainView mainView, ContractModulePopular.ModelModulePopular modelModuleAkzii) {
        this.mainView = mainView;
        this.modelModuleAkzii = modelModuleAkzii;
    }
    @Override
    public void akziiPres() {
        modelModuleAkzii.modelRetrofit(this);
    }

    @Override
    public void onFinished(ArrayList<Popular> itemAkziis) {
        mainView.setRecyclerPopular(itemAkziis);
        Log.i(TAG,"ЗАШЕЛ В ВЬЮУ И РЕСАЙКЛ");
    }

    @Override
    public void onFailure(Throwable t) {

    }
}

package com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment;

import android.util.Log;

import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;

import java.util.ArrayList;

public class PresenterModuleAkzii implements ContractModuleAkzii.Presenter, ContractModuleAkzii.ModelModuleAkzii.OnFinishedListenerAkzii {

    private ContractModuleAkzii.MainView mainView;
    private ContractModuleAkzii.ModelModuleAkzii modelModuleAkzii;
    private static final String TAG = "AKZIIPres";

    public PresenterModuleAkzii(ContractModuleAkzii.MainView mainView, ContractModuleAkzii.ModelModuleAkzii modelModuleAkzii) {
        this.mainView = mainView;
        this.modelModuleAkzii = modelModuleAkzii;
    }
    @Override
    public void akziiPres() {
        modelModuleAkzii.modelRetrofit(this);
    }

    @Override
    public void onFinished(ArrayList<ItemAkzii> itemAkziis) {
        //TODO:Сюда вставить метод получения картинок
        mainView.setRecyclerWithAkzii(itemAkziis);
        Log.i(TAG, itemAkziis.get(2).getImage());
    }

    @Override
    public void onFailure(Throwable t) {

    }
}

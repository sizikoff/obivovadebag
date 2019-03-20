package com.obitestvernull.secondModuleCitiesAndStores.activityTwo;

import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.commonClassesAndUtils.POJO.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ContractModuleTwo {

    interface Presenter{
        void onFinished(CitiesWithStores citiesWithStores);
        void onDestroy();
        void requestDataFromServer();
    }

    interface MainView {
        void setItemsToListView(ArrayList<String> myCities, HashMap<String, List<Store>> myChildren);
        void onResponseFailure(Throwable throwable);
    }

    interface GetNoticeIntractor {
        interface OnFinishedListener {
            void onFinished(CitiesWithStores citiesWithStores);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}

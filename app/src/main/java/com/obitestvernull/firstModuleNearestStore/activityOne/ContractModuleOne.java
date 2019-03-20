package com.obitestvernull.firstModuleNearestStore.activityOne;


import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;

public interface ContractModuleOne {

    interface Presenter{

        void onDestroy();
        void requestDataFromServer();
        void getCoordinates();
    }

    interface MainView {

        void showProgressBar();
        void hideProgressBar();
        void setTextToTextView(String s);
        void onResponseFailure(Throwable throwable);
    }

    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(CitiesWithStores citiesWithStores);
            void onFinishedCoordinates(String k);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}

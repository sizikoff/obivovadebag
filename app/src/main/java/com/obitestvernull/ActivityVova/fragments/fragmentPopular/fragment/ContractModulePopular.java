package com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment;


import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;

import java.util.ArrayList;

public interface ContractModulePopular {
    interface Presenter{
        void akziiPres();
    }
    interface MainView {
        void Viewshka();
        void setRecyclerPopular(ArrayList<Popular> itemAkziis);
    }
    interface ModelModulePopular {
        void modelRetrofit(OnFinishedListenerPopular onFinishedListenerPopular);
        interface OnFinishedListenerPopular {
            void onFinished(ArrayList<Popular> itemAkziis);
            void onFailure(Throwable t);
        }
    }
}
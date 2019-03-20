package com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment;


import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;

import java.util.ArrayList;

public interface ContractModuleAkzii {
    interface Presenter{
        void akziiPres();
    }
    interface MainView {
        void Viewshka();
        void setRecyclerWithAkzii(ArrayList<ItemAkzii> itemAkziis);
    }
    interface ModelModuleAkzii {
        void modelRetrofit(OnFinishedListenerAkzii onFinishedListenerAkzii);
        interface OnFinishedListenerAkzii {
            void onFinished(ArrayList<ItemAkzii> itemAkziis);
            void onFailure(Throwable t);
        }
    }
}
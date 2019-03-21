package com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentPopular.adapter.RecyclerViewPopularAdapter;
import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;

import java.util.ArrayList;


public class FragmentPopular extends Fragment implements ContractModulePopular.MainView {

    private static final String TAG = "POPULAR";
    private ContractModulePopular.Presenter presenter;
    RecyclerView recyclerViewPop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_content, container, false);
        recyclerViewPop = view.findViewById(R.id.recyclerviewPop);
        presenter = new PresenterModulePopular(this, new ModelModulePopular());
        recyclerViewPop.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        presenter.akziiPres();
        return view;
    }

    @Override
    public void Viewshka() {
        presenter.akziiPres();
    }

    @Override
    public void setRecyclerPopular(ArrayList<Popular> itemAkziis) {
        RecyclerViewPopularAdapter adapter1 = new RecyclerViewPopularAdapter(getContext(), itemAkziis);
        recyclerViewPop.setAdapter(adapter1);
    }
}

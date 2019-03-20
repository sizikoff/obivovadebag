package com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.adapter.RecyclerViewAdapter;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;

import java.util.ArrayList;


public class FragmentAkzii extends Fragment implements ContractModuleAkzii.MainView {

    private static final String TAG = "AKZII";
    private ContractModuleAkzii.Presenter presenter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        presenter = new PresenterModuleAkzii(this, new ModelModuleAkzii());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        presenter.akziiPres();
        return view;
    }

    @Override
    public void Viewshka() {
        presenter.akziiPres();
    }

    @Override
    public void setRecyclerWithAkzii(ArrayList<ItemAkzii> itemAkziis) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), itemAkziis);
        recyclerView.setAdapter(adapter);
    }
}

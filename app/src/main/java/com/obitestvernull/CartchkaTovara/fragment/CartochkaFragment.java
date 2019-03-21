package com.obitestvernull.CartchkaTovara.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;
import com.obitestvernull.CartchkaTovara.fragment.POJO.ItemOfCard;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartochkaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cartochka, container, false);
        return view;
    }
}

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

    ImageView imageView;
    TextView priceCard;
    TextView id_cartochka;
    TextView nameCard;
    TextView kolichestvo;
    TextView infoCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cartochka, container, false);
        imageView = view.findViewById(R.id.kartinkatovara);
        priceCard = view.findViewById(R.id.priceCard);
        id_cartochka = view.findViewById(R.id.id_cartochka);
        nameCard = view.findViewById(R.id.nameProd);
        kolichestvo = view.findViewById(R.id.kolichestvo);
        infoCard = view.findViewById(R.id.infoCard);

        return view;
    }
}

package com.obitestvernull.CartchkaTovara.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geolocationcheckautomaticly.R;

public class CartochkaFragment extends Fragment {

    ImageView imageView;
    TextView priceCard;
    TextView nameCard;
    TextView kolichestvo;
    TextView infoCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cartochka, container, false);
        imageView = view.findViewById(R.id.kartinkatovara);
        priceCard = view.findViewById(R.id.priceCard);
        nameCard = view.findViewById(R.id.nameProd);
        kolichestvo = view.findViewById(R.id.kolichestvo);
        infoCard = view.findViewById(R.id.infoCard);

        return view;
    }

}

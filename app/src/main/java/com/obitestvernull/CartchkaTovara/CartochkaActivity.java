package com.obitestvernull.CartchkaTovara;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;
import com.obitestvernull.CartchkaTovara.fragment.POJO.ItemOfCard;
import com.obitestvernull.commonClassesAndUtils.ServerAddress;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obitestvernull.commonClassesAndUtils.retrofit.RetrofitNetwork;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartochkaActivity extends AppCompatActivity {

    private static final String TAG = "cartochka";
    ImageView imageView;
    TextView priceCard;
    TextView id_cartochka;
    TextView nameCard;
    TextView kolichestvo;
    TextView infoCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartochka);
        imageView = findViewById(R.id.kartinkatovara);
        priceCard = findViewById(R.id.priceCard);
        id_cartochka = findViewById(R.id.id_cartochka);
        nameCard = findViewById(R.id.nameProd);
        kolichestvo = findViewById(R.id.kolichestvo);
        infoCard = findViewById(R.id.infoCard);

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<List<ItemOfCard>> call = service.getCartochka();

        call.enqueue(new Callback<List<ItemOfCard>>() {
            @Override
            public void onResponse(Call<List<ItemOfCard>> call, Response<List<ItemOfCard>> response) {
                ArrayList<ItemOfCard> itemPopular = (ArrayList<ItemOfCard>) response.body();
                //парсинг картинки
                String src = "https" +  (itemPopular.get(0).getImage().substring(4));
                Log.i(TAG,src);
                Picasso.with(getBaseContext()).load(src).resize(600, 600).into(imageView);
                //парс остального
                priceCard.setText(itemPopular.get(0).getPrice());
                id_cartochka.setText("№"+itemPopular.get(0).getObiId());
                nameCard.setText(itemPopular.get(0).getName());
                kolichestvo.setText("В наличии: " + itemPopular.get(0).getQuantity());
                infoCard.setText(itemPopular.get(0).getDescription());
            }

            @Override
            public void onFailure(Call<List<ItemOfCard>> call, Throwable t) {
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }
}

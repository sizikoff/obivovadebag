package com.obitestvernull.CartchkaTovara;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.FragmentAkzii;
import com.obitestvernull.CartchkaTovara.fragment.CartochkaFragment;

public class CartochkaActivity extends AppCompatActivity {

    CartochkaFragment cartochkaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartochka);
        cartochkaFragment = new CartochkaFragment();
        loadFragment(cartochkaFragment);
    }
    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.cartochkapro, fragment).commit();
    }
}

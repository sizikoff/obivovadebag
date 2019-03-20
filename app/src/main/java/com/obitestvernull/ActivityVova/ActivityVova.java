package com.obitestvernull.ActivityVova;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.FragmentAkzii;


public class ActivityVova extends AppCompatActivity {

    FragmentAkzii fragmentAkzii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vova);

        fragmentAkzii = new FragmentAkzii();
        loadFragment(fragmentAkzii);

    }
    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.akziiFragment, fragment).commit();
    }
}

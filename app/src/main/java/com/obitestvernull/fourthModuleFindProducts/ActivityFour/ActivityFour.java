package com.obitestvernull.fourthModuleFindProducts.ActivityFour;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.FindFragment;

public class ActivityFour extends AppCompatActivity {

    EditText editText;
    Toolbar toolbar;
    FindFragment findFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    findFragment = new FindFragment();
                    loadFragment(findFragment);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        initToolbar(true);
        setToolbarTitle(getString(R.string.app_name));

        editText = findViewById(R.id.editTextInToolBarInForthMA);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationInFouthAct);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        findFragment = new FindFragment();
        loadFragment(findFragment);
    }

    //кастомный тулбар
    public void initToolbar(boolean isTitleEnabled) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutInFourthAct, fragment).commit();
    }

}

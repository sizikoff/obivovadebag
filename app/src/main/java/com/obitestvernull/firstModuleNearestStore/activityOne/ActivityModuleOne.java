package com.obitestvernull.firstModuleNearestStore.activityOne;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.secondModuleCitiesAndStores.activityTwo.SecondModuleActivity;


public class ActivityModuleOne extends AppCompatActivity implements ContractModuleOne.MainView {

    private static final String TAG = "ActivityModuleOne";
    private ContractModuleOne.Presenter presenter;
    Button buttonGetNearestStore, buttonGetOtherStore;
    Toolbar toolbar;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_one);

        initToolbar(true);
        setToolbarTitle(getString(R.string.app_name));

        presenter = new PresenterModuleOne(this, new ModelModuleOne(), this);
        presenter.requestDataFromServer();
        presenter.getCoordinates();

        askPermissionLocation();
        initButton();
        initButtonGetOtherStore();
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

    public void initButton() {
     buttonGetNearestStore = findViewById(R.id.buttonGetNearestStore);
        buttonGetNearestStore.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             presenter.requestDataFromServer();
             presenter.getCoordinates();

         }
     });
    }

    public void initButtonGetOtherStore() {
        buttonGetOtherStore = findViewById(R.id.buttonGetOtherStore);
        buttonGetOtherStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "идем на списки", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), SecondModuleActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setTextToTextView(String s) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(s);
        Log.i(TAG, s);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(ActivityModuleOne.this, "Something went wrong...Error message: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void askPermissionLocation() {
        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        }
    }

    @Override
    public void showProgressBar() {
        progressBar = findViewById(R.id.progressBarInAMO);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}


package com.obitestvernull.secondModuleCitiesAndStores.activityTwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.commonClassesAndUtils.POJO.Store;
import com.obitestvernull.secondModuleCitiesAndStores.activityTwo.adapters.ExpandableListAdapter;
import com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.ThirdModuleActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondModuleActivity extends AppCompatActivity implements ContractModuleTwo.MainView {

    private static final String TAG = "SecondModuleActivity";
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;
    Toolbar toolbar;

    ArrayList<String> header;

    private ContractModuleTwo.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_module);
        initToolbar(true);
        setToolbarTitle(getString(R.string.app_name));
        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        presenter = new PresenterModuleTwo(this, new ModelModuleTwo(), this);
        presenter.requestDataFromServer();
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

    void setListener() {
        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view, int group_pos, long id) {
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }
                });

        // This listener will show toast on child click
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view, int groupPos, int childPos, long id) {

                Store clickedStore = (Store) listview.getExpandableListAdapter().getChild(groupPos, childPos);
                Log.i(TAG, "clickedStore: " + clickedStore.getName());
                Intent intent = new Intent(getBaseContext(), ThirdModuleActivity.class);
                intent.putExtra("store", clickedStore.getName());
                intent.putExtra("obiStoreId", clickedStore.getObiStoreId().toString());
                startActivity(intent);
                return false;
            }
        });
    }
    @Override
    public void setItemsToListView(ArrayList<String> myCities, HashMap<String, List<Store>> hashMap) {
        // Array list for header
        header = new ArrayList<String>();
        header.addAll(myCities);
        adapter = new ExpandableListAdapter(getBaseContext(), header, hashMap);
        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setListener();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
    }
}

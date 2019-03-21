package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.CartchkaTovara.CartochkaActivity;
import com.obitestvernull.barCodeReaderModule.BarCodeActivity;
import com.obitestvernull.fifthModuleProductCard.ProductActivity;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.ActivityFour;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.Category;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ItemOfProducts;
import com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.adapters.RecyclerAdapter;
import com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.adapters.RecyclerAdapterWithProducts;
import java.util.ArrayList;

public class ThirdModuleActivity extends AppCompatActivity implements ContractModuleThree.MainView, RecyclerAdapter.RecyclerAdapterCallback {


    private static final String TAG = "ThirdModuleActivity";
    private ContractModuleThree.Presenter presenter;
    private RecyclerView recyclerView;
    private Button buttonComeBackInTMA;
    Toolbar toolbar;
    String storeName;
    int obiStoreId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_module);
        initToolbar(true);
        setToolbarTitle(getString(R.string.app_name));
        buttonComeBackInTMA = findViewById(R.id.buttonComeBackInTMA);
        buttonComeBackInTMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter != null)
                    presenter.requestDataFromServer(storeName, obiStoreId);
            }
        });

        recyclerView = findViewById(R.id.recyclerViewModuleThree);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        storeName = intent.getStringExtra("store");
        obiStoreId = Integer.parseInt(intent.getStringExtra("obiStoreId"));
        Log.i(TAG, "store: " + storeName + "; " + "obiStoreId: " + obiStoreId);
        Toast.makeText(this, "Ваш магаз: " + storeName, Toast.LENGTH_SHORT).show();

        presenter = new PresenterModuleThree(this, new ModelModuleThree(), this);
        presenter.requestDataFromServer(storeName, obiStoreId);

    }

    //кастомный тулбар
    public void initToolbar(boolean isTitleEnabled) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
        Button button = findViewById(R.id.buttonInToolBarInThirdMA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFour.class);
                startActivity(intent);
            }
        });
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.barcode_click, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.barcode_pic:
                Intent intent = new Intent(getBaseContext(), BarCodeActivity.class);
                startActivity(intent);
                return true;
            case R.id.product:
                Intent intent1 = new Intent(getBaseContext(), ProductActivity.class);
                startActivity(intent1);
                return true;
            case R.id.cartochkaIcon:
                Intent intent2 = new Intent(getBaseContext(), CartochkaActivity.class);
                startActivity(intent2);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //отображаем перечень товаров
    @Override
    public void setRecyclerWithProducts(ArrayList<ItemOfProducts> products) {
        RecyclerView.Adapter adapter = new RecyclerAdapterWithProducts(this, products);
        recyclerView.setAdapter(adapter);
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.list_layout_controller);
        recyclerView.setLayoutAnimation(controller);

    }

    //отображаем списки категорий
    @Override
    public void setRecyclerView(ArrayList<Category> categories) {
        RecyclerView.Adapter adapter = new RecyclerAdapter(this, categories, this);
        recyclerView.setAdapter(adapter);
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.list_layout_controller);
        recyclerView.setLayoutAnimation(controller);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onItemClick(int pos, Category category, TextView textView, ImageView imageView) {
        Toast.makeText(this, "сработал общий лисенер", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "category: " + category.getName());
        presenter.onItemRecyclerViewClicked(pos, category, textView, imageView);

    }

}

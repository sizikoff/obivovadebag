package com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.adapters.RecyclerViewAdapterForFindingProducts;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne.Product;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ItemOfProducts;

import java.util.ArrayList;

public class FindFragment extends Fragment implements Contract.MainView {

    Contract.Presenter presenter;
    RecyclerView recyclerView;
    Button buttonFind;

    private static final String TAG = "FindFragActFour";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_fourth_act, null);

        recyclerView = view.findViewById(R.id.recyclerViewInFragmentOneActivityFourth);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        presenter = new Presenter(this, new Model(), getContext());

        buttonFind = view.findViewById(R.id.buttonFindProductInFragmentFindFourthAct);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "buttonFind pressed");

                EditText editText = getActivity().findViewById(R.id.editTextInToolBarInForthMA);
                String findingProduct = editText.getText().toString();
                Log.i(TAG, "String findingProduct: " + findingProduct);

                if (findingProduct.length()<=2 || findingProduct.length()>=30) {
                    Toast.makeText(getContext(), "запрос должен быть от 3 до 30 символов", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.requestDataFromServer(findingProduct);
                }
            }
        });
        return view;
    }

    @Override
    public void setDataToRecycler(ArrayList<Product> products) {
        RecyclerViewAdapterForFindingProducts adapter = new RecyclerViewAdapterForFindingProducts(getContext(), products);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    public void nothingToShow() {
        Toast.makeText(getContext(), "ни одного совпадения не найдено", Toast.LENGTH_SHORT).show();
    }
}

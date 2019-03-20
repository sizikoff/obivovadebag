package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.commonClassesAndUtils.ServerAddress;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class  RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    private ArrayList<Category> productArray;
    private LayoutInflater inflater;
    private final RecyclerAdapterCallback listener;
    private Context context;
    Category category, myCategory;

    public RecyclerAdapter(Context context, ArrayList<Category> productArray, RecyclerAdapterCallback listener) {
        this.context = context;
        this.productArray = productArray;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.product_card, viewGroup, false);
        return new ViewHolder(view, listener, context, category);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int position) {
        category = productArray.get(position);
        viewHolder.textView.setText(category.getName());

        String src = productArray.get(position).getImage();
        Picasso.with(inflater.getContext()).load(ServerAddress.getbaseURL() + src).resize(50, 50).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return productArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final RecyclerAdapterCallback listener;
        final Context context;
        final TextView textView;
        final ImageView imageView;
        Category category;
        ViewHolder(View view, RecyclerAdapterCallback listener, final Context context, Category category){
            super(view);
            this.category = category;
            this.context = context;
            this.listener = listener;
            this.itemView.setOnClickListener(this);

            textView = view.findViewById(R.id.productNameInProductCard);
            imageView = view.findViewById(R.id.imageInProductCard);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "сработал лисенер на картинку", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View v) {
            myCategory = productArray.get(getAdapterPosition());
            Log.i(TAG, "Mycategory.getName(): " + myCategory.getName());
            listener.onItemClick(getAdapterPosition(), myCategory, textView, imageView);

        }
    }

    //интерфейс для создания общего слушателя
    public interface RecyclerAdapterCallback {
        void onItemClick(int pos, Category category, TextView textView, ImageView imageView);
    }
}
package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.geolocationcheckautomaticly.R;


import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ItemOfProducts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapterWithProducts extends RecyclerView.Adapter<RecyclerAdapterWithProducts.ViewHolder> {

    private static final String TAG = "RecyclerAdapterWithP";
    public ArrayList<ItemOfProducts> products;
    private LayoutInflater inflater;
    private Context context;
    ItemOfProducts itemOfProducts;

    public RecyclerAdapterWithProducts(Context context, ArrayList<ItemOfProducts> products) {
        this.context = context;
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_of_products_card, viewGroup, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        itemOfProducts = products.get(position);

        viewHolder.textViewName.setText(itemOfProducts.getName());
        viewHolder.textViewPrice.setText(itemOfProducts.getPrice().toString());
        viewHolder.textViewQuantity.setText(itemOfProducts.getQuantity().toString());

        String src = "https" + ((itemOfProducts.getImage().get(0)).substring(4));
        Picasso.with(inflater.getContext()).load(src).resize(150, 150).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Context context;
        TextView textViewName, textViewPrice, textViewQuantity;
        ImageView imageView;

        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            this.context = context;
            imageView = itemView.findViewById(R.id.imageInItemOfProductsCard);
            textViewName = itemView.findViewById(R.id.productNameInItemOfProductsCard);
            textViewPrice = itemView.findViewById(R.id.productPriceInItemOfProductsCard);
            textViewQuantity = itemView.findViewById(R.id.productQuantityInItemOfProductsCard);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemOfProducts = products.get(getAdapterPosition());
                    ArrayList<String> pictures = new ArrayList<>();

                    for (int i = 0; i<itemOfProducts.getImage().size(); i++) {
                        String src = "https" + ((itemOfProducts.getImage().get(i)).substring(4));
                        pictures.add(src);
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(R.layout.dialog_listview, null);
                    ListView listView = view.findViewById(R.id.listViewInDLV);

                    ListViewAdapter adapter = new ListViewAdapter(context, pictures);
                    listView.setAdapter(adapter);
                    view.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));

                    builder.setView(view);
                    AlertDialog dialog = builder.create();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.show();

                   }
            });
        }
    }
}



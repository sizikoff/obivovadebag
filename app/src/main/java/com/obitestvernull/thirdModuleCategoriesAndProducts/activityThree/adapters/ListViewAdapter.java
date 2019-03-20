package com.obitestvernull.thirdModuleCategoriesAndProducts.activityThree.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.geolocationcheckautomaticly.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {

    private static final String TAG = "ListViewAdapter";
    Context context;
    LayoutInflater inflater;
    ArrayList<String> pictures;

    public ListViewAdapter(Context context, ArrayList<String> pictures) {
        this.context = context;
        this.pictures = pictures;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_listview, null);
        ImageView image = view.findViewById(R.id.imageViewInItemListView);
        Picasso.with(inflater.getContext()).load(pictures.get(position)).into(image);
        //.resize(800, 1200)
        return view;
    }
}

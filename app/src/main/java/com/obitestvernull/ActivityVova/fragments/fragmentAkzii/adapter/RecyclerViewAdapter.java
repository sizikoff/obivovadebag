package com.obitestvernull.ActivityVova.fragments.fragmentAkzii.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;
import com.obitestvernull.commonClassesAndUtils.ServerAddress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "РесайклАдаптер";

    //vars
    private ArrayList<ItemAkzii> mImageUrls;
    private Context mContext;
    private LayoutInflater inflater;


    public RecyclerViewAdapter(Context context, ArrayList<ItemAkzii> imageUrls) {
        mImageUrls = imageUrls;
        mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listotem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        String src = ServerAddress.getbaseURL() + (mImageUrls.get(position).getImage());
        Log.i(TAG,src);

        Picasso.with(inflater.getContext()).load(src).resize(300, 150).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
        }
    }
}

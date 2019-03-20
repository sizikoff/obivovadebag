package com.obitestvernull.ActivityVova.fragments.fragmentPopular.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.geolocationcheckautomaticly.R;
import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewPopularAdapter extends RecyclerView.Adapter<RecyclerViewPopularAdapter.ViewHolder> {

    private static final String TAG = "resview";

    //vars
    private ArrayList<Popular> mImageUrls1;
    private Context mContext;
    private LayoutInflater inflater;


    public RecyclerViewPopularAdapter(Context context, ArrayList<Popular> imageUrls) {
        mImageUrls1 = imageUrls;
        mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_popularitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String src = "https" +(mImageUrls1.get(position).getImage().substring(4));
        Log.i(TAG,src);

        Picasso.with(inflater.getContext()).load(src).resize(300, 150).into(holder.image11);

    }

    @Override
    public int getItemCount() {
        return mImageUrls1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image11;

        public ViewHolder(View itemView) {
            super(itemView);
            image11 = itemView.findViewById(R.id.image_view1);
        }
    }
}
